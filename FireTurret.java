import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireTurret extends Turret
{
    public FireTurret(int w, int h, int rx, int ry) {
        super(w, h, rx, ry, "fire_gun");
        this.setRandomness(0.9, 0.03);
        this.setBulletSpeed(Config.BASIC_BULLET_SPEED * 0.2);
    }
}
