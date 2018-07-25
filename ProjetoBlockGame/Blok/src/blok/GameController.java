package blok;

import interfaces.core.ICore;
import interfaces.core.IGameController;
import interfaces.core.IUIFactor;

public class GameController implements IGameController {
    private ICore core;
    IUIFactor currentFactory;

    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        return true;
    }
    
    public IUIFactor getCurrentFactory() {
        return currentFactory;
    }
    
    public void setCurrentFactory(IUIFactor factory) {
        currentFactory = factory;
    }
}
