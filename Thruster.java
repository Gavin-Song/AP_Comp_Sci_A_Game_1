import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Thruster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Thruster extends Actor
{
    private int w, h;
    private int rx, ry;
    
    public Thruster(int w, int h, int rx, int ry) {
        this.rx = rx;
        this.ry = ry;
        
        this.w = w;
        this.h = h;
        
        this.getImage().scale(w, h);
    }
    
    public int getrx() {
        return rx;
    }
    
    public int getry() {
        return ry;
    }
}
