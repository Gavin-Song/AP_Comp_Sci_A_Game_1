import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MachineGunTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MachineGunTurret extends Turret
{
    public MachineGunTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "machine_gun", team);
        this.setRandomness(0.2, 0.01);
    }
}
