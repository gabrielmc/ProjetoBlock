
package space;

import templates.IBlocos;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blocos implements IBlocos{

    @Override
    public File carregar() {
        return new File("images/space/block.png");
    }
    
}
