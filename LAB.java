import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LAB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LAB extends WombatLandUnit
{
    public LAB(){
        super(20, 20, 10, "WLB-X", "Light Wombat Assault Bot"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new MachineGunTurret(10, 5, -10, 5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-5);
        super.act();
    }    
}
