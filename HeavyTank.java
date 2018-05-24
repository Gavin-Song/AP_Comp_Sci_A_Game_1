import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeavyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeavyTank extends WombatLandUnit
{
    public HeavyTank(){
        super(80, 40, 600, "WA-Armadillo", "Heavy Landcruiser"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new StrongTankTurret(10, 5, -10, 5, "wombat"));
        this.getTurrets().add(new WeakGatlingGun(10, 5, 5, 5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2);
        super.act();
    }    
}
