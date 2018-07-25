package iceberg;

import interfaces.core.IBackground;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Background implements IBackground{
    @Override
    public Image loadBackground() {
        return new ImageIcon("images/iceberg/background.jpg").getImage();
    }
}
