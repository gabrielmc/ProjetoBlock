package vulcano;

import java.awt.Image;
import java.io.File;
import templates.IBlocos;
import javax.swing.ImageIcon;

public class Blocos implements IBlocos{

    @Override
    public File carregar() {
        return new File("images/vulcano/block.png");
    }

    
}
