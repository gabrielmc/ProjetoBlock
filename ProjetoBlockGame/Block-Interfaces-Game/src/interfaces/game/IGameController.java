
package interfaces.game;

import templates.IBlockFactory;

public interface IGameController {
    public boolean initialize(ICore core);
    public IBlockFactory getCurrentFactory();
    public void setCurrentFactory(IBlockFactory factory);
}
