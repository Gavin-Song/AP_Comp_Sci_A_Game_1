import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Actor
{
    private int rx, ry; //Relative location to Helicopter
    private String type;
    private int w, h;
    private boolean on = false;
    
    public Turret(int w, int h, int rx, int ry, String type) {
        this.rx = rx;
        this.ry = ry;
        this.w = w;
        this.h = h;
        this.type = type;
        
        this.getImage().scale(w, h);
    }
    
    
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Fire bullets at current mouse location if mouse is down
         if(Greenfoot.getMouseInfo() != null && Greenfoot.isKeyDown("A")){
            // Calculate new bullet velocity
            double dx = (Greenfoot.getMouseInfo().getX() - this.getX());
            double dy = (Greenfoot.getMouseInfo().getY() - this.getY());
            double d = Math.sqrt(dx * dx + dy * dy);
            
            double vx = Config.BASIC_BULLET_SPEED / d * dx;
            double vy = Config.BASIC_BULLET_SPEED / d * dy;
            
            Bullet new_bullet = new Bullet(10, 10, 100, 1000);
            new_bullet.setVelocity(vx, vy);
            
            this.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
            
            this.getWorld().addObject(new_bullet, this.getX(), this.getY());
        }
    }    
    
    public void toggleOn(boolean n) {
        this.on = n;
    }
    
    public void toggleOn() {
        this.on = !this.on;
    }
    
    public int getrx() {
        return rx;
    }
    
    public int getry() {
        return ry;
    }
}
