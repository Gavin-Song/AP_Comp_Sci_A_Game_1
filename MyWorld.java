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
    
    public static int frame_count = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1200, 800, 1, false);  // width, height, cell size, border
        
        // Important world variables
        camera = new Camera();
        unit_card = new UnitDisplayCard();
        addObject(unit_card, 10 + UnitDisplayCard.width / 3, 800 - UnitDisplayCard.height / 4 + 15);
        this.setPaintOrder(UnitDisplayCard.class, Button.class, PhysicalObject.class, LandTile.class);
        
        
        Button x = new Button(100, 100, 300, 80, "button");
        
        helicopter = new Helicopter(50, 50, "Bob");
        addObject(helicopter, 600, 250);
        
        for (int i=-12; i<12 * 6; i++) {
            LandTile t = new LandTile(100, 100);
            addObject(t, i * 100 + 50, 750);
        }
        
        addObject(x, x.getx(), x.gety());
        
        for(int i=0;i<1;i++){
            WombatLandUnit lab = new Flamethrower();
            addObject(lab, 1200 + i * 100, 500);
        }
        
        WombatLandUnit a = new T3AntiAir();
            addObject(a, 1200 + 2 * 100, 500);
    }
    
    public void act() {
        super.act();

        frame_count = (frame_count + 1) % 120;
    }
}
