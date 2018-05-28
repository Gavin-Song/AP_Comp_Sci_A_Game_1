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
    
    /* Camera x and y values are "backwards" from normal (left = pos, right = neg) */
    private int x_left_bound = MyWorld.WORLD_WIDTH;
    private int x_right_bound = -MyWorld.WORLD_WIDTH * 5;

    public Camera()
    {
        // Does nothing at the moment
    }
    
    public void scrollX(int shift_x, World world) {
        /* Camera x and y values are "backwards" from normal (left = pos, right = neg) */
        if (this.x + shift_x < this.x_right_bound || this.x + shift_x > this.x_left_bound) {
            return;
        }
        
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
                else if (actor instanceof GUI) {
                    continue;
                }
                
                actor.setLocation(actor.getX() + this.dx, actor.getY());
            } catch (ClassCastException e) { // do nothing
            }
        }
    }

}
