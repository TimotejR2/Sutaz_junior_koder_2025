import greenfoot.*;

public class Supernova extends Hviezda
{
       @Override
    protected void Koniec(VesmirnaLod lod){
        if (lod != null){
            lod.odcitajSkore(5);
        }
        
    }
    @Override
    protected void effectLod(VesmirnaLod lod){
        lod.odcitajSkore(1);
    }
}
