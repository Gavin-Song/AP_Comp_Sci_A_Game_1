import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Turret extends Actor
{
    private int rx, ry; //Relative location to Helicopter
    private String type;
    private int w, h;
    
    private boolean on = true;
    private double bullet_velocity_randomness = 0.2;
    private double bullet_angle_randomness = 0.01;
    private double bullet_speed = Config.BASIC_BULLET_SPEED;
    
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
        this.faceTowardsMouse();
    }    
    
    public void fire(double vx_inital, double vy_inital) {
        // Fire bullets at current mouse location if mouse is down
        if(Greenfoot.getMouseInfo() != null && this.on){
            // Calculate new bullet velocity
            double vx, vy;
            double fire_angle = this.getRotation() * Util.randomFromOne(this.bullet_angle_randomness); 
           
            vx = vx_inital + this.bullet_speed * Math.cos(Util.degToRad(fire_angle));
            vy = vy_inital + this.bullet_speed * Math.sin(Util.degToRad(fire_angle));
            
            double speed_randomness = Util.randomFromOne(this.bullet_velocity_randomness); 
            vx *= speed_randomness;
            vy *= speed_randomness;
            
            Bullet new_bullet = BulletFactory.getBullet(this.type);
            new_bullet.setRotation(this.getRotation());
            new_bullet.setVelocity(vx, vy);
            
            this.getWorld().addObject(new_bullet, this.getX(), this.getY());
        }
    }
    
    public void faceTowardsMouse() {
        if(Greenfoot.getMouseInfo() != null) {
            this.turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
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
    
    public void setRandomness(double vel, double angle) {
        this.bullet_velocity_randomness = vel;
        this.bullet_angle_randomness = angle;
    }
    
    public void setBulletSpeed(double s) {
        this.bullet_speed = s;
    }
}
