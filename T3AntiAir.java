import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class T3AntiAir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T3AntiAir extends WombatLandUnit
{
    public T3AntiAir(){
        super(110, 50, 400, "Slaughterhouse", "Mobile Rapid Fire Anti-Air Ordnance"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new RapidFireAntiAirTurret(40, 23, -10, -15, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }       
}
