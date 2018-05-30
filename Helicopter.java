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
    private ArrayList<Thruster> thrusters;
    
    public Helicopter(int w, int h, String name) {
        super(w, h, Config.HELICOPTER_MASS);
        this.setGravity(false);
        
        this.name = name;
        
        this.turrets = new ArrayList<Turret>();
        this.turrets.add(new MachineGunTurret(50, 30, 20, 45, "human"));
        
        this.thrusters = new ArrayList<Thruster>();
        this.thrusters.add(new Thruster(50, 25, -110, 40));
        this.thrusters.add(new Thruster(50, 25, 110, 40));
        this.thrusters.add(new Thruster(30, 15, -50, 60));
        this.thrusters.add(new Thruster(30, 15, 50, 60));
    }
    
    public void addedToWorld(World w) {
        for (Turret t: turrets) {
            w.addObject(t, this.getX() + t.getrx(), this.getY() + t.getry());
        }
        for (Thruster t: thrusters) {
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
        if (MyWorld.game_state.getPlayerHealth() > 0) {
            this.doWhileAlive();
            
            this.subtractHealth(10);
            
            /* Stop before it hits the ground */
            if (this.getY() > Config.GROUND_Y - Config.GROUND_CLEARANCE) {
                this.setLocation(this.getX(), Config.GROUND_Y - Config.GROUND_CLEARANCE);
            }
        } else {
            this.setGravity(true);
            this.setRotation(this.getRotation() + 1);
            
            /* Stop before it hits the ground */
            if (this.getY() >= Config.GROUND_Y - 100) {
                for (int i=0; i<5; i++) {
                    Explosion boom = new Explosion(1000, 100, "human");
                    this.getWorld().addObject(boom, this.getX() - 500 + (int)(Util.randomNum(0, 400)), this.getY() + (int)(Util.randomNum(-10, 10)));
                }
                this.die();
                return;
            }
        }
        
        this.setLocation(600, this.getY());
        
        /* Stop before it reaches a ceiling */
        if (this.getY() < 0) {
            this.setLocation(this.getX(), 0);
        }
        

        for (Thruster t: thrusters) {
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
        } 
        for (Turret t: turrets) {
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
        }
    }    
    
    public void die() {
        for (Thruster t: thrusters) {
            this.getWorld().removeObject(t);
        } 
        for (Turret t: turrets) {
            this.getWorld().removeObject(t);
        }
        this.getImage().scale(1, 1); // Hide rather than destroy to stop errors (hax)
        this.setLocation(600, -1);
        this.setGravity(false);
    }
    
    public void doWhileAlive() {
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
        
        for (Turret t: turrets) {
            if(Greenfoot.getMouseInfo() != null) {
                t.target(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            }
            t.fire(this.getvx(), this.getvy());
        }
        
        for (Thruster t: thrusters) {
            if (this.getvx() == 0) {
                t.setRotation(0);
            } else {
                t.setRotation((int)(30 * this.getvx() / 10));
            } 
        }
    }
    
    public String getTeam() {
        return "human";
    }
    
    public String getName() {
        return this.name;
    }
}
