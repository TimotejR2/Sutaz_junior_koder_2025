import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VesmirnaLod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class VesmirnaLod extends Actor
{
    protected int skore;
    protected int stit;
    
    protected int casDoDobitia;
    
    protected int rychlost;
    protected boolean aktivnyBoost;
    protected int casDoUplynutiaBoostu;
    
    protected boolean pohybAktivny;
    
    public VesmirnaLod(int initSkore, int rychlost){
        this.skore = initSkore;
        this.casDoDobitia = 0;
        this.rychlost = rychlost;
        this.stit = 0;
        this.pohybAktivny = true;
    }
    
    abstract public void opravSa(int oKolko);
    
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
        
        this.checkSkore();
    }
        
    public void aktivujPohyb()
    {
        this.pohybAktivny = true;
    }
    
    public void deaktivujPohyb()
    {
        this.pohybAktivny = false;
    }
    
    public void pricitajSkore(int oKolko)
    {
        this.skore += oKolko;
        // this.skore = this.skore + oKolko;
    }
    
    public void odcitajSkore(int oKolko)
    {
        if (this.stit >= oKolko) {
            // stit pohlti vsetko
            this.stit -= oKolko;
            oKolko = 0;
        } else {
            // stit pohlti len cast
            oKolko -= this.stit;
            this.stit = 0;
        }
        
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
    
    public void aktivujBoost()
    {
        this.rychlost *= 2;
        this.aktivnyBoost = true;
        this.casDoUplynutiaBoostu = 100;
    }
    
    public void aktivujStit()
    {
        this.stit = 20;
    }
}
