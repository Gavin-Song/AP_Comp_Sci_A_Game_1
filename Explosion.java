import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends PhysicalObject
{
    private int damage;
    private double life;
    private double start_life;
    private String team;
    
    public static int RADIUS = 100;
    
    public Explosion(int damage, double life, String team) {
        super(2, 2, 0);
        this.setGravity(false);
        this.setDoGroundCollision(false);
        this.setFriction(false);
        
        this.damage = damage;
        this.life = life;
        this.start_life = life;
        this.team = team;
        
        this.getImage().setTransparency(100);
    }
    
    public void act() 
    {
        super.act();
        if (this.life <= 0) {
            this.getWorld().removeObject(this);
        }
        
        try {
            List intersect = this.getNeighbours(Explosion.RADIUS, false, PhysicalObject.class);
                
            for (int i=0; i<intersect.size(); i++) {
                if (intersect.get(i) instanceof CombatUnit) {
                    CombatUnit collided = (CombatUnit)intersect.get(i);
                    if ("human".equals( (collided).getTeam() ) && "wombat".equals(this.team) ||
                        "wombat".equals( (collided).getTeam() ) && "human".equals(this.team)) {
                        collided.subtractHealth(this.damage);
                        
                        // TODO apply a force
                    }
                } 
            }
        } catch(IllegalStateException e) {} // Why greenfoot call act before adding?!
        
        if (this.life == (int)(this.start_life * 0.4)) {
            this.setImage("fire2.png");
            this.getImage().setTransparency(50);
        } else if (this.life == (int)(this.start_life * 0.2)) {
            this.setImage("fire3.png");
            this.getImage().setTransparency(70);
        } else if (this.life == (int)(this.start_life * 0.1)) {
            this.setImage("fire4.png");
            this.getImage().setTransparency(70);
        }
        
        this.setsize((int)(this.getw() + 1), (int)(this.geth()+ 1));
        this.life--;
    }
}
