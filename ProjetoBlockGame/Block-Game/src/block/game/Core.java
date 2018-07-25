
package block.game;

import interfaces.game.ICore;
import interfaces.game.IGameController;
import interfaces.game.IPluginController;
import interfaces.game.IUIController;

/**
 *
 * @author Gabriel MC
 */
public class Core implements ICore {

    private IUIController uiController;
    private IGameController gameController;
    private IPluginController pluginController;
    
    @Override
    public boolean initialize() {
        pluginController = new PluginController();
        uiController = new UIController();
        gameController = new GameController();
        return pluginController.initialize(this) && uiController.initialize(this) && gameController.initialize(this);
    }

    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IGameController getGameController() {
        return gameController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
   
}
