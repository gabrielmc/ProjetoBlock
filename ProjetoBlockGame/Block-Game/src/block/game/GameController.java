package block.game;

import interfaces.game.ICore;
import interfaces.game.IGameController;
import templates.IBlockFactory;

/**
 *
 * @author Gabriel MC
 */
public class GameController implements IGameController{

    private ICore core;
    private IBlockFactory currentFactory;
    
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        return true;
    }

    @Override
    public IBlockFactory getCurrentFactory() {
        return this.currentFactory;
    }

    @Override
    public void setCurrentFactory(IBlockFactory factory) {
        this.currentFactory = factory;
    }
    
}
