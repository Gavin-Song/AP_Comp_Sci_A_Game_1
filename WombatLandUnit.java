import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class WombatLandUnit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class WombatLandUnit extends PhysicalObject implements CombatUnit
{
    private double life;
    private ArrayList<Turret> turrets;
    private String name;
    private String desc;
    
    public WombatLandUnit(int w, int h, double life, String name, String desc) {
        super(w, h, 10);
        this.life = life;
        this.name = name;
        this.desc = desc;
        
        this.turrets = new ArrayList<Turret>();
        this.createTurrets();
    }
    
    public abstract void createTurrets();
    
    public String getTeam() {
        return "wombat";
    }
    
    public void addedToWorld(World w) {
        for (Turret t: turrets) {
            w.addObject(t, this.getX() + t.getrx(), this.getY() + t.getry());
        }
    }
    
    public void subtractHealth(int damage) {
        this.life -= damage;
    }
    
    public void act() 
    {
        super.act();
        
        for (Turret t: turrets) {
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
            t.fire(this.getvx(), this.getvy());
        }
        
        if (this.life <= 0) {
            for (Turret t: turrets) {
                this.getWorld().removeObject(t);
            }
            this.getWorld().removeObject(this);
        }
    }    
    
    public ArrayList<Turret> getTurrets() {
        return this.turrets;
    }
}
