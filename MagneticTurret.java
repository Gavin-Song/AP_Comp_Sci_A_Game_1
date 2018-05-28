import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * MagneticTurret - Pulls enemies towards itself. Not very 
 * effective when multiple enemies are present; thus it should
 * ONLY be used in WombatUnits
 * 
 * @author (Gavin Song) 
 * @version (1.0.0)
 */
public class MagneticTurret extends Turret
{
    public static final double FORCE = 30;
    public static final int SEARCH_RADIUS = 500;
    
    private CombatUnit nearest_enemy = null;
    
    public MagneticTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "magnet_gun", team);
    } 
    
    public void fire(double vx_inital, double vy_inital, int bullets_per_round) {  
        /* Randomly deslect nearest enemy. That way it's forced to re-target a closer
           enemy, and ceases to apply a force to an out of range enemy */
        if (Math.random() < 0.1) {
            this.nearest_enemy = null;
        }
        
        
        try {
            if (this.nearest_enemy == null) {
                this.obtainNearestEnemy();
            }
            
            if(Greenfoot.getMouseInfo() != null) {
                // Calculate new force attack
                double fx, fy;
                double fire_angle = this.getRotation();
                
                fx = MagneticTurret.FORCE * Math.cos(Util.degToRad(fire_angle));
                fy = MagneticTurret.FORCE * Math.sin(Util.degToRad(fire_angle));
                
                PhysicalObject target = (PhysicalObject)this.nearest_enemy;
                target.applyForce(-fx, -fy);
            }
        } catch (IllegalStateException e) {
            // Target died or this has not been added to world yet
            this.obtainNearestEnemy();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            // No enemy found yet
        } catch (ClassCastException e) {
            // Someone fucked up and CombatUnit wasn't a PhysicalObject
        }
    }
    
    public void obtainNearestEnemy() {
        List nearby_objects = this.getNeighbours(MagneticTurret.SEARCH_RADIUS, false, null);
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
    
    public String getName() {
        return "Magnetic";
    }
}
