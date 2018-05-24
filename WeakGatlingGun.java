import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeakGatlingGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeakGatlingGun extends MachineGunTurret
{
    public WeakGatlingGun(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, team);
        this.setFireRate(15);
        this.setDamage(5);
        this.setRotationLimit(180, 235);
    }  
}
