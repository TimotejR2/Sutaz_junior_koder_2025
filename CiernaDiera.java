import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class CiernaDiera extends Hviezda
{
    private VesmirnaLod disabled;
    public CiernaDiera(int hmotnost){
        this.zivotnost = hmotnost;
    }
    @Override
    protected void Koniec(VesmirnaLod lod){
        if (this.disabled != null){
            this.disabled.go();
        }
        if (lod != null){
            lod.go();
        }
        
    }
    @Override
    protected void effectLod(VesmirnaLod lod){
        this.disabled = lod;
        this.disabled.stop();
    }
}
