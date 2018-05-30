import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Stun turret. Fires EMPBullets that freeze
 * units in place.
 * 
 * @author (Gavin Song) 
 * @version (1.0.0)
 */
public class EMPTurret extends Turret
{
    public EMPTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "emp_gun", team);
        this.setDamage(0);
        this.setFireRate(3);
    }

    public String getName() {
        return "EMP Weapon";
    }
}
