
package space;


import templates.*;

public class Space  implements IBlockFactory {

    private String nome = "Space";
    
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
