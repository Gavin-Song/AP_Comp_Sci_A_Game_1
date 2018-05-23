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
    private String team;
    private int w, h;
    
    private boolean on = true;
    private double bullet_velocity_randomness = 0.2;
    private double bullet_angle_randomness = 0.01;
    private double muzzle_velocity = Config.BASIC_BULLET_SPEED;
    
    private int fire_rate = 0;
    private int fire_count = 0; // Keep track of fire rate
    private int[] limit_angle_rotation = {0, 360};
    
    public Turret(int w, int h, int rx, int ry, String type, String team) {
        this.rx = rx;
        this.ry = ry;
        
        this.w = w;
        this.h = h;
        
        this.type = type;
        this.team = team;
        
        this.getImage().scale(w, h);
    }
    
    
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    
    
    public void fire(double vx_inital, double vy_inital) {
        this.fire(vx_inital, vy_inital, false);
    }
    
    public void fire(double vx_inital, double vy_inital, boolean ignore_delay) {
        // Delay firing
        if (this.fire_count != 0 && this.fire_rate != 0 && !ignore_delay) {
            this.fire_count = (this.fire_count + 1) % this.fire_rate;
            return;
        }
        
        // Fire bullets at current target if it's on
        if(Greenfoot.getMouseInfo() != null && this.on){

            // Calculate new bullet velocity
            double vx, vy;
            double fire_angle = this.getRotation() * Util.randomFromOne(this.bullet_angle_randomness); 
           
            vx = vx_inital + this.muzzle_velocity * Math.cos(Util.degToRad(fire_angle));
            vy = vy_inital + this.muzzle_velocity * Math.sin(Util.degToRad(fire_angle));
            
            double speed_randomness = Util.randomFromOne(this.bullet_velocity_randomness); 
            vx *= speed_randomness;
            vy *= speed_randomness;
            
            Bullet new_bullet = BulletFactory.getBullet(this.type, this.team);
            new_bullet.setRotation(this.getRotation());
            new_bullet.setVelocity(vx, vy);
            
            this.getWorld().addObject(new_bullet, this.getX(), this.getY());
            this.fire_count++;
        }
    }
    
    public void resetFireDelay() {
        this.fire_count = 0;
    }
    
    public void setFireDelay(int t) {
        this.fire_count = t;
    }
    
    public int getFireDelay() {
        return this.fire_count;
    }
    
    public void target(int x, int y) {
        this.turnTowards(x, y);
        if (this.getRotation() > this.limit_angle_rotation[1]) {
            this.setRotation(this.limit_angle_rotation[1]);
        } else if (this.getRotation() < this.limit_angle_rotation[0]) {
            this.setRotation(this.limit_angle_rotation[0]);
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
    
    public void setFireRate(int x) {
        this.fire_rate = x;
    }
    
    public void setRotationLimit(int start, int end) {
        this.limit_angle_rotation[0] = start;
        this.limit_angle_rotation[1] = end;
    }
    
    public void setRandomness(double vel, double angle) {
        this.bullet_velocity_randomness = vel;
        this.bullet_angle_randomness = angle;
    }
    
    public void setBulletSpeed(double s) {
        this.muzzle_velocity = s;
    }
}
