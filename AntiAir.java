import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AntiAir extends WombatLandUnit
{
    public AntiAir(){
        super(80, 40, 30, "Honeyeater", "Light Mobile Anti-air Cannon"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new MachineGunTurret(10, 5, -10, 5, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }    
}
