import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeakTankTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeakTankTurret extends ShellTurret
{
    public WeakTankTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, team);
        this.setFireRate(80);
        this.setDamage(10);
        this.setRotationLimit(180, 185);
    }  
}
