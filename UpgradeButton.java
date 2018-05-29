import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Button
{
    private String category;
    private int id;
    private GreenfootImage image;
    
    public UpgradeButton(int w, int h, String text, String category, int id) {
        super(w, h, text);
        this.category = category;
        this.id = id;
        
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(w, h);
    }
    
    public void onClick() {
        MyWorld.game_state.doUpgrade(this.category);
    }
    
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        img.setFont(this.getFont());
        img.setColor(Color.BLACK);
        img.drawString(this.getText(), 8, this.geth() / 3 + 4);
        
        int cost = MyWorld.game_state.getCost(this.category);
        img.setColor(MyWorld.game_state.getPlayerResource() >= cost ?
            Color.GREEN : Color.RED);
        img.drawString("(-" + cost + ")", 
            8, 2 * this.geth() / 3 + 4);
        
        this.handleClicked();
        
        if (Greenfoot.isKeyDown(String.valueOf(this.id))) {
            this.onClick();
        }
    }  
}
