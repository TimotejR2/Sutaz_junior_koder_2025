import greenfoot.*;
import java.util.List;

public abstract class DocasnyObjekt extends Actor
{
    private int zivotnost;
    
    public DocasnyObjekt(int zivotnost)
    {
        this.zivotnost = zivotnost;
        this.getImage().scale(50, 50);
    }
    
    public void act()
    {
        List<VesmirnaLod> lode = this.getIntersectingObjects(VesmirnaLod.class);
        for (VesmirnaLod lod : lode) {
            this.onAct(lod);
        }
        
        this.zivotnost -= 1;
        if (this.zivotnost == 0) {
            for (VesmirnaLod lod : lode) {
                this.onDeath(lod);
            }
            this.getWorld().removeObject(this);
        }
    }
    
    protected abstract void onAct(VesmirnaLod lod);
    
    protected abstract void onDeath(VesmirnaLod lod);
}
