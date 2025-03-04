import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VesmirnaLod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VesmirnaLod extends Actor
{
    protected int skore;
    protected int casDoDobitia;
    
    protected int rychlost;
    protected boolean aktivnyBoost;
    protected int casDoUplynutiaBoostu;
    
    public VesmirnaLod(int initSkore, int rychlost){
        this.skore = initSkore;
        this.casDoDobitia = 0;
        this.rychlost = rychlost;
    }
    
    public void act()
    {             
        if (this.casDoDobitia > 0)
        {
            this.casDoDobitia--;
        }
        
        if (this.casDoUplynutiaBoostu > 0)
        {
            this.casDoUplynutiaBoostu--;
        }
        else if (aktivnyBoost)
        {
            rychlost /= 2;
            aktivnyBoost = false;
        }
        
        this.checkBoost();
        this.checkSkore();
    }
    
    public void pricitajSkore(int oKolko)
    {
        this.skore += oKolko;
        // this.skore = this.skore + oKolko;
    }
    
    public void odcitajSkore(int oKolko)
    {
        this.skore -= oKolko;
        // this.skore = this.skore - oKolko;
    }
    
    public int getSkore()
    {
        return this.skore;
    }
    
    public void vystrel()
    {
        if (this.mozeVystrelit() == true) {
            Strela strela = new Strela(this);
            World svet = this.getWorld();
            svet.addObject(strela, this.getX(), this.getY());
            strela.setRotation(this.getRotation());
            strela.move(75);
            this.casDoDobitia = 10;
        }
    }
    
    public boolean mozeVystrelit(){
        if (this.casDoDobitia == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public void checkSkore()
    {
        if (this.skore <= 0) {
            this.getWorld().removeObject(this);
        }
    }
    
    public void checkBoost()
    {
        TurboBoost turboBoost = (TurboBoost) this.getOneIntersectingObject(TurboBoost.class);
        
        if (turboBoost != null)
        {
            this.rychlost *= 2;
            this.aktivnyBoost = true;
            this.casDoUplynutiaBoostu = 100;
            this.getWorld().removeObject(turboBoost);
        }
    }
}
