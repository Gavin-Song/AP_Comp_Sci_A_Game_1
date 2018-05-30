import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EMPCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EMPCannon extends WombatLandUnit
{
    public EMPCannon(){
        super(80, 40, 30, "Coldflash", "Mobile EMP Cannon"); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new EMPTurret(30, 20, 0, -10, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-2.5);
        super.act();
    }    
}
