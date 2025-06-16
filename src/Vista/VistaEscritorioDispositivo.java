package Vista;

import Controlador.ControladorDispositivo;
import Controlador.VistaDispositivo;
import Modelo.CategoriaItem;
import Modelo.EstadosDePedido.Pedido;
import Modelo.Item;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class VistaEscritorioDispositivo extends javax.swing.JFrame implements VistaDispositivo {

    private final ControladorDispositivo controlador;
    
    public VistaEscritorioDispositivo() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        controlador = new ControladorDispositivo(this);
        limpiar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textClienteId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        textClientePassword = new javax.swing.JPasswordField();
        btnLoginCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItems = new javax.swing.JList();
        btnAgregarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listCategorias = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        textComentarioPedido = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPedidosHechos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarPedido = new javax.swing.JButton();
        btnFinalizarServicio = new javax.swing.JButton();
        textMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textSistema = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("Nombre de cliente");

        textClienteId.setToolTipText("");

        jLabel1.setText("Password");

        btnLoginCliente.setText("Iniciar Sesión");
        btnLoginCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textClientePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoginCliente)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textClientePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnLoginCliente))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        listItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listItemsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listItems);

        btnAgregarPedido.setText("Agregar Pedido");
        btnAgregarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Items");

        jLabel5.setText("Categorias");

        listCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCategoriasValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listCategorias);

        textComentarioPedido.setColumns(20);
        textComentarioPedido.setRows(5);
        textComentarioPedido.setText("¿Desea modificar algo sobre la preparación? Deje su comentario acá...");
        textComentarioPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textComentarioPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textComentarioPedidoFocusLost(evt);
            }
        });
        textComentarioPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textComentarioPedidoKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(textComentarioPedido);
        textComentarioPedido.getAccessibleContext().setAccessibleName("");
        textComentarioPedido.getAccessibleContext().setAccessibleDescription("");
        textComentarioPedido.setForeground(Color.gray);

        jLabel7.setText("Comentario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarPedido)
                            .addComponent(btnEliminarPedido)))
                    .addComponent(jScrollPane4))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tablaPedidosHechos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tablaPedidosHechos);

        jLabel3.setText("Pedidos de Servicio");

        btnConfirmarPedido.setText("Confirmar Pedidos");
        btnConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarServicio.setText("Finalizar Servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        textMonto.setEditable(false);

        jLabel6.setText(" Monto ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnConfirmarPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinalizarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarPedido)
                    .addComponent(btnFinalizarServicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        textSistema.setEditable(false);
        textSistema.setBackground(new java.awt.Color(255, 255, 204));
        textSistema.setColumns(20);
        textSistema.setRows(5);
        textSistema.setText("Esperando mensajes del sistema...");
        jScrollPane6.setViewportView(textSistema);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Implementar si en algún momento aparece un CU para que el cliente pueda cerrar la UI:
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //controlador.salir();
    }//GEN-LAST:event_formWindowClosing

    private void btnLoginClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginClienteActionPerformed
        loginCliente();
    }//GEN-LAST:event_btnLoginClienteActionPerformed

    private void textComentarioPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textComentarioPedidoFocusLost
        ponerComentarioPlaceholder(textComentarioPedido);
    }//GEN-LAST:event_textComentarioPedidoFocusLost

    private void textComentarioPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textComentarioPedidoKeyTyped
        sacarComentarioPlaceholder(textComentarioPedido);
    }//GEN-LAST:event_textComentarioPedidoKeyTyped

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed
        terminarServicio();
    }//GEN-LAST:event_btnFinalizarServicioActionPerformed

    private void listItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listItemsValueChanged
        textComentarioPedido.setText("");
        ponerComentarioPlaceholder(textComentarioPedido);
    }//GEN-LAST:event_listItemsValueChanged

    private void listCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCategoriasValueChanged
       mostrarItems( (CategoriaItem) listCategorias.getSelectedValue() );
    }//GEN-LAST:event_listCategoriasValueChanged

    private void btnAgregarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPedidoActionPerformed
        Item item = (Item) listItems.getSelectedValue();
        sacarComentarioPlaceholder(textComentarioPedido);
        controlador.agregarPedido(item, textComentarioPedido.getText());
        ponerComentarioPlaceholder(textComentarioPedido);
    }//GEN-LAST:event_btnAgregarPedidoActionPerformed

    private void btnConfirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoActionPerformed
        controlador.confirmarPedidos();
    }//GEN-LAST:event_btnConfirmarPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        int fila = tablaPedidosHechos.getSelectedRow();
        if(fila != -1) {
            controlador.eliminarPedido((Pedido) tablaPedidosHechos.getValueAt(fila, 6));
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed
        
    private void ponerComentarioPlaceholder(javax.swing.JTextArea cajaDeComentarios){
        String placeholderComentario = controlador.devolverComentarioPlaceholder();
        if ("".equals(cajaDeComentarios.getText())){
            cajaDeComentarios.setText(placeholderComentario);
            cajaDeComentarios.setForeground(Color.gray);
        }
    }
    
    private void sacarComentarioPlaceholder(javax.swing.JTextArea cajaDeComentarios){
        String placeholderComentario = controlador.devolverComentarioPlaceholder();
        if ( placeholderComentario.equals( cajaDeComentarios.getText() ) ) {
            cajaDeComentarios.setText("");
        }
        
        cajaDeComentarios.setForeground(Color.black);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPedido;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnLoginCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JList listCategorias;
    private javax.swing.JList listItems;
    private javax.swing.JTable tablaPedidosHechos;
    private javax.swing.JTextField textClienteId;
    private javax.swing.JPasswordField textClientePassword;
    private javax.swing.JTextArea textComentarioPedido;
    private javax.swing.JTextField textMonto;
    private javax.swing.JTextArea textSistema;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void cambiarTitulo(String titulo){
        setTitle("Dispositivo " + controlador.getDispositivoId() + ": " + titulo);
    }
    
    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR DE LOGIN", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void loginCliente() {
        controlador.loginCliente( textClienteId.getText(), new String(textClientePassword.getPassword()) );
    }

    @Override
    public void terminarServicio() {
        controlador.terminarServicioEnDispositivo();
    }
    
    @Override
    public void limpiar(){
        mostrarPedidosHechos( new ArrayList<>() );
        setTitle("Dispositivo " + controlador.getDispositivoId());
    }

    @Override
    public void obtenerCategoriaSeleccionadaYActualizarItems() {
        mostrarItems( (CategoriaItem) listCategorias.getSelectedValue() );
    }

    @Override //Muestra el monto del servicio hasta el momento
    public void mostrarMonto(float monto) {
     textMonto.setText(monto + "");
    }

    @Override
    public void mostrarPedidosHechos(ArrayList<Pedido> pedidos) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Item");
        modelo.addColumn("Estado");
        modelo.addColumn("Unidad Procesadora");
        modelo.addColumn("Gestor");
        modelo.addColumn("Precio");
        modelo.addColumn("Comentario");
        modelo.addColumn("Pedido"); // columna oculta

        for (Pedido p : pedidos) {
            Object[] fila = new Object[7];

            fila[0] = p.getItem().getNombre();
            fila[1] = controlador.getEstadoFormateado(p);
            fila[2] = p.getEstado().equals("NO_CONFIRMADO") ? "" : p.getItem().getUnidadProcesadora().getNombre();
            fila[3] = (p.getGestor() != null) ? p.getGestor().getNombreCompleto() : "ESPERANDO GESTOR LIBRE";
            fila[4] = p.getItem().getPrecioUnitario();
            fila[5] = p.getComentario();
            fila[6] = p; // objeto Pedido (será oculto)

            modelo.addRow(fila);
        }

        tablaPedidosHechos.setModel(modelo);
        tablaPedidosHechos.setDefaultEditor(Object.class, null);
        //StackOverFlow FTW: https://stackoverflow.com/questions/1990817/how-to-make-a-jtable-non-editable

        // Ocultar la columna de Pedido
        tablaPedidosHechos.getColumnModel().getColumn(6).setMinWidth(0);
        tablaPedidosHechos.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaPedidosHechos.getColumnModel().getColumn(6).setWidth(0);
        /*
        Para los pedidos confirmados muestra la unidad procesadora donde está asignado el pedido, e
        indica si está en espera de ser tomado por un gestor o el nombre del gestor asignado, y si está
        pronto para retirar o está en elaboración o si esta entregado al cliente
        */
    }

    @Override
    public void mostrarCategorias(ArrayList<CategoriaItem> categorias) {
        listCategorias.setListData(categorias.toArray());
    }

    @Override
    public void mostrarItems(CategoriaItem categoria) {
        listItems.setListData(categoria.getItemsConStock().toArray());
    }

    @Override
    public void mostrarMensajeDelSistema(String mensaje) {
        textSistema.setText(mensaje);
    }

}
