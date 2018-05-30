import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuantumBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuantumBullet extends Bullet
{
    public QuantumBullet(String team) {
        this(team, 80);
    }
    
    public QuantumBullet(String team, int damage) {
        super(20, 10, 100, damage, team); // width, height, life, damage
    }
}
