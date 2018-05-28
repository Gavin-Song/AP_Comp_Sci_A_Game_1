import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotatoTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotatoTurret extends Turret
{
     public PotatoTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "potato_gun", team);
        this.setRandomness(0.2, 0.01);
        this.setFireRate(50);
    }  
    
    public String getName() {
        return "Potato";
    }  
}
