import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Helicopter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helicopter extends PhysicalObject implements CombatUnit
{
    private String name;
    private ArrayList<Turret> turrets;
    
    public Helicopter(int w, int h, String name) {
        super(w, h, Config.HELICOPTER_MASS);
        this.setGravity(false);
        
        this.name = name;
        
        this.turrets = new ArrayList<Turret>();
        this.turrets.add(new MachineGunTurret(50, 30, 20, 5, "human"));
    }
    
    public void addedToWorld(World w) {
        for (Turret t: turrets) {
            w.addObject(t, this.getX() + t.getrx(), this.getY() + t.getry());
        }
    }
    
    public void addTurret(Turret t) {
        this.turrets.add(t);
        this.getWorld().addObject(t, this.getX() + t.getrx(), this.getY() + t.getry());
    }
    
    public void removeTurret(int n) {
        this.getWorld().removeObject(this.turrets.remove(n));
    }
    
    public void subtractHealth(int damage) {
        MyWorld.game_state.addPlayerHealth(-damage);
    }
    
    /**
     * Act - do whatever the Helicopter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
   
        if (Greenfoot.isKeyDown("UP") || Greenfoot.isKeyDown("W")) {
            this.applyForce(0, -Config.THRUSTER_FORCE_Y);
        }
        if (Greenfoot.isKeyDown("DOWN") || Greenfoot.isKeyDown("S")) {
            this.applyForce(0, Config.THRUSTER_FORCE_Y);
        }
        if (Greenfoot.isKeyDown("LEFT") || Greenfoot.isKeyDown("A")) {
            this.applyForce(-Config.THRUSTER_FORCE_X, 0);
            MyWorld.camera.scrollX(-(int)(this.getvx()), this.getWorld());
        }
        if (Greenfoot.isKeyDown("RIGHT") || Greenfoot.isKeyDown("D")) {
            this.applyForce(Config.THRUSTER_FORCE_X, 0);
            MyWorld.camera.scrollX(-(int)(this.getvx()), this.getWorld());
        }
        
        this.setLocation(600, this.getY());
        
        /* Stop before it hits the ground */
        if (this.getY() > Config.GROUND_Y - Config.GROUND_CLEARANCE) {
            this.setLocation(this.getX(), Config.GROUND_Y - Config.GROUND_CLEARANCE);
        }
        
        for (Turret t: turrets) {
            if(Greenfoot.getMouseInfo() != null) {
                t.target(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            }
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
            t.fire(this.getvx(), this.getvy());
        }
        
        // Add your action code here.
    }    
    
    public String getTeam() {
        return "human";
    }
    
    public String getName() {
        return this.name;
    }
}
