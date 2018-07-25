package gui;

import interfaces.core.ICore;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class UIChosePanel extends JPanel {
    
    private String[] pluginsName;
    public ICore core;
    private int chose;

    public UIChosePanel(ICore core) {
        this.core = core;
        pluginsName = new String[core.getPluginController().getName().size()]; 
        initComponents();
        setFocusable(true);
    }	
    
    public int getChose() {
        return chose;
    }
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new JList();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        for(int i = 0; i < core.getPluginController().getName().size(); i++) {
            pluginsName[i] = core.getPluginController().getName().get(i);
        }
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = pluginsName;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jList1.setNextFocusableComponent(jButton1);
        jList1.setVisibleRowCount(10);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(80, 60, 250, 170);

        jButton1.setText("Escolher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(150, 260, 110, 23);

        jLabel1.setText("UI Plugins");
        add(jLabel1);
        jLabel1.setBounds(180, 30, 130, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jList1.getSelectedIndex() != -1) {
            core.getUIController().setUIChose(jList1.getSelectedIndex());
            core.getUIController().GamePanelScreen();
        } else {
            System.out.println("Escolha 1 opção!"); //Fazer tela de msg
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
