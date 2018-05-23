import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SupplyTruck extends WombatLandUnit
{
    public SupplyTruck(){
        super(80, 40, 23, "Mobile Garden", "Wombat Supply Truck"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        // No turrets
    }
    
    public void act() 
    {
        this.setvx(-3.5);
        super.act();
    }    
}
