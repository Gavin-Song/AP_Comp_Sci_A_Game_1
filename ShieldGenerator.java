import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShieldGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldGenerator extends WombatLandUnit
{
    public ShieldGenerator(){
        super(350, 150, 1500, "Tree of Life", "Mobile Shield Dome Generator", 2); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        /* Shield generator has no turrets */
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }        
}
