package Vista;

import Controlador.ControladorLoginGestor;
import Controlador.VistaLoginGestor;
import Modelo.Gestor;
import javax.swing.JOptionPane;

public class VistaEscritorioLoginGestor extends javax.swing.JFrame implements VistaLoginGestor {

    private final ControladorLoginGestor controladorGestor;

    public VistaEscritorioLoginGestor() {
        initComponents();
        controladorGestor = new ControladorLoginGestor(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLoginGestor = new javax.swing.JButton();
        textGestorPwd = new javax.swing.JPasswordField();
        textGestorUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Gestor");

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        btnLoginGestor.setText("Ingresar");
        btnLoginGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginGestorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textGestorUser)
                    .addComponent(textGestorPwd)
                    .addComponent(btnLoginGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textGestorUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textGestorPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnLoginGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginGestorActionPerformed
        loginGestor();
    }//GEN-LAST:event_btnLoginGestorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginGestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textGestorPwd;
    private javax.swing.JTextField textGestorUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loginGestor() {
        controladorGestor.loginGestor(textGestorUser.getText(), new String(textGestorPwd.getPassword()) );
    }
    
    @Override
    public void abrirVentanaProcesar(Gestor gestor){
        VistaEscritorioProcesarPedidos consolaGestor = new VistaEscritorioProcesarPedidos(gestor);
        consolaGestor.setVisible(true);
        this.dispose();
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR DE LOGIN", JOptionPane.ERROR_MESSAGE);
    }
    
}
