
package space;

import templates.IBackground;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Background implements IBackground {

    @Override
    public Image carregar() {
        return new ImageIcon("images/space/background.jpg").getImage();
    }
    
}
