package space;

import interfaces.core.IBlocks;
import java.io.File;

public class Blocks implements IBlocks {
    @Override
    public File loadBlocks() {
        return new File("images/space/block.png");
    }
}
