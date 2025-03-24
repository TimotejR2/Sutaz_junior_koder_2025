import greenfoot.*;

/**
 * Image source: https://en.wikipedia.org/wiki/Supernova#/media/File:Keplers_supernova.jpg
 */
public class Supernova extends DocasnyObjekt
{
    public Supernova(int hmotnost)
    {
        super(hmotnost);
    }
    
    protected void onAct(VesmirnaLod lod)
    {
        lod.odcitajSkore(1);
    }
    
    protected void onDeath(VesmirnaLod lod)
    {
        lod.odcitajSkore(5);
    }
}
