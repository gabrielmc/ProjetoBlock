package vulcano;

import interfaces.core.IGround;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ground implements IGround{
   @Override
    public Image loadGround() {
        return new ImageIcon("images/vulcano/chao.png").getImage();
    }
}
