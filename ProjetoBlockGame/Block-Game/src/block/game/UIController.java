
package block.game;

import gui.ChooseTheme;
import gui.MainPanel;
import interfaces.game.ICore;
import interfaces.game.IUIController;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel MC
 */
public class UIController extends JFrame implements IUIController {

    private ICore core;
    private int chose;
    
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        Dimension sizeUIChose = new Dimension(400, 300);
        setVisible(true);
        
        ChooseTheme chosePanel = new ChooseTheme(core);
        chosePanel.setPreferredSize(sizeUIChose);
        chosePanel.setMinimumSize(sizeUIChose);
        chosePanel.setMaximumSize(sizeUIChose);
        chosePanel.setSize(sizeUIChose);
        setContentPane(chosePanel);
        setResizable(false);
        pack();
        return true;
    }
    
    
    @Override
    public void gamePanel() {
        Dimension sizeGamePanel = new Dimension(1000, 600);
        MainPanel gamePanel = new MainPanel(core);
        gamePanel.setPreferredSize(sizeGamePanel);
        gamePanel.setMinimumSize(sizeGamePanel);
        gamePanel.setMaximumSize(sizeGamePanel);
        gamePanel.setSize(sizeGamePanel);
        setContentPane(gamePanel);
        setResizable(false);
        pack();
        
        //inicia a simulação via MainPanel
        Simulator simulator = new Simulator(gamePanel);
        gamePanel.setSimulator(simulator);
        simulator.init();
    }
    
    @Override
    public void setUIChose(int chose) {
        this.chose = chose;
        core.getPluginController().setUIChose(chose);
    }

    @Override
    public int getUIChose() {
        return chose;
    }
    
}
