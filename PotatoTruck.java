import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotatoTruck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotatoTruck extends WombatLandUnit
{
    public PotatoTruck(){
        super(80, 40, 10, "Potato Truck", "Light Potatocruiser"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new PotatoTurret(30, 15, 0, -10, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-3);
        super.act();
    }    
}
