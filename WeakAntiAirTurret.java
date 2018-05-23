import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeakAntiAirTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeakAntiAirTurret extends MachineGunTurret
{
    public WeakAntiAirTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, team);
        this.setFireRate(40);
        this.setRotationLimit(180, 225);
    }  
}
