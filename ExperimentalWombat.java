import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExperimentalWombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExperimentalWombat extends WombatLandUnit
{
    public ExperimentalWombat(){
        super(300, 150, 6000, "Wombot Prime", "Experimental MegaWombot", 5000); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        this.getTurrets().add(new MachineGunTurret(30, 15, 50, -10, "wombat"));
        this.getTurrets().add(new ShellTurret(30, 15, -50, -50, "wombat"));
        this.getTurrets().add(new ShellTurret(30, 15, -50, -10, "wombat"));
        this.getTurrets().add(new ShellTurret(30, 15, -50, 30, "wombat"));
        this.getTurrets().add(new MagneticTurret(30, 15, 0, -30, "wombat"));
        this.getTurrets().add(new EMPTurret(30, 15, 0, 0, "wombat"));
    }
    
    public void act() 
    {
        this.setvx(-1.1);
        super.act();
    }     
}
