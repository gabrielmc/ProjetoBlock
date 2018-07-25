
package space;

import interfaces.core.IBackground;
import interfaces.core.IBlocks;
import interfaces.core.IGround;
import interfaces.core.IUIFactor;


public class Space  implements IUIFactor {

     @Override
    public IBackground createBackground() {
        return new Background();
    }

    @Override
    public IGround createGround() {
        return new Ground();
    }

    @Override
    public IBlocks createBlocks() {
        return new Blocks();
    }

}
