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
    private double damage;
    private double life;
    
    public Bullet(int w, int h, double life, double damage) {
        super(w, h, Config.BULLET_MASS);
        this.damage = damage;
        this.life = life;
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
        
        try{
            List intersect = this.getWorld().getObjectsAt(
                (int)(this.getX() + this.getvx()),
                (int)(this.getY() + this.getvy()), null);
            if (intersect.size() > 0 && intersect.get(0) instanceof Collidable) {
                this.life = 0;
            }
        } catch(IllegalStateException e){} // Why greenfoot call act before adding?!
    }    
    
    public double getlife() {
        return this.life;
    }
    
    public double getdamage() {
        return this.damage;
    }
}
