import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadGameOverCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadGameOverCard extends GameOverCard
{
    public BadGameOverCard() {
        this.getImage().setTransparency(95);
        this.getImage().scale(MyWorld.WORLD_WIDTH, MyWorld.WORLD_HEIGHT);
    }
}
