import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

abstract public class Hviezda extends Actor
{
    protected int zivotnost = 100;
    
    public void act()
    {
        VesmirnaLod lod = (VesmirnaLod)this.getOneIntersectingObject(VesmirnaLod.class);
        zivotnost -= 1;

        if (lod != null){
            this.effectLod(lod);
        }
        if (zivotnost == 0){
            this.Koniec(lod);
            this.getWorld().removeObject(this);
        }
    }
    protected abstract void Koniec(VesmirnaLod lod);
    protected abstract void effectLod(VesmirnaLod lod);
}
