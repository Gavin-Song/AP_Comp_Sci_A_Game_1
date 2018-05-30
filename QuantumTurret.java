import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuantumTurret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuantumTurret extends Turret
{
    public QuantumTurret(int w, int h, int rx, int ry, String team) {
        super(w, h, rx, ry, "quantum_gun", team);
        this.setRandomness(0.2, 0.01);
        this.setFireRate(5);
    }  
    
    public String getName() {
        return "Quantum Ripper";
    }  
}
