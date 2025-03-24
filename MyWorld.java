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
        
        this.hrac1 = new Raketa("up", "left", "right", "space");
        this.addObject(hrac1, 200, 300);
        
        this.hrac2 = new Raketa("w", "a", "d", "control");
        this.addObject(hrac2, 600, 300);
        this.hrac2.turn(180);
    }
    
    public void act()
    {
        this.showText("" + this.hrac1.getSkore(), 20, 10);
        this.showText("" + this.hrac2.getSkore(), 740, 10);
        
        this.checkGameOver();
        
        this.generujNepriatela();
        this.generujTurboBoost();
        this.generujStit();
        this.generujOpravu();
        this.generujCiernuDieru();
        this.generujSupernovu();
    }
    
    public void checkGameOver()
    {
        List<Raketa> hraci = this.getObjects(Raketa.class);
        if (hraci.size() == 1) {
            Greenfoot.stop();
            this.showText("Koniec hry! Posledny hrac vyhral!", this.getWidth() / 2, this.getHeight() / 2);
        }
    }
    
    public void generujNepriatela()
    {
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new NepriatelskaLod(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    
    public void generujTurboBoost()
    {
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new TurboBoost(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    
    public void generujStit()
    {
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new Stit(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    
    public void generujOpravu()
    {
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new Opravovna(), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    
    public void generujCiernuDieru()
    {
        int hmotnost = 300 + Greenfoot.getRandomNumber(100);
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new CiernaDiera(hmotnost), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
    
    public void generujSupernovu()
    {
        int hmotnost = 100 + Greenfoot.getRandomNumber(100);
        if (Greenfoot.getRandomNumber(500) < 2) {
            this.addObject(new Supernova(hmotnost), Greenfoot.getRandomNumber(800), Greenfoot.getRandomNumber(600));
        }
    }
}
