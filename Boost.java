import greenfoot.*;

abstract public class Boost extends Actor
{
    public Boost()
    {
        this.getImage().scale(50, 50);
    }

    public void act()
    {
        VesmirnaLod lod = (VesmirnaLod)this.getOneIntersectingObject(VesmirnaLod.class);
        
        if (lod != null)
        {
            this.aplikujSaNaLod(lod);
            this.getWorld().removeObject(this);
        }
    }
    
    abstract protected void aplikujSaNaLod(VesmirnaLod lod);
}
