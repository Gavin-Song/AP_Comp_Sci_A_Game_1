import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysicalObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicalObject extends Actor
{
    private double vx, vy;
    private int w, h;
    
    public PhysicalObject(int w, int h, double vx, double vy) {
        this.w = w;
        this.h = h;
        this.vx = vx;
        this.vy = vy;
        
        this.getImage().scale(w, h);
    }
    
    public PhysicalObject(int w, int h) {
        //TODO use other constructor
        this.w = w;
        this.h = h;
        this.vx = 0;
        this.vy = 0;
        
        this.getImage().scale(w, h);
    }
    
    /**
     * Act - do whatever the PhysicalObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.vy += Config.GRAVITY; //TODO do collision after this
        
        this.setLocation((int)(this.getX() + this.vx), (int)(this.getY() + this.vy));
        
        // Add your action code here.
    }    
    
    public int getw() {
        return w;
    }
    
    public int geth(){
        return h;
    }
    
    public double getvx(){
        return vx;
    }
    public double getvy(){
        return vy;
    }
    public void setvx(double n){
        vx = n;
    }
    public void setvy(double n){
        vy = n;
    }
}
