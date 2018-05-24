import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GuidedMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuidedMissile extends Bullet
{
    public static int SEARCH_RADIUS = 300;
    public static int FORCE = 20;
    
    private CombatUnit nearest_enemy = null;
    
    public GuidedMissile(String team, int damage) {
        super(25, 12, 200, damage, team); // width, height, life, damage
        this.setMass(10);
    }   
    
    public GuidedMissile(String team) {
        this(team, 1000);
    }
    
    public void act() 
    {
        try {
            if (this.nearest_enemy == null) {
                this.obtainNearestEnemy();
            }
            
            double fx, fy;
            this.turnTowards(((Actor)this.nearest_enemy).getX(), ((Actor)this.nearest_enemy).getY());
            
            fx = GuidedMissile.FORCE * Math.cos(Util.degToRad(this.getRotation()));
            fy = GuidedMissile.FORCE * Math.sin(Util.degToRad(this.getRotation()));
            
            this.applyForce(fx, fy);
        } catch (IllegalStateException e) {
            // Target died or this has not been added to world yet
            this.obtainNearestEnemy();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            // No enemy found yet
        }
        super.act();
    }
    
    public void obtainNearestEnemy() {
        List nearby_objects = this.getNeighbours(GuidedMissile.SEARCH_RADIUS, false, null);
        // Remove friendly units
        for (int i = nearby_objects.size() - 1; i >= 0; i--) {
            try {
                if (((CombatUnit)(nearby_objects.get(i))).getTeam().equals(this.getTeam())){
                    nearby_objects.remove(i);
                }
            } catch (Exception e) {
                nearby_objects.remove(i);
            }
        }
        
        this.nearest_enemy = nearby_objects.size() > 0 ?
            (CombatUnit)nearby_objects.get(0) : null;
    }
}
