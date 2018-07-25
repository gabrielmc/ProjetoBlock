package interfaces.core;

public interface ICore {
    public abstract boolean initialize();
    public abstract IUIController getUIController();
    public abstract IGameController getGameController();
    public abstract IPluginController getPluginController();
}
