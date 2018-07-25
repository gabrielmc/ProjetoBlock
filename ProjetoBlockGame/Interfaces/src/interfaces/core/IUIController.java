package interfaces.core;

public interface IUIController {
    public abstract boolean initialize(ICore core);
    public void GamePanelScreen();
    public void setUIChose(int chose);
    public int getUIChose();
}
