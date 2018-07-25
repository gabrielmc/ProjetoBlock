package blok;

import interfaces.core.ICore;
import interfaces.core.IPluginController;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.core.IUIFactor;

public class PluginController implements IPluginController{

    private ArrayList<IUIFactor> pluginsList;
    private ArrayList<String> pluginName;
    private int chose;
    private String[] plugins;
    private URLClassLoader ulc;
    
    private ICore core;
    
    public PluginController() {
        this.pluginsList = new ArrayList<IUIFactor>();
        this.pluginName = new ArrayList<String>();
    }
            
    @Override
    public boolean initialize(ICore core) {
        this.core = core;
        File currentDir = new File("plugins");
        plugins = currentDir.list();
        int i;
        URL[] jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; i++){
            pluginName.add(i+1 + " - " + plugins[i].split("\\.")[0]);
            try {
                jars[i] = (new File("plugins/" + plugins[i])).toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ulc = new URLClassLoader(jars);
        return true;
    }
    
    private List loadPluginsByType(Class cls) throws InstantiationException, IllegalAccessException {
        ArrayList<Object> objetos = new ArrayList<Object>();
        for (IUIFactor plugin : this.pluginsList) {
            if(cls.isAssignableFrom(plugin.getClass())){
                objetos.add(plugin);
            }
        }
        return objetos;
    }
    
    @Override
    public List<ICore> getPlugins() {
        try {
            return this.loadPluginsByType(ICore.class);
        } catch (InstantiationException ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //pegar o nome dos plugin inseridos 
    @Override
    public ArrayList<String> getName() {
        return pluginName;
    }
    
    public void setUIChose(int chose) {
        this.chose = chose;
        try {
            this.pluginsList.clear();
            String factoryName = plugins[chose].split("\\.")[0];
            IUIFactor factory  = (IUIFactor) Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
            core.getGameController().setCurrentFactory(factory);
        }catch (Exception ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getUIChose() {
        return chose;
    }
}
