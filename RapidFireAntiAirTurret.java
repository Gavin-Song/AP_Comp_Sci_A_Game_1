import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RapidFireAntiAirTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RapidFireAntiAirTurret extends MachineGunTurret
{
    public RapidFireAntiAirTurret (int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, team);
        this.setRandomness(0.03, 0.0);
        this.setBulletSpeed(Config.BASIC_BULLET_SPEED);
        this.setFireRate(2);
    }
}
