import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Helicopter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helicopter extends PhysicalObject
{
    
    public Helicopter(int w, int h, String name) {
        super(w, h);
    }
    
    /**
     * Act - do whatever the Helicopter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        if(Greenfoot.isKeyDown("UP")){
            setvy(getvy() - Config.UP_ACCEL);
        }
        if(Greenfoot.isKeyDown("LEFT")){
            setvx(-2);
        }
        if(Greenfoot.isKeyDown("RIGHT")){
            setvx(2);
        }
        
        // Add your action code here.
    }    
}
