import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class NepriatelskaLod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NepriatelskaLod extends Vesmirnalod
{
    private int pohybCooldown;
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
        if(ciel != null){
            this.turnTowards(ciel.getX(), ciel.getY());
            this.vystrel();
        }
        this.pohybujSa();
    }
    public void pohybujSa()
    {
        if (pohybCooldown <= 0){
            this.smerPohybu = Greenfoot.getRandomNumber(360);
            this.pohybCooldown = 50;
        }
        this.setRotation(this.smerPohybu);
        this.move(this.speed); // Pohyb rychlostou podla zadania
        this.pohybCooldown--;
    }
    
    public Raketa najdiNajblizsiehoHraca(){
        if (this.getWorld()  == null){
            return null;
        }
        
        List<Raketa>hraci = this.getWorld().getObjects(Raketa.class);
        int minVzdialenost = Integer.MAX_VALUE;
        Raketa najblizsiHrac = null;
        for(Raketa hrac: hraci){
            int vzdialenost = (int) Math.hypot(hrac.getX() - this.getX(), hrac.getY() - this.getY());
            if (vzdialenost < minVzdialenost){
                minVzdialenost = vzdialenost;
                najblizsiHrac = hrac;
            }
        }
        return najblizsiHrac;
    }
    
}
