import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WombatLandUnit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class WombatLandUnit extends PhysicalObject
{
    private double life;
    
    public WombatLandUnit(int w, int h, double life, double damage) {
        super(w, h, 10);
        this.life = life;
    }
    
    public void act() 
    {
        this.setvx(-10);
    }    
}
