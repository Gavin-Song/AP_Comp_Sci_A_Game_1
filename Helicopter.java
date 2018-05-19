import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Helicopter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helicopter extends PhysicalObject
{
    private String name;
    private ArrayList<Turret> turrets;
    
    public Helicopter(int w, int h, String name) {
        super(w, h, Config.HELICOPTER_MASS);
        this.setGravity(false);
        
        this.name = name;
        
        turrets = new ArrayList<Turret>();
        turrets.add(new MachineGunTurret(30, 20, -50, 5));
        turrets.add(new MachineGunTurret(30, 20, 50, 5));
        turrets.add(new MachineGunTurret(30, 20, -20, 5));
        turrets.add(new MachineGunTurret(30, 20, 20, 5));
    }
    
    public void addedToWorld(World w) {
        for (Turret t: turrets) {
            w.addObject(t, this.getX() + t.getrx(), this.getY() + t.getry());
        }
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
        }
        if (Greenfoot.isKeyDown("RIGHT") || Greenfoot.isKeyDown("D")) {
            this.applyForce(Config.THRUSTER_FORCE_X, 0);
        }
        
        /* Stop before it hits the ground */
        if (this.getY() > Config.GROUND_Y) {
            this.setLocation(this.getX(), Config.GROUND_Y);
        }
        
        for (Turret t: turrets) {
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
            t.fire(this.getvx(), this.getvy());
        }
        
        // Add your action code here.
    }    
}
