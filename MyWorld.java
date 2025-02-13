import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Timotej Ružička
 * @version 1
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Raketa hrac1;
    Raketa hrac2;
    public MyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        this.hrac1 = new Raketa("up", "left", "right", "space");
        this.hrac2 = new Raketa("W", "A", "D", "control");
        this.addObject(this.hrac1, 200, 300);
        this.hrac1.setRotation(0);
        this.hrac2.setRotation(180);
        this.addObject(this.hrac2, 600, 300);
    }
    public void act()
    {
        this.showText(""+ this.hrac1.getSkore(), 20, 10);
        this.showText(""+ this.hrac2.getSkore(), 700, 10);
    }
}
