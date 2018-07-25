package blok;

import interfaces.core.ICore;
import interfaces.core.IGameController;
import interfaces.core.IPluginController;
import interfaces.core.IUIController;

public class Core implements ICore {

    @Override
    public boolean initialize() {
        pluginController = new PluginController();
        uiController = new UIController();
        gameController = new GameController();
  
        boolean run = pluginController.initialize(this) &&
                    uiController.initialize(this) &&
                    gameController.initialize(this);
        
        return run;
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
    
    private IUIController uiController;
    private IGameController gameController;
    private IPluginController pluginController;
    
}
