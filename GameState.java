public class GameState  
{
    public static int TOTAL_CITY_HEALTH = 10000;
    public static int TOTAL_RESOURCE = 10000;
    
    private int city_health = 10000;
    private long score = 0;
    
    private int player_base_health = Config.HELICOPTER_LIFE;
    private int player_health = player_base_health;
    private int player_resource = 0;
    
    private int player_resource_rate = 1;
    private int player_regen_rate = 0;
    
    private Spawner spawner;
    private long start_time;
    private int game_length; // Game length in seconds
    
    public GameState() {
        spawner = new Spawner();
        start_time = System.currentTimeMillis();
        game_length = Spawner.WAVES.length * Spawner.TIME_BETWEEN_WAVES + Spawner.END_GAME_EXTRA_TIME;
    }
    
    public void update() {
        this.player_resource += this.player_resource_rate;
        this.player_health += this.player_regen_rate;
        
        this.player_resource = Math.min(TOTAL_RESOURCE, this.player_resource);
        this.player_health = Math.min(this.player_base_health, this.player_health);
    }
    
    public String getGameTimeRemaining() {
        int seconds_passed = (int)((System.currentTimeMillis() - start_time) / 1000);
        int time_remaining = game_length - seconds_passed;
        
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
    
    public int getPlayerResourceRate() {
        return this.player_resource_rate;
    }
    
    public int getPlayerRegenRate() {
        return this.player_regen_rate;
    }
}
