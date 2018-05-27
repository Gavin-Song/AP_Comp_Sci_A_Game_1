import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends GUI
{
    private int x, y, w, h;
    private String text;
    
    //TODO remove x and y requirements
    public Button(int x, int y, int w, int h, String text) {
        this.x = x;
        this.y = y;
        
        this.w = w;
        this.h = h;
        this.text = text;
        
        this.getImage().scale(w, h);
        this.setLocation(x, y);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.getWorld().showText(this.text, this.x, this.y);
        this.handleClicked();
    }    
    
    public boolean isClicked() {
        return Greenfoot.mouseClicked(this);
    }
    
    public void handleClicked() {
        if(this.isClicked()) {
            this.onClick();
        }
    }
    
    public void onClick() {
        System.out.println("HELLO WORLD");
    }
    
    public int getx(){
        return this.x;
    }
    public int gety(){
        return this.y;
    }
}
