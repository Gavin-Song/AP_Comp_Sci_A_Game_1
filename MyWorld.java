import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    public static Helicopter helicopter;
    public static Camera camera;
    public static UnitDisplayCard unit_card;
    public static GameState game_state;
    
    public static HealthBar city_health;
    public static HealthBar player_health;
    public static HealthBar player_resource;
    
    public static HashMap upgrade_buttons;

    private GameOverCard card;
    
    public static final int WORLD_WIDTH = 1200;
    public static final int WORLD_HEIGHT = 600;
    
    public static int frame_count = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(WORLD_WIDTH, WORLD_HEIGHT, 1, false);  // width, height, cell size, border
        
        // Background
        this.getBackground().scale(WORLD_WIDTH, WORLD_HEIGHT);
        
        
        // Important world variables
        camera = new Camera();
        game_state = new GameState();
        unit_card = new UnitDisplayCard();
        
        player_health = new HealthBar("Player Health", 100);
        city_health = new HealthBar("City Health", GameState.TOTAL_CITY_HEALTH);
        player_resource = new HealthBar("Resource", GameState.TOTAL_RESOURCE);
        
        addObject(unit_card, 10 + UnitDisplayCard.width / 2, WORLD_HEIGHT - UnitDisplayCard.height / 2 - 10);
        addObject(player_health, 10 + HealthBar.width / 2, 10 + HealthBar.height / 2);
        addObject(city_health, 10 + HealthBar.width / 2, 40 + HealthBar.height / 2);
        addObject(player_resource, 10 + HealthBar.width / 2, 70 + HealthBar.height / 2);

        
        // Upgrade the player buttons
        upgrade_buttons = new HashMap();
        for (int i=0; i<GameState.possible_upgrades.length; i++) {
            Button to_add = new UpgradeButton(110, 50, 
                (i+1) + "] " + GameState.possible_upgrades[i] + "++",
                GameState.possible_upgrades[i].toLowerCase(),
                i + 1);
            upgrade_buttons.put(GameState.possible_upgrades[i].toLowerCase(), to_add);
            addObject(to_add, 370 + i * 120, 40);
        }
        
        
        // GUI is drawn first, then game objects, then the ground
        this.setPaintOrder(GameOverCard.class, GUI.class, Turret.class, Thruster.class, PhysicalObject.class, LandTile.class);
        
        
        helicopter = new Helicopter(250, 125, "Bob");
        addObject(helicopter, 600, 250);
        
        for (int i=-12 * 5; i<12 * 2; i++) {
            LandTile t = new LandTile(100, 100);
            addObject(t, i * 100 + 50, WORLD_HEIGHT - 50);
        }
   
        
        /* for(int i=0;i<30;i++){
            WombatLandUnit lab = new Tank();
            addObject(lab, 1200 + i * 100, WORLD_HEIGHT - 300);
        }
        
        WombatLandUnit a = new ShieldGenerator();
            addObject(a, 1200 + 2 * 100, WORLD_HEIGHT - 300); */
    }
    
    public void act() {
        super.act();
        game_state.update();
        
        // Display score and time remaining
        if (game_state.isGameOver() == 0) {
            this.showText(String.format("Score %010d", (int)game_state.getScore()), 100, 130);
            this.showText("Time left: " + game_state.getGameTimeRemaining(), 87, 150);
            this.showText(String.format("Wave %03d", game_state.getSpawner().getWave()), 59, 170);
        }
        
        // Render the cit and player health bars
        player_resource.updateLabel("Resource (+" + game_state.getPlayerResourceRate() + ")");
        player_health.updateLabel("Player Health (+" + game_state.getPlayerRegenRate() + ")");
        
        city_health.updateHealth((int)game_state.getCityHealth());
        player_health.updateTotalHealth(game_state.getPlayerBaseHealth());
        player_health.updateHealth(game_state.getPlayerHealth());
        player_resource.updateTotalHealth(game_state.getTotalPlayerResource());
        player_resource.updateHealth(game_state.getPlayerResource());
        
        // Spawn waves if needed
        if (game_state.getSpawner().shouldSpawnWave()) {
            game_state.getSpawner().createWave(this);
        }
        
        if (card == null) {
            if (game_state.isGameOver() == 2) {
                helicopter.subtractHealth(100000);
                card = new BadGameOverCard();
                addObject(card, WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
            }
            else if (game_state.isGameOver() == 1) {
                helicopter.subtractHealth(100000);
                card = new GoodGameOverCard();
                addObject(card, WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
            }
        }

        frame_count = (frame_count + 1) % 120;
    }
}
