import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MobileMissileLauncher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MobileMissileLauncher extends WombatLandUnit
{
    public MobileMissileLauncher(){
        super(80, 40, 150, "Javelin", "Mobile Misile Launcher", 120); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new GuidedMissileTurret(30, 20, 10, -10, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }    
}
