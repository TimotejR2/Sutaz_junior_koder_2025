import greenfoot.*;

public class TurboBoost extends Boost
{
    @Override
    protected void aplikujSaNaLod(VesmirnaLod lod) {
        lod.aktivujBoost();
    }
}
