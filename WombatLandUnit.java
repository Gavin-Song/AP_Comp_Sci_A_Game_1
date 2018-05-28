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
    private double total_life;
    
    private ArrayList<Turret> turrets;
    private String name;
    private String desc;
    
    public WombatLandUnit(int w, int h, double life, String name, String desc) {
        super(w, h, 10);
        this.life = life;
        this.total_life = life;
        
        this.name = name;
        this.desc = desc;
        
        this.turrets = new ArrayList<Turret>();
        this.createTurrets();
        this.drawHealthBar();
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
        this.drawHealthBar();
    }
    
    public double getLifePercent() {
        return this.life / this.total_life;
    }
    
    public void drawHealthBar() {
        GreenfootImage img = this.getImage();
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, 100, 2);
        
        double life_percent = (this.life / this.total_life);
        
        if (life_percent > 0.5 ) {
            img.setColor(Color.GREEN);
        } else if (life_percent > 0.3) {
            img.setColor(Color.ORANGE);
        } else {
            img.setColor(Color.RED);
        }
        img.fillRect(0, 0, (int)(100 * life_percent), 2);
    }
    
    public void act() 
    {
        super.act();
        
        if (Greenfoot.mouseClicked(this)) {
            MyWorld.unit_card.setTextByUnit(this);
        } 
        
        // Off screen
        if (this.getX() - MyWorld.camera.getx() < -MyWorld.camera.getLeftXBound()) {
            this.getWorld().removeObject(this);
            MyWorld.game_state.damageCity((int)this.life);
            return;
        }
        
        for (Turret t: turrets) {
            if (MyWorld.helicopter != null) {
                t.target(MyWorld.helicopter.getX(), MyWorld.helicopter.getY());
            }
            t.setLocation(this.getX() + t.getrx(), this.getY() + t.getry());
            t.fire(this.getvx(), this.getvy());
        }
        
        if (this.life <= 0) {
            for (Turret t: turrets) {
                this.getWorld().removeObject(t);
            }
            this.getWorld().removeObject(this);
            MyWorld.game_state.incrementScore((int)this.total_life);
        }
    }    
    
    public ArrayList<Turret> getTurrets() {
        return this.turrets;
    }
    
    public String getHealthData() {
        return String.format("%d / %d", (int)this.life, (int)this.total_life);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDesc() {
        return this.desc;
    }
}
