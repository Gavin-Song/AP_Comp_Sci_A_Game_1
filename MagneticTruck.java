import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MagneticTruck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagneticTruck extends WombatLandUnit
{
    public MagneticTruck(){
        super(100, 50, 50, "Eucalyptus", "Magnetic Tractor Truck", 70); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new MagneticTurret(40, 23, 0, -5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2);
        super.act();
    }    
}
