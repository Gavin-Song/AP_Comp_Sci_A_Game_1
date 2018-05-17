import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Button x = new Button(100, 100, 300, 80, "button");
        
        PhysicalObject z = new Helicopter(50, 50, "Bob");
        addObject(z, 30, 30);
        
        addObject(x, x.getx(), x.gety());
    }
}
