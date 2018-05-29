import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends GUI
{
    private String label = "";
    private int total;
    private int value;
    
    private GreenfootImage image;

    public static final int width = 250;
    public static final int height = 30;
    
    private Font font;
    
    public HealthBar(String label, int total) {
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(HealthBar.width, HealthBar.height);
        
        font = new Font(height / 2);
        
        this.label = label;
        this.total = total;
        this.value = total;
        this.render();
    }
    
    /**
     * Act - do whatever the UnitDisplayCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         
    }
    
    public void updateHealth(int n) {
        this.value = n;
        this.render();
    }
    
    public void updateTotalHealth(int n) {
        this.total = n;
        this.render();
    }
    
    public double getLifePercent() {
        return (double)this.value / this.total;
    }
    
    public void render() {
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        img.setColor(Color.GRAY);
        img.fillRect(2, 2, width - 4, height - 4);
        
        double life_percent = this.getLifePercent();
        if (life_percent > 0.5 ) {
            img.setColor(Color.GREEN);
        } else if (life_percent > 0.3) {
            img.setColor(Color.ORANGE);
        } else {
            img.setColor(Color.RED);
        }
        img.fillRect(2, 2, (int)((width - 4) * life_percent), height - 4);
        
        img.setFont(font);
        img.setColor(Color.BLACK);
        img.drawString(this.label + "    " + this.value + " / " + this.total, 8, height / 2 + 4);
    }  
}
