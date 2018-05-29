import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends GUI
{
    private int w, h;
    private String text;
    private Font font;

    public Button(int w, int h, String text) {
        this.w = w;
        this.h = h;
        this.text = text;
        this.font = new Font(h / 3);
        
        this.getImage().scale(w, h);
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // this.getWorld().showText(this.text, this.getX(), this.getY());
        GreenfootImage img = this.getImage();
        img.setFont(font);
        img.setColor(Color.BLACK);
        img.drawString(this.text, 8, this.h / 2 + 4);
        
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
        return this.getX();
    }
    public int gety(){
        return this.getY();
    }
    
    public int getw() {
        return w;
    }
    public int geth() {
        return h;
    }
    
    public String getText() {
        return this.text;
    }
    public Font getFont() {
        return this.font;
    }
}
