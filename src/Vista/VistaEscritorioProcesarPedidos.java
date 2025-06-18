package Vista;

import Controlador.ControladorProcesarPedidos;
import Controlador.VistaProcesarPedidos;
import Modelo.EstadosDePedido.*;
import Modelo.Gestor;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VistaEscritorioProcesarPedidos extends javax.swing.JFrame implements VistaProcesarPedidos {

    private final ControladorProcesarPedidos controlador;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    
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
        labelUnidadProcesadora = new javax.swing.JLabel();
        textUnidadProcesadora = new javax.swing.JTextField();
        textNombreGestor = new javax.swing.JTextField();
        btnEntregarPedido = new javax.swing.JButton();
        btnFinalizarPedido = new javax.swing.JButton();
        panelPedidosTomados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePedidosTomados = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidosConfirmados = new javax.swing.JTable();

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

        tablePedidosTomados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePedidosTomados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tablePedidosTomados);

        javax.swing.GroupLayout panelPedidosTomadosLayout = new javax.swing.GroupLayout(panelPedidosTomados);
        panelPedidosTomados.setLayout(panelPedidosTomadosLayout);
        panelPedidosTomadosLayout.setHorizontalGroup(
            panelPedidosTomadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosTomadosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelPedidosTomadosLayout.setVerticalGroup(
            panelPedidosTomadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidosTomadosLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tablePedidosConfirmados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePedidosConfirmados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablePedidosConfirmados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGroup(layout.createSequentialGroup()
                            .addGap(633, 633, 633)
                            .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEntregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(labelUnidadProcesadora)
                    .addComponent(textUnidadProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombreGestor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTomarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPedidosTomados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.logoutGestor();
    }//GEN-LAST:event_formWindowClosing

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomarPedidoActionPerformed
        tomarPedido();
    }//GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        finalizarPedido();
    }//GEN-LAST:event_btnFinalizarPedidoActionPerformed

    private void btnEntregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarPedidoActionPerformed
        entregarPedido();
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelUnidadProcesadora;
    private javax.swing.JPanel panelPedidosTomados;
    private javax.swing.JTable tablePedidosConfirmados;
    private javax.swing.JTable tablePedidosTomados;
    private javax.swing.JTextField textNombreGestor;
    private javax.swing.JTextField textUnidadProcesadora;
    // End of variables declaration//GEN-END:variables

    //REUSAR AL MÁXIMO!!!!
    private void cambiarEstadoPedido(EstadoPedido.TipoDeEstado tipo){
        int selectedRow = tablePedidosTomados.getSelectedRow();
        Pedido pedido;
        
        if (selectedRow == -1){
            pedido = null;
        } else {
            pedido = (Pedido) tablePedidosTomados.getValueAt(tablePedidosTomados.getSelectedRow(), 5);
        }
        
        if (tipo.equals(EstadoPedido.TipoDeEstado.ENTREGADO)){
            controlador.entregarPedido(pedido);
        }
        else if (tipo.equals(EstadoPedido.TipoDeEstado.FINALIZADO)){
            controlador.finalizarPedido(pedido);
        }
    }

    //REUSO DE CÓDIGO NIVEL SSJ3!! (porque antes usábamos otro método para mostrar una lista, esto reusa mucho más)
    public void mostrarPedidos(ArrayList<Pedido> pedidos, javax.swing.JTable tablaPedidos) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre del Item");
        modelo.addColumn("Comentario");
        modelo.addColumn("Cliente");
        modelo.addColumn("Fecha y Hora");
        modelo.addColumn("Estado");
        modelo.addColumn("Pedido"); // columna oculta
        
        for (Pedido p : pedidos) {
            Object[] fila = new Object[6];

            fila[0] = p.getItem().getNombre();
            fila[1] = p.getComentario();
            fila[2] = p.getServicio().getCliente().getNombreCompleto();
            fila[3] = sdf.format(p.getFecha());
            fila[4] = p.getEstadoTexto();
            fila[5] = p; // objeto Pedido (será oculto)

            modelo.addRow(fila);
        }

        tablaPedidos.setModel(modelo);
        tablaPedidos.setDefaultEditor(Object.class, null);
        //StackOverFlow FTW: https://stackoverflow.com/questions/1990817/how-to-make-a-jtable-non-editable

        // Ocultar la columna de Pedido
        tablaPedidos.getColumnModel().getColumn(5).setMinWidth(0);
        tablaPedidos.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaPedidos.getColumnModel().getColumn(5).setWidth(0);

    }
    
    @Override
    public void mostrarInfoGestor(String nombre, String unidadProcesadora){
        textNombreGestor.setText(nombre);
        textUnidadProcesadora.setText(unidadProcesadora);
    }

    @Override
    public void tomarPedido() {
        int selectedRow = tablePedidosConfirmados.getSelectedRow();
        Pedido pedido;
        
        if (selectedRow == -1){
            pedido = null;
        } else {
            pedido = (Pedido) tablePedidosConfirmados.getValueAt(tablePedidosConfirmados.getSelectedRow(), 5);
        }
        
        controlador.tomarPedido(pedido);
    }

    @Override
    public void finalizarPedido() {
        cambiarEstadoPedido(EstadoPedido.TipoDeEstado.FINALIZADO);
    }

    @Override
    public void entregarPedido() {
        cambiarEstadoPedido(EstadoPedido.TipoDeEstado.ENTREGADO);
    }
    
    
    @Override
    public void mostrarPedidosTomados(ArrayList<Pedido> pedidosTomados) {
        mostrarPedidos(pedidosTomados, tablePedidosTomados);
    }

    @Override
    public void mostrarPedidosConfirmados(ArrayList<Pedido> pedidosConfirmados) {
        mostrarPedidos(pedidosConfirmados, tablePedidosConfirmados);
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
