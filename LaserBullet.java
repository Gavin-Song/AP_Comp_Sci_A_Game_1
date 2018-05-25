import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LaserBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaserBullet extends Bullet
{
    public LaserBullet(String team) {
        this(team, 100);
    }
    
    public LaserBullet(String team, int damage) {
        super(10, 10, 5, damage, team); // width, height, life, damage
        this.getImage().setTransparency(50);
    }
    
    public void act() 
    {
        this.setVelocity(0, 0);
        super.act();
    }     
}
