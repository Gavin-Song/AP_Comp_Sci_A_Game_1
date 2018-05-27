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
    
    public static final int width = 400;
    public static final int height = 250;
    
    public UnitDisplayCard() {
        image = new GreenfootImage("button.png");
        this.setImage(image);
        
        this.getImage().setColor(Color.WHITE);
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
        img.fillRect(98, 88, 204, 14);
        
        double life_percent = unit.getLifePercent();
        if (life_percent > 0.5 ) {
            img.setColor(Color.GREEN);
        } else if (life_percent > 0.3) {
            img.setColor(Color.ORANGE);
        } else {
            img.setColor(Color.RED);
        }
        img.fillRect(98, 88, (int)(204 * life_percent), 14);
        
        img.setColor(Color.BLACK);
        img.drawString(unit.getHealthData(), 100, 100);
        
        img.drawString(this.text, 100, 120);
        img.drawString(this.small_text, 100, 130);
    }
}
