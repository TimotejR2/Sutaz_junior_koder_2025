import greenfoot.*;

/**
 * Image source: https://www.eso.org/public/images/eso2105a/
 */
public class CiernaDiera extends DocasnyObjekt
{
    public CiernaDiera(int hmotnost)
    {
        super(hmotnost);
    }
    
    protected void onAct(VesmirnaLod lod)
    {
        lod.deaktivujPohyb();        
    }
    
    protected void onDeath(VesmirnaLod lod)
    {
        lod.aktivujPohyb();
    }
}
