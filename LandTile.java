import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LandTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LandTile extends Actor implements Collidable
{
    public LandTile(int w, int h) {
        this.getImage().scale(w, h);
    }
    
    /**
     * Does nothing. This tile simply exists
     * as a decorational object.
     */
    public void act() {}    
}
