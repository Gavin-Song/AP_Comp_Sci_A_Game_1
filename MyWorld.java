import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        
        camera = new Camera();
        
        Button x = new Button(100, 100, 300, 80, "button");
        
        helicopter = new Helicopter(50, 50, "Bob");
        addObject(helicopter, 600, 250);
        
        for (int i=-12; i<12 * 6; i++) {
            LandTile t = new LandTile(100, 100);
            addObject(t, i * 100 + 50, 750);
        }
        
        addObject(x, x.getx(), x.gety());
        
        for(int i=0;i<5;i++){
            WombatLandUnit lab = new HeavyTank();
            addObject(lab, 1200 + i * 100, 500);
        }
    }
}
