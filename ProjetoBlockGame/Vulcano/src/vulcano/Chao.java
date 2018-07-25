
package vulcano;

import templates.IChao;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Chao implements IChao {
    
    @Override
    public Image carregar() {
        return new ImageIcon("images/vulcano/chao.png").getImage();
    }
    
}
