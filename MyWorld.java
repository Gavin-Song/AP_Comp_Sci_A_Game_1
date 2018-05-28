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

    public static PhysicalObject helicopter;
    public static Camera camera;
    public static UnitDisplayCard unit_card;
    public static GameState game_state;
    
    public static final int WORLD_WIDTH = 1100;
    public static final int WORLD_HEIGHT = 700;
    
    public static int frame_count = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(WORLD_WIDTH, WORLD_HEIGHT, 1, false);  // width, height, cell size, border
        
        // Important world variables
        camera = new Camera();
        game_state = new GameState();
        unit_card = new UnitDisplayCard();
        addObject(unit_card, 10 + UnitDisplayCard.width / 2, WORLD_HEIGHT - UnitDisplayCard.height / 2 - 10);
        
        
        
        this.setPaintOrder(UnitDisplayCard.class, Button.class, PhysicalObject.class, LandTile.class);
        
        Button x = new Button(100, 100, 300, 80, "button");
        
        helicopter = new Helicopter(50, 50, "Bob");
        addObject(helicopter, 600, 250);
        
        for (int i=-12 * 5; i<12 * 2; i++) {
            LandTile t = new LandTile(100, 100);
            addObject(t, i * 100 + 50, WORLD_HEIGHT - 50);
        }
        
        addObject(x, x.getx(), x.gety());
        
        for(int i=0;i<30;i++){
            WombatLandUnit lab = new PotatoTruck();
            addObject(lab, 1200 + i * 100, WORLD_HEIGHT - 300);
        }
        
        WombatLandUnit a = new ShieldGenerator();
            addObject(a, 1200 + 2 * 100, WORLD_HEIGHT - 300);
    }
    
    public void act() {
        super.act();
        
        this.showText(String.format("Score %010d", (int)game_state.getScore()), 100, 20);
        this.showText(String.format("City HP %05d", (int)game_state.getCityHealth()), 78, 40);

        frame_count = (frame_count + 1) % 120;
    }
}
