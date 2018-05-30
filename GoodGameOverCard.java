import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoodGameOverCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoodGameOverCard extends GameOverCard
{
    public GoodGameOverCard() {
        this.getImage().setTransparency(95);
        this.getImage().scale(MyWorld.WORLD_WIDTH, MyWorld.WORLD_HEIGHT);
    }
}
