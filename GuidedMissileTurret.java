import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuidedMissileTurret extends Turret
{
    public GuidedMissileTurret (int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "missile_gun", team);
        this.setRandomness(0.0, 0.0);
        this.setBulletSpeed(Config.BASIC_BULLET_SPEED * 0.4);
        this.setFireRate(220);
    }
    
    public String getName() {
        return "Missile";
    }
}
