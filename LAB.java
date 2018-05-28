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
        super(30, 30, 10, "WLB-X", "Light Assault Wombot"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new WeakGatlingGun(10, 5, 0, 5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-5);
        super.act();
    }    
}
