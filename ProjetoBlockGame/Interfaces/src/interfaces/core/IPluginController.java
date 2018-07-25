package interfaces.core;

import java.util.ArrayList;
import java.util.List;

public interface IPluginController {
    public abstract boolean initialize(ICore core);
    public List<ICore> getPlugins();
    public ArrayList<String> getName();
    public void setUIChose(int chose);
    public int getUIChose();
}
