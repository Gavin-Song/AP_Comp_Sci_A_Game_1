import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotatoBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotatoBullet extends Bullet
{
    public PotatoBullet(String team) {
        this(team, 1);
    }
    
    public PotatoBullet(String team, int damage) {
        super(10, 10, 50, damage, team); // width, height, life, damage
        this.setGravity(true);
    }
}