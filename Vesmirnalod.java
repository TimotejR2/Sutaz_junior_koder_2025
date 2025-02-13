import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vesmirnalod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vesmirnalod extends Actor
{
    protected int skore;
    protected int speed;
    protected int casDoDobitia;
    public int turboCooldown;
    public Vesmirnalod(int initSkore, int initSpeed){
        this.skore = initSkore;
        this.speed = initSpeed;
        casDoDobitia = 0;
        turboCooldown = 0;
    }
    public void act()
    {
        if (this.casDoDobitia >0){
            this.casDoDobitia--;
        }
        if (this.turboCooldown > 0){
            this.turboCooldown--;
            if (this.turboCooldown == 0){
                speed /= 2;
            }
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
        this.skore -= oKolko;
    }
    
    public int getSkore()
    {
        return this.skore;
    }
        public void vystrel()
    {
        if(this.mozeVystrelit() == true){
            Strela strela = new Strela(this);
            World svet = this.getWorld();
            svet.addObject(strela, this.getX(), this.getY());
            strela.setRotation(this.getRotation());
            strela.move(75);
            this.casDoDobitia = 10;
        }
    }
    public boolean mozeVystrelit()
    {
        if (this.casDoDobitia == 0){
            return true;
        }
        else{
            return false;
        }
    }
        public void checkSkore()
    {
        if (this.skore <= 0){
            this.getWorld().removeObject(this);
        }
    }
    public void turbo(){
        this.speed *= 2;
        this.turboCooldown = 100;
    }
    // Overenie ci turbo uz nieje aktivovane. Ak je, neaktivovoat dalseie aby sa rychlost nezvysila na sialene cisla. 
    // Ak by tato funkcia bola povazovana za chybu lebo to zadanie nekazalo, staci zmenit jej obsah na return true;
    public boolean turboUsable(){
        if (this.turboCooldown == 0){
                return true;
            }
        return false;
    }
}
