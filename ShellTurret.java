import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShellTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShellTurret extends Turret
{
    public ShellTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "shell_gun", team);
        this.setRandomness(0.2, 0.01);
        this.setFireRate(10);
    }  
    
    public String getName() {
        return "Shell";
    }
}
