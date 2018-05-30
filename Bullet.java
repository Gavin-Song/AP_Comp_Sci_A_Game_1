import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bullet extends PhysicalObject
{
    private int damage;
    private double life;
    private String team;
    
    public Bullet(int w, int h, double life, int damage, String team) {
        super(w, h, Config.BULLET_MASS);
        this.damage = damage;
        this.life = life;
        this.team = team;
        
        this.setGravity(false);
        this.setDoGroundCollision(false);
        this.setFriction(false);
    }
    
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        
        this.life--;
        if (this.life <= 0) {
            this.getWorld().removeObject(this);
        }
        
        try {
            List intersect = this.getWorld().getObjectsAt(
                (int)(this.getX() + this.getvx()),
                (int)(this.getY() + this.getvy()), null);
            if (intersect.size() == 0) {
                // Try finding via image intersect instead
                intersect = this.getIntersectingObjects(null);
            }
                
                
            if (intersect.size() > 0) {
                if (intersect.get(0) instanceof Collidable || 
                    this.getY() + this.getvy() >= Config.GROUND_Y - this.geth() / 2) {
                    // Collidable terrain object
                    this.life = 0;
                }
                else if (intersect.get(0) instanceof CombatUnit) {
                    CombatUnit collided = (CombatUnit)intersect.get(0);
                    if ("human".equals( (collided).getTeam() ) && "wombat".equals(this.team) ||
                        "wombat".equals( (collided).getTeam() ) && "human".equals(this.team)) {
                        this.life = 0;
                        this.affectEnemy(collided);
                        collided.subtractHealth(this.damage);
                    }
                } 
            }
        } catch(IllegalStateException e) {} // Why greenfoot call act before adding?!
    }    
    
    public double getlife() {
        return this.life;
    }
    
    public double getdamage() {
        return this.damage;
    }
    
    public void affectEnemy(CombatUnit c) {
        // Empty for now. can be overriden
    }
    
    public String getTeam() {
        return this.team;
    }
}
