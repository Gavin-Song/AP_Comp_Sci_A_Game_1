import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tank extends WombatLandUnit
{
    public Tank(){
        super(80, 40, 30, "WA6 Devil", "Light Landcruiser", 30); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new WeakTankTurret(30, 15, 0, -5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }    
}
