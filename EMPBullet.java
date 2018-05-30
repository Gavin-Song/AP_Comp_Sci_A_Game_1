import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EMPBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EMPBullet extends Bullet
{
    public EMPBullet(String team) {
        this(team, 1);
    }
    
    public void affectEnemy(CombatUnit c) {
        try {
            PhysicalObject unit = (PhysicalObject)c;
            unit.setLocation((int)(unit.getX() - unit.getvx()), (int)(unit.getY() - unit.getvy()));
        } catch (ClassCastException e) {
            // Do nothing I guess
        }
    }
    
    public EMPBullet(String team, int damage) {
        super(10, 4, 50, damage, team); // width, height, life, damage
        this.setGravity(false);
        this.setFriction(false);        
    }
}
