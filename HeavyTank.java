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
        super(80, 40, 600, "WA-Armadillo", "Heavy Landcruiser", 150); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new StrongTankTurret(40, 20, 0, -10, "wombat"));
        this.getTurrets().add(new WeakGatlingGun(30, 15, -20, 0, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2);
        super.act();
    }    
}
