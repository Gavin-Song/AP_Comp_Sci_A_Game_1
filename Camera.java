import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Camera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Camera
{
    private int dx = 0;
    private int dy = 0;
    
    private int x = 0;
    private int y = 0;
    
    public Camera()
    {
        // Does nothing at the moment
    }
    
    public void scrollX(int shift_x, World world) {
        this.dx = shift_x;
        this.x += shift_x;
        this.doScroll(world);
    }
    
    public void doScroll(World world) {
        List objects = world.getObjects(null);
        for (Object obj : objects) {
            try {
                Actor actor = (Actor)obj;
                if (actor instanceof Helicopter) {
                    continue;
                }
                
                actor.setLocation(actor.getX() + this.dx, actor.getY());
            } catch (ClassCastException e) { // do nothing
            }
        }
    }

}
