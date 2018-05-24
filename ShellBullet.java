import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShellBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShellBullet extends Bullet
{
    public ShellBullet(String team) {
        this(team, 20);
    }
    
    public ShellBullet(String team, int damage) {
        super(20, 5, 100, damage, team); // width, height, life, damage
    }
}
