import java.util.*;

public class GameState  
{
    public static int TOTAL_CITY_HEALTH = 5000;  // Max city health
    public static int TOTAL_RESOURCE = 5000;  // Base max resource
    public static double COST_MULTIPLIER = 1.5; // How much more expensive upgrade gets each time
    
    private int city_health = TOTAL_CITY_HEALTH;
    private long score = 0;
    
    // Upgrades
    private int player_base_health = Config.HELICOPTER_LIFE;
    private int player_health = player_base_health;
    private int player_resource = 0;
    private int player_resource_rate = 1;
    private int player_total_resource = TOTAL_RESOURCE;
    private int player_regen_rate = 0;
    private int player_turret_count = 0;
    private HashMap upgrade_costs;
    
    public static String[] possible_upgrades = {
        "Regen", "Turret", "Health", "Resource"
    };
    
    private Spawner spawner;
    private long start_time;
    private int game_length; // Game length in seconds
    
    public GameState() {
        spawner = new Spawner();
        start_time = System.currentTimeMillis();
        game_length = Spawner.WAVES.length * Spawner.TIME_BETWEEN_WAVES + Spawner.END_GAME_EXTRA_TIME;
       
        upgrade_costs = new HashMap();
        for (String category: possible_upgrades) {
            upgrade_costs.put(category.toLowerCase(), 1000);
        }
    }
    
    public void update() {
        if (Math.random() < 0.4) {
            this.player_resource += this.player_resource_rate;
        }
        if (Math.random() < 0.14) {
            this.player_health += this.player_regen_rate;
        }
        
        this.player_resource = Math.min(this.player_total_resource, this.player_resource);
        this.player_health = Math.min(this.player_base_health, this.player_health);
        
        this.player_health = Math.max(this.player_health, 0);
        this.city_health = Math.max(this.city_health, 0);
        
        this.player_resource = 9999999;
    }
    
    public int isGameOver() {
         /* Game over checks */
        if (city_health <= 0 || player_health <= 0) {
            return 2;
        } else if (this.getTimeRemaining() <= 0) {
            return 1;
        }
        return 0;
    }
 
    
    public void doUpgrade(String category) {
        // Invalid upgrade category
        if (!upgrade_costs.containsKey(category)) {
            return;
        }
        
        // Upgrade is too expensive
        int cost = (int)upgrade_costs.get(category);
        if (cost > this.player_resource) {
            return;
        }

        // Do the upgrade
        if ("regen".equals(category)) {
            this.player_regen_rate += 1;
        }
        else if ("turret".equals(category)) {
            Turret t = null;
            switch (this.player_turret_count) {
                case 0: {
                    t = new WeakGatlingGun(36, 20, -120, 30, "human");
                    break;
                }
                case 1: {
                    t = new StrongTankTurret(30, 10, -50, 55, "human");
                    break;
                }
                case 2: {
                    t = new MachineGunTurret(50, 30, 90, -40, "human");
                    break;
                }
                case 3: {
                    // Remove the MachineGunTurret for a Missile launcher
                    MyWorld.helicopter.removeTurret(3);
                    t = new GuidedMissileTurret(60, 30, 90, -40, "human");
                    break;
                }
                case 4: {
                    // Remove the ShellTurret for an EMPTurret
                    MyWorld.helicopter.removeTurret(2);
                    t = new EMPTurret(30, 10, -50, 55, "human");
                    break;
                }
                case 5: {
                    // Swap missile turret for fire turret
                    MyWorld.helicopter.removeTurret(2);
                    t = new FireTurret(60, 30, 90, -40, "human");
                    break;
                }
                case 6: {
                    // Swap out fireturret for fireball turret
                    MyWorld.helicopter.removeTurret(3);
                    t = new ExplosiveTurret(60, 30, 90, -40, "human");
                    break;
                }
                case 7: {
                    // Swap out machine gun for quantum turret
                    MyWorld.helicopter.removeTurret(0);
                    t = new QuantumTurret(50, 30, 20, 45, "human");
                    break;
                }
                case 8: {
                    // Swap out weak gatling turret for quantum turret
                    MyWorld.helicopter.removeTurret(1);
                    t = new QuantumTurret(36, 20, -120, 30, "human");
                    break;
                }
                default: {
                    // Not upgradable
                    break;
                }
            }
            if (t == null) {
                return;
            }
            
            this.player_turret_count++;
            t.removeAngleRotationLimits();
            MyWorld.helicopter.addTurret(t);
        }
        else if ("health".equals(category)) {
            this.player_base_health += 2000;
        }
        else if ("resource".equals(category)) {
            this.player_resource_rate += 1;
            this.player_total_resource *= 1.75;
        }
        
        // Make the new upgrade even more expensive
        upgrade_costs.put(category, (int)(cost * COST_MULTIPLIER));
        this.player_resource -= cost;
    }
    
    public int getCost(String category) {
        return (int)upgrade_costs.get(category);
    }
    
    public int getTimeRemaining() {
        return game_length - this.getSecondsPassed();
    }
    
    public int getSecondsPassed() {
        return (int)((System.currentTimeMillis() - start_time) / 1000);
    }
    
    public String getGameTimeRemaining() {
        int time_remaining = this.getTimeRemaining();
        
        int minutes = time_remaining / 60;
        int seconds =  time_remaining % 60;
        return (minutes < 10 ? "0" + minutes : minutes)
            + ":" 
            + (seconds < 10 ? "0" + seconds : seconds);            
    }

    public void addPlayerResource(int add) {
        this.player_resource += add;
    }
    
    public void updatePlayerBaseHealth(int n) {
        this.player_base_health = n;
    }
    
    public void updatePlayerHealth(int n) {
        this.player_health = 0;
    }
    
    public void addPlayerBaseHealth(int add) {
        this.player_base_health += add;
    }
    
    public void addPlayerHealth(int add) {
        this.player_health += add;
    }
    
    public void damageCity(int damage) {
        this.city_health -= damage;
    }
    
    public void incrementScore(long add) {
        this.score += add;
    }
    
    public long getScore() {
        return score;
    }
    
    public int getCityHealth() {
        return this.city_health;
    }
    
    public int getPlayerBaseHealth() {
        return this.player_base_health;
    }
    
    public Spawner getSpawner() {
        return this.spawner;
    }
    
    public int getPlayerHealth() {
        return this.player_health;
    }
    
    public int getPlayerResource() {
        return this.player_resource;
    }
    
    public int getTotalPlayerResource() {
        return this.player_total_resource;
    }
    
    public int getPlayerResourceRate() {
        return this.player_resource_rate;
    }
    
    public int getPlayerRegenRate() {
        return this.player_regen_rate;
    }

}
