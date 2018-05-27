import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamethrower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamethrower extends WombatLandUnit
{
    public Flamethrower(){
        super(90, 40, 280, "tasmanian devil", "Flamethrower Vehicle"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new FireTurret(40, 23, 10, -15, "wombat"));
        this.getTurrets().add(new WeakTankTurret(40, 23, -10, -15, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-1.7);
        super.act();
    }
}
