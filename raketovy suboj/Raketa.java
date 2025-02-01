import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Raketa here.
 * 
 * @author Timotej Ružička
 * @version 1
 */
public class Raketa extends Actor
{
    private int skore;
    private String vystrel, vpred, vpravo, vlavo;
    
    public Raketa(String vpred, String vlavo, String vpravo, String vystrel)
    {
        this.getImage().scale(100, 65);
        this.skore = 0;
        this.vpred = vpred;
        this.vlavo = vlavo;
        this.vpravo = vpravo;
        this.vystrel = vystrel;
    }
    /**
     * Act - do whatever the Raketa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown(this.vpred))
        {
            this.move(1);
        }
        if (Greenfoot.isKeyDown(this.vlavo))
        {
            this.turn(-3);
        }
        if (Greenfoot.isKeyDown(this.vpravo))
        {
            this.turn(3);
        }
        if (Greenfoot.isKeyDown(this.vystrel))
        {
            Strela strela = new Strela(this);
            World svet = this.getWorld();
            svet.addObject(strela, this.getX(), this.getY());
            strela.setRotation(this.getRotation());
            strela.move(75);
        }
    }
    public void presunSa(int poziciaX, int poziciaY)
    {
        this.setLocation(poziciaX, poziciaY);
    }
    public void pricitajSkore(int oKolko)
    {
        this.skore += oKolko;
    }
    public void odcitajSkore(int oKolko)
    {
        this.skore -= oKolko;
    }
    public int getSkore()
    {
        return this.skore;
    }
}
