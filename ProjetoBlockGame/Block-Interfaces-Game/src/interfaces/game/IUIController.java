
package interfaces.game;

public interface IUIController {
    public boolean initialize(ICore core);
    public void gamePanel();
    public void setUIChose(int chose);
    public int getUIChose();
}
