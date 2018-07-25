
package iceberg;

import templates.*;

public class Iceberg implements IBlockFactory {

    private String nome = "Ice";
    
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
