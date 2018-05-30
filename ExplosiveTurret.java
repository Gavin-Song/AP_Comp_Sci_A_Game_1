import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplosiveTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosiveTurret extends Turret
{
    public ExplosiveTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "explosive_gun", team);
        this.setRandomness(0.9, 0.03);
        this.setFireRate(40);
        this.setDamage(20);
        this.setBulletSpeed(Config.BASIC_BULLET_SPEED * 0.2);
    }
    
    public String getName() {
        return "Explosive";
    }
}
