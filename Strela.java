import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Strela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Strela extends Actor
{
    private Raketa vlastnikStrely;
    
    public Strela(Raketa raketka)
    {
        this.vlastnikStrely = raketka;
    }
    
    /**
     * Act - do whatever the Strela wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        this.move(3);
        
        if (this.isAtEdge())
        {
            World svet = this.getWorld();
            svet.removeObject(this);
        }
        else 
        {
            Raketa nepriatel = (Raketa)this.getOneIntersectingObject(Raketa.class);
            
            if (nepriatel != null)
            {
                this.getWorld().removeObject(this);
                this.vlastnikStrely.pricitajSkore(1);
                nepriatel.odcitajSkore(1);
            }
        }
    }
}
