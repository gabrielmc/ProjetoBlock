package vulcano;

import templates.*;

public class Vulcano implements IBlockFactory {

    private String nome = "Vulcano";
    
    @Override
    public IChao createChao() {
        return new Chao();
    }

    @Override
    public IBackground createBackground() {
        return new Background();
    }

    @Override
    public IBlocos createBlocos() {
        return new Blocos();
    }

}
