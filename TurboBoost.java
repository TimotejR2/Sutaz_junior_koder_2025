import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurboBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurboBoost extends Actor
{
    public TurboBoost(){
        this.getImage().scale(50, 50);
    }
    public void act()
    {
        Vesmirnalod lod = (Vesmirnalod)this.getOneIntersectingObject(Vesmirnalod.class);
        if (lod != null && lod.turboUsable() == true){
            lod.turbo();
            this.getWorld().removeObject(this);
        }
    }
}
