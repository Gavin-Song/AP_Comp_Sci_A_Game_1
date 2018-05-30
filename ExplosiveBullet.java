import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExplosiveBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplosiveBullet extends Bullet
{
    public ExplosiveBullet(String team) {
        this(team, 1);
    }
    
    public void affectEnemy(CombatUnit c) {
        try {
            PhysicalObject unit = (PhysicalObject)c;
            Explosion boom = new Explosion((int)this.getdamage(), 100, this.getTeam());
            this.getWorld().addObject(boom, unit.getX(), unit.getY());
        } catch (ClassCastException e) {
            // Do nothing I guess
        }
    }
    
    public ExplosiveBullet(String team, int damage) {
        super(10, 4, 50, damage, team); // width, height, life, damage
        this.setGravity(false);
        this.setFriction(false);        
    }  
}
