import greenfoot.*;

/**
 * An Actor object with physics applied. Remember,
 * in subclasses be sure to call super.act()
 * 
 * @author (Gavin Song)
 */
public class PhysicalObject extends Actor
{
    private double mass;
    private boolean isStatic;
    private int w, h;
    private boolean doGravity;

    private double vx = 0.0;
    private double vy = 0.0;

    /**
     * Create a Physical Object
     * @param w Width (int)
     * @param h Height (int)
     * @param mass Mass of object (double)
     * @param isStatic Is the object static (can it move?) (boolean)
     */
    public PhysicalObject(int w, int h, double mass, boolean isStatic) {
        this.w = w;
        this.h = h;
        this.mass = mass;
        this.isStatic = isStatic;

        /* Scale the image to proper size */
        this.getImage().scale(w, h);
    }

    /**
     * Create a Physical Object
     * @param w Width (int)
     * @param h Height (int)
     * @param mass Mass of object (double)
     */
    public PhysicalObject(int w, int h, double mass) {
        this(w, h, mass, false);
    }
    
    /**
     * Update physics of the object. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        //TODO collision here

        if (!this.isStatic) {
            // Gravitational acceleration
            if (this.doGravity) {
                this.vy += Config.GRAVITY;
            }
            
            this.applyFriction();
            this.negateVelocities();
            this.applyVelocities();
        }
    }
    
    /**
     * Update current location based on current velocity
     */
    private void applyVelocities() {
        this.setLocation((int)(this.getX() + this.vx), (int)(this.getY() + this.vy));
    }
    
    /**
     * Negative small enough velocities, so object stops
     * sooner instead of procceding very slowly
     */
    private void negateVelocities() {
        // Negate small enough velocities
        this.vx = Math.abs(this.vx) < Config.MIN_VEL ? 0 : this.vx;
        this.vy = Math.abs(this.vy) < Config.MIN_VEL ? 0 : this.vy;
    }

    
    /**
     * Apply the friction forces onto
     * current velocity components
     */
    private void applyFriction() {
        // Friction forces, v change = v^2 * mass * u
        this.vx -= (this.vx >= 0 ? 1 : -1) * Math.pow(this.vx, 2) * Config.FRICTION * this.mass;
        this.vy -= (this.vy >= 0 ? 1 : -1) * Math.pow(this.vy, 2) * Config.FRICTION * this.mass;
    }

    /**
     * Apply a force vector to the object
     * @param fx x component
     * @param fy y component
     */
    public void applyForce(double fx, double fy) {
        this.setVelocity(this.vx + fx / this.mass, this.vy + fy / this.mass);
    }

    /**
     * Return the width
     * @return width
     */
    public int getw() {
        return w;
    }

    /**
     * Return the height
     * @return height
     */
    public int geth() {
        return h;
    }
    
    /**
     * Set a new size
     * @param w New width
     * @param h New height
     */
    public void setsize(int w, int h) {
        this.w = w;
        this.h = h;
        this.getImage().scale(w, h);
    }

    /**
     * Return x velocity
     * @return vx
     */
    public double getvx() {
        return vx;
    }

    /**
     * Return y velocity
     * @return vy
     */
    public double getvy() {
        return vy;
    }

    /**
     * Set a new velocity
     * @param vx x component
     * @param vy y component
     */
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * Set new vx
     * @param vx
     */
    public void setvx(double vx) {
        this.vx = vx;
    }

    /**
     * Set new vy
     * @param vy
     */
    public void setvy(double vy) {
        this.vy = vy;
    }

    /**
     * Set should it be affected by gravity?
     * @param t true = yes, false = no
     */
    public void setGravity(boolean t) {
        this.doGravity = t;
    }
}
