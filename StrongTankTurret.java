import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StrongTankTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrongTankTurret extends ShellTurret
{
    public StrongTankTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, team);
        this.setFireRate(100);
        this.setDamage(70);
        this.setRotationLimit(180, 185);
    }  
}
