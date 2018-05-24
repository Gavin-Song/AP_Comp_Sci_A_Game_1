import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MachineGunBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MachineGunBullet extends Bullet
{
    public MachineGunBullet(String team) {
        this(team, 1);
    }
    
    public MachineGunBullet(String team, int damage) {
        super(10, 1, 100, damage, team);
    }
}
