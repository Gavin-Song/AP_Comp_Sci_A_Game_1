import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class UnitDisplayCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnitDisplayCard extends GUI
{
    private String text = "Get information for a wombat unit";
    private String small_text = "about its name and turrets";
    private String turrets = "Simply click on a unit!";
    
    private GreenfootImage image;

    public static final int width = 250;
    public static final int height = 75;
    
    public UnitDisplayCard() {
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(UnitDisplayCard.width, UnitDisplayCard.height);
        
        // Display default text
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        this.renderText(this.getImage());
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
    
    public void setTurrets(String s) {
        this.turrets = s;
    }
    
    public void setTextByUnit(WombatLandUnit unit) {
        this.setText(unit.getName());
        this.setSmallText(unit.getDesc());
        
        String t = "";
        ArrayList<Turret> turrets_list = unit.getTurrets();
        for(int i=0; i<Math.min(turrets_list.size(), 3); i++) {
            t += turrets_list.get(i).getName() + " ";
        }
        this.setTurrets(t);
        
        this.render(unit);
    }
    
    public void render(WombatLandUnit unit) {
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
        img.drawString(unit.getHealthData(), 4, 15);
        
        this.renderText(img);
    }
    
    public void renderText(GreenfootImage img) {
        img.setColor(Color.BLACK);

        img.drawString(this.text, 4, 30);
        img.drawString(this.small_text, 4, 40);

        img.setColor(Color.BLUE);
        img.drawString(this.turrets, 4, 60);
    }
}
