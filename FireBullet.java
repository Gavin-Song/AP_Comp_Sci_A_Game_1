import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBullet extends Bullet
{
    private static double SIZE_MULTIPLIER = 1.1; //1.0413927; // How much bigger the flames get per frame
    private static int BASE_LIFE = 40;
    
    public FireBullet(String team) {
        this(team, 20);
    }
    
    public FireBullet(String team, int damage) {
        super(10, 10, FireBullet.BASE_LIFE, damage, team); // width, height, life, damage
        this.getImage().setTransparency(100);
    }
    
    public void act() 
    {
        super.act();
        
        if (this.getlife() == (int)(FireBullet.BASE_LIFE * 0.7)) {
            this.setImage("fire2.png");
            this.getImage().setTransparency(50);
        } else if (this.getlife() == (int)(FireBullet.BASE_LIFE * 0.4)) {
            this.setImage("fire3.png");
            this.getImage().setTransparency(70);
        } else if (this.getlife() == (int)(FireBullet.BASE_LIFE * 0.1)) {
            this.setImage("fire4.png");
            this.getImage().setTransparency(70);
        }
        
        this.setsize((int)(this.getw() * FireBullet.SIZE_MULTIPLIER), (int)(this.geth() * FireBullet.SIZE_MULTIPLIER));
    }    
}
