package blok;

import gui.GamePanel;
import gui.UIChosePanel;
import interfaces.core.ICore;
import interfaces.core.IUIController;
import java.awt.Dimension;
import javax.swing.JFrame;

public class UIController extends JFrame implements IUIController {
    private ICore core;
    private int chose;

    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        Dimension sizeUIChose = new Dimension(400, 300);
        setVisible(true);
        
        UIChosePanel chosePanel = new UIChosePanel(core);
        chosePanel.setPreferredSize(sizeUIChose);
        chosePanel.setMinimumSize(sizeUIChose);
        chosePanel.setMaximumSize(sizeUIChose);
        chosePanel.setSize(sizeUIChose);
        setContentPane(chosePanel);
        setResizable(false);
        pack();
       
        return true;
    }
    
    public void GamePanelScreen() {
        Dimension sizeGamePanel = new Dimension(1000, 600);
        GamePanel gamePanel = new GamePanel(core);
        gamePanel.setPreferredSize(sizeGamePanel);
        gamePanel.setMinimumSize(sizeGamePanel);
        gamePanel.setMaximumSize(sizeGamePanel);
        gamePanel.setSize(sizeGamePanel);
        setContentPane(gamePanel);
        setResizable(false);
        pack();
        Simulator simulator = new Simulator(gamePanel);
        gamePanel.setSimulator(simulator);
        simulator.init();
    }
    
    public void setUIChose(int chose) {
        this.chose = chose;
        core.getPluginController().setUIChose(chose);
    }
    
    public int getUIChose() {
        return chose;
    }
}
