import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UnitDisplayCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitDisplayCard extends GUI
{
    private String text = "";
    private String small_text = "";
    private GreenfootImage image;

    public static final int width = 250;
    public static final int height = 75;
    
    public UnitDisplayCard() {
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(UnitDisplayCard.width, UnitDisplayCard.height);
    }
    
    /**
     * Act - do whatever the UnitDisplayCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         
    }
    
    public void setText(String s) {
        this.text = s;
    }
    
    public void setSmallText(String s) {
        this.small_text = s;
    }
    
    public void setTextByUnit(WombatLandUnit unit) {
        this.setText(unit.getName());
        this.setSmallText(unit.getDesc());
        
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        img.setColor(Color.GRAY);
        img.fillRect(2, 2, 246, 14);
        
        double life_percent = unit.getLifePercent();
        if (life_percent > 0.5 ) {
            img.setColor(Color.GREEN);
        } else if (life_percent > 0.3) {
            img.setColor(Color.ORANGE);
        } else {
            img.setColor(Color.RED);
        }
        img.fillRect(2, 2, (int)(246 * life_percent), 14);
        
        img.setColor(Color.BLACK);
        img.drawString(unit.getHealthData(), 2, 15);
        
        img.drawString(this.text, 2, 30);
        img.drawString(this.small_text, 2, 40);
    }
}
