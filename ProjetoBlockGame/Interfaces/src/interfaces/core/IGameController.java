package interfaces.core;

public interface IGameController {
    public abstract boolean initialize(ICore core);
    public IUIFactor getCurrentFactory();
    public void setCurrentFactory(IUIFactor factory);
}
