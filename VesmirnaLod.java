import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract public class VesmirnaLod extends Actor
{
    protected int skore;
    protected int casDoDobitia;
    protected int stit;
    
    protected int rychlost;
    protected boolean aktivnyBoost;
    protected int casDoUplynutiaBoostu;
    protected int speedmultimlier;
    
    public VesmirnaLod(int initSkore, int rychlost){
        this.stit = 0;
        this.skore = initSkore;
        this.casDoDobitia = 0;
        this.rychlost = rychlost;
        this.speedmultimlier = 1;
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
        
        this.checkSkore();
    }
    
    public void pricitajSkore(int oKolko)
    {
        this.skore += oKolko;
        // this.skore = this.skore + oKolko;
    }
    
    public void odcitajSkore(int oKolko)
    {
        if (this.stit >= oKolko)
        {
            this.stit -= oKolko;
            oKolko = 0;
        }
        else{
            oKolko -= this.stit;
            this.stit = 0;
        }
        this.skore -= oKolko;
        // this.skore = this.skore - oKolko;
    }
    public void aktivujBoost()
    {
            this.rychlost *= 2;
            this.aktivnyBoost = true;
            this.casDoUplynutiaBoostu = 100;
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
    public void aktivujStit()
    {
        this.stit = 20;
    }
    public void stop(){
        this.speedmultimlier = 0;
    }
    public void go(){
        this.speedmultimlier = 1;
    }
    abstract public void opravSa(int oKolko);
}
