package Vista;

public class VistaEscritorioDevMenu extends javax.swing.JFrame {

    public VistaEscritorioDevMenu() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCliente = new javax.swing.JMenuItem();
        btnGestor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Desarrollador");

        jMenu1.setText("Ingresar");

        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jMenu1.add(btnCliente);

        btnGestor.setText("Gestor");
        btnGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestorActionPerformed(evt);
            }
        });
        jMenu1.add(btnGestor);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestorActionPerformed
        VistaEscritorioLoginGestor vista = new VistaEscritorioLoginGestor();
        vista.setVisible(true);
    }//GEN-LAST:event_btnGestorActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        VistaEscritorioDispositivo vista = new VistaEscritorioDispositivo();
        vista.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCliente;
    private javax.swing.JMenuItem btnGestor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables



}
