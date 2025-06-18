package Vista;

import Controlador.ControladorProcesarPedidos;
import Controlador.VistaProcesarPedidos;
import Modelo.EstadosDePedido.Pedido;
import Modelo.Gestor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class VistaEscritorioProcesarPedidos extends javax.swing.JFrame implements VistaProcesarPedidos {

    private final ControladorProcesarPedidos controlador;
    
    public VistaEscritorioProcesarPedidos(Gestor gestor) {
        initComponents();
        this.controlador = new ControladorProcesarPedidos(gestor, this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTomarPedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pedidosDisponibles = new javax.swing.JList();
        labelUnidadProcesadora = new javax.swing.JLabel();
        textUnidadProcesadora = new javax.swing.JTextField();
        textNombreGestor = new javax.swing.JTextField();
        btnEntregarPedido = new javax.swing.JButton();
        btnFinalizarPedido = new javax.swing.JButton();
        panelPedidosTomados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidosTomado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Gestor  :");

        jLabel3.setText("Unidad Procesadora : ");

        jLabel5.setText("|");

        btnTomarPedido.setText("Tomar Pedido");
        btnTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarPedidoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(pedidosDisponibles);

        textUnidadProcesadora.setEditable(false);

        textNombreGestor.setEditable(false);

        btnEntregarPedido.setText("Entregar Pedido");
        btnEntregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        tablePedidosTomado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePedidosTomado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablePedidosTomado);

        javax.swing.GroupLayout panelPedidosTomadosLayout = new javax.swing.GroupLayout(panelPedidosTomados);
        panelPedidosTomados.setLayout(panelPedidosTomadosLayout);
        panelPedidosTomadosLayout.setHorizontalGroup(
            panelPedidosTomadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosTomadosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelPedidosTomadosLayout.setVerticalGroup(
            panelPedidosTomadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosTomadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPedidosTomados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNombreGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textUnidadProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284)
                        .addComponent(labelUnidadProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(114, 114, 114))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(633, 633, 633)
                            .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEntregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(labelUnidadProcesadora)
                    .addComponent(textUnidadProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombreGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTomarPedido)
                .addGap(28, 28, 28)
                .addComponent(panelPedidosTomados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.logoutGestor();
    }//GEN-LAST:event_formWindowClosing

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPedidoActionPerformed
        // TODO add your handling code here:
        Pedido pedido = (Pedido) pedidosDisponibles.getSelectedValue();
        controlador.tomarPedido(pedido);
    }//GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablePedidosTomado.getSelectedRow();
        if (selectedRow != -1) {
            Pedido pedido = (Pedido) tablePedidosTomado.getValueAt(selectedRow, 5);
            controlador.finalizarPedido(pedido);
        }  else controlador.finalizarPedido(null);
    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void btnEntregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarPedidoActionPerformed
        // TODO add your handling code here:
        int selectedRow = tablePedidosTomado.getSelectedRow();
        if (selectedRow != -1) {
            Pedido pedido = (Pedido) tablePedidosTomado.getValueAt(tablePedidosTomado.getSelectedRow(), 5);
            controlador.entregarPedido(pedido);
        }  else controlador.entregarPedido(null);
    }//GEN-LAST:event_btnEntregarPedidoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntregarPedido;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelUnidadProcesadora;
    private javax.swing.JPanel panelPedidosTomados;
    private javax.swing.JList pedidosDisponibles;
    private javax.swing.JTable tablePedidosTomado;
    private javax.swing.JTextField textNombreGestor;
    private javax.swing.JTextField textUnidadProcesadora;
    // End of variables declaration//GEN-END:variables


    @Override
    public void mostrarInfoGestor(String nombre, String unidadProcesadora){
        textNombreGestor.setText(nombre);
        textUnidadProcesadora.setText(unidadProcesadora);
    }
    
    @Override
    public void mostrarPedidosConfirmados(ArrayList<Pedido> pedidosConfirmados) {
        pedidosDisponibles.setListData(pedidosConfirmados.toArray());
    }

    @Override
    public void tomarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void FinalizarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EntregarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarPedidosTomados(ArrayList<Pedido> pedidosTomados) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre del Item");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cliente");
        modelo.addColumn("Fecha y Hora");
        modelo.addColumn("Estado");
        modelo.addColumn("Pedido"); // columna oculta

        for (Pedido p : pedidosTomados) {
            Object[] fila = new Object[6];

            fila[0] = p.getItem().getNombre();
            fila[1] = p.getComentario();
            fila[2] = p.getServicio().getCliente().getUsername();
            fila[3] = LocalDateTime.now().toString();
            fila[4] = p.getEstadoTexto();
            fila[5] = p; // objeto Pedido (será oculto)

            modelo.addRow(fila);
        }

        tablePedidosTomado.setModel(modelo);
        tablePedidosTomado.setDefaultEditor(Object.class, null);
        //StackOverFlow FTW: https://stackoverflow.com/questions/1990817/how-to-make-a-jtable-non-editable

        // Ocultar la columna de Pedido
        tablePedidosTomado.getColumnModel().getColumn(5).setMinWidth(0);
        tablePedidosTomado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablePedidosTomado.getColumnModel().getColumn(5).setWidth(0);

    }
    
    @Override
    public void puedeCerrarse(){
        controlador.salir();
        this.dispose();
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR TOMAR PEDIDO", JOptionPane.ERROR_MESSAGE);
    }
}
