
package iceberg;

import templates.IChao;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Chao implements IChao {
    
    @Override
    public Image carregar() {
        return new ImageIcon("images/iceberg/chao.png").getImage();
    }
    
}
