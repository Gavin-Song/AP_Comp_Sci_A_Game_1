import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurtleTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurtleTank extends WombatLandUnit
{
    public TurtleTank(){
        super(80, 40, 500, "Turtle Mark 3", "Heavy Siege Tank", 250); // width, height, health, name, desc
        this.setFriction(false);
    }
    
    public void createTurrets() {
        /* Siege tank has no weapons */
    }
    
    public void act() 
    {
        this.setvx(-1.5);
        super.act();
    }    
}
