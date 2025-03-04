import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class NepriatelskaLod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NepriatelskaLod extends VesmirnaLod
{
    private int pohybCooldown; // pocet cyklov medzi zmenami smeru
    private int smerPohybu;
    
    public NepriatelskaLod()
    {
        super(5, 2);
        this.getImage().scale(110, 75);
        
        this.pohybCooldown = 50;
        this.smerPohybu = Greenfoot.getRandomNumber(360);
    }
    
    public void act()
    {
        super.act();
        
        Raketa ciel = this.najdiNajblizsiehoHraca();
        if (ciel != null)
        {
            this.turnTowards(ciel.getX(), ciel.getY());
            this.vystrel();
        }
        
        this.pohybujSa();
    }
    
    public void pohybujSa()
    {
        if (pohybCooldown <= 0){
            this.smerPohybu = Greenfoot.getRandomNumber(360); // nahodna zmena smeru
            this.pohybCooldown = 50; // restart premennej pohybCooldown
        }
        this.setRotation(this.smerPohybu); // povieme lodi, ze sa ma natocit smerom smerPohybu
        this.move(this.rychlost);
        this.pohybCooldown--; // this.pohybCooldown = this.pohybCooldown - 1;
    }
    
    public Raketa najdiNajblizsiehoHraca()
    {
        if (this.getWorld() == null) {
            return null;
        }
        
        List<Raketa> hraci = this.getWorld().getObjects(Raketa.class); // najdi vo svete vsetky objekty typu Raketa a uloz ich do zoznamu hraci
        int minVzdialenost = Integer.MAX_VALUE; // doposial najblizsia najdena vzdialenost
        Raketa najblizsiHrac = null;
        
        for(Raketa hrac : hraci){
            int vzdialenost = (int) Math.hypot(hrac.getX() - this.getX(), hrac.getY() - this.getY()); // vzdialenost nepriatelskej lode od aktualneho hraca
            if (vzdialenost < minVzdialenost) {
                minVzdialenost = vzdialenost;
                najblizsiHrac = hrac;
            }
        }
        return najblizsiHrac;
    }
}
