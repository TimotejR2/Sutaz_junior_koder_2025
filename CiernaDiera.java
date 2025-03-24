import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

public class CiernaDiera extends Hviezda
{
    private List<VesmirnaLod> disabled = new ArrayList<>();
    public CiernaDiera(int hmotnost){
        this.zivotnost = hmotnost;
    }
    @Override
    protected void Koniec(VesmirnaLod lod){
        while (!disabled.isEmpty()){
            lod = disabled.get(0);
            disabled.remove(0);
            lod.go();
        }
        
    }
    @Override
    protected void effectLod(VesmirnaLod lod){
        this.disabled.add(lod);
        lod.stop();
    }
}
