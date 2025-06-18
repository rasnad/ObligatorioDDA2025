package Vista;

import java.awt.Dialog;
import javax.swing.JOptionPane;

public class Dialogo extends javax.swing.JDialog {

    public Dialogo(java.awt.Frame parent) {
        super(parent, false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar(JOptionPane pane, String titulo){
        Dialog dialog = pane.createDialog(this, titulo);
        dialog.setModal(false);
        dialog.setVisible(true);
    }
    
    public void mostrarError(String titulo, String mensaje) {
        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.ERROR_MESSAGE);
        mostrar(pane, titulo);
        
    }
    
    public void mostrarInfo(String titulo, String mensaje) {
        JOptionPane pane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
        mostrar(pane, titulo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
