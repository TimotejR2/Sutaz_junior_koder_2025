import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Raketa hrac1;
    Raketa hrac2;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        hrac1 = new Raketa("up", "left", "right", "space");
        this.addObject(hrac1, 200, 300);
        
        hrac2 = new Raketa("w", "a", "d", "control");
        this.addObject(hrac2, 600, 300);
        this.hrac2.turn(180);
    }
    
    public void act()
    {
        this.showText("SKORE:" + this.hrac1.getSkore(), 50, 15);
        this.showText("SKORE:" + this.hrac2.getSkore(), 740, 15);
        this.checkGameOver();
        this.generujNepriatela();
        this.generateTurbo();
    }
    
    public void checkGameOver()
    {
        List<Raketa>hraci = this.getObjects(Raketa.class);
        if (hraci.size() == 1)
        {
        Greenfoot.stop();
        this.showText("Koneic hry! Posledny hrac vyhral!", this.getWidth()/2, this.getHeight()/2);
        }
    }
    public void generujNepriatela()
    {
        if(Greenfoot.getRandomNumber(500) < 2){
            this.addObject(new NepriatelskaLod(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    public void generateTurbo(){
        if(Greenfoot.getRandomNumber(300) < 2){
            this.addObject(new TurboBoost(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
}
