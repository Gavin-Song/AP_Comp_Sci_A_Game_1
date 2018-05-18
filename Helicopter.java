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
        turrets.add(new Turret(30, 30, -50, 5, "basic"));
        turrets.add(new Turret(30, 30, 50, 5, "basic"));
        turrets.add(new Turret(30, 30, -20, 5, "basic"));
        turrets.add(new Turret(30, 30, 20, 5, "basic"));
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
   
        if(Greenfoot.isKeyDown("UP")){
            this.applyForce(0, -Config.THRUSTER_FORCE_Y);
        }
        if(Greenfoot.isKeyDown("LEFT")){
            this.applyForce(-Config.THRUSTER_FORCE_X, 0);
        }
        if(Greenfoot.isKeyDown("RIGHT")){
            this.applyForce(Config.THRUSTER_FORCE_X, 0);
        }
        if(Greenfoot.isKeyDown("DOWN")){
            this.applyForce(0, Config.THRUSTER_FORCE_Y);
        }
        
        for (Turret t: turrets) {
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
        }
        
        // Add your action code here.
    }    
}
