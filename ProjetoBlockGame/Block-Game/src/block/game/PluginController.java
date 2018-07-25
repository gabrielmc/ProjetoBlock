package block.game;

import interfaces.game.ICore;
import interfaces.game.IPluginController;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import templates.IBlockFactory;

/**
 *
 * @author Gabriel MC
 */
public class PluginController implements IPluginController{

    private ICore core;
    private ArrayList<IBlockFactory> pluginsList;
    private ArrayList<String> pluginName;
    private String[] plugins;
    private URLClassLoader ulc;
    private int op;
    
    public PluginController() {
        this.pluginsList = new ArrayList<IBlockFactory>();
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
        this.pluginsList.clear();
        return true;
    }
    
    private List loadPluginsByType(Class cls) throws InstantiationException, IllegalAccessException {
        ArrayList<Object> objetos = new ArrayList<Object>();
        for (IBlockFactory plugin : this.pluginsList) {
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

    @Override
    public ArrayList<String> getName() {
        return pluginName;
    }

    @Override
    public void setUIChose(int op) {
        this.op = op;
        try {
            String factoryName = plugins[op].split("\\.")[0];
            IBlockFactory factory = (IBlockFactory) Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
            core.getGameController().setCurrentFactory(factory);
        }catch (Exception ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int getUIChose() {
        return op;
    }
    
}
