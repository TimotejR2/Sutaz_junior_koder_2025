import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Raketa extends VesmirnaLod
{
    private String vpred;
    private String vlavo;
    private String vpravo;
    private String vystrel;
    
    public Raketa(String vpred, String vlavo, String vpravo, String vystrel)
    {
        super(100, 1);
        
        this.getImage().scale(100, 65);
        
        this.vpred = vpred;
        this.vlavo = vlavo;
        this.vpravo = vpravo;
        this.vystrel = vystrel;
    }
    
    public void act()
    {
        super.act();
        
        if (Greenfoot.isKeyDown(this.vpred))
        {
            this.move(this.rychlost * this.speedmultimlier);
        }
        
        if (Greenfoot.isKeyDown(this.vlavo))
        {
            this.turn(-3);
        }
        
        if (Greenfoot.isKeyDown(this.vpravo))
        {
            this.turn(3);
        }
        
        // boolean, int, double, char, String
        //String vystrel = "space";
        if (Greenfoot.isKeyDown(this.vystrel))
        {
            this.vystrel();
        }
    }
        
    public void presunSa(int poziciaX, int poziciaY)
    {
        this.setLocation(poziciaX, poziciaY);
    }
    @Override
   public void opravSa(int oKolko)
   {
       this.pricitajSkore(oKolko);
   }
}
