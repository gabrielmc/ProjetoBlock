package iceberg;

import templates.IBlocos;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blocos implements IBlocos{

    @Override
    public File carregar() {
        return new File("images/iceberg/block.png");
    }
}
