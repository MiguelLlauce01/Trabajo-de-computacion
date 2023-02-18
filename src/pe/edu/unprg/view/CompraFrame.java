/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pe.edu.unprg.view;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unprg.controller.CompraJpaController;
import pe.edu.unprg.entity.Compra;
import pe.edu.unprg.entity.Producto;
import pe.edu.unprg.entity.Proveedor;
import pe.edu.unprg.entity.Usuario;

/**
 *
 * @author asus
 */
public class CompraFrame extends javax.swing.JInternalFrame {

    public CompraFrame() {
        initComponents();
        this.Listar();
        this.disableFormulario();
        
    }

    //CREAMOS UN MÉTODO PARA MOSTRAR LOS DATOS EN LA TABLA
    private CompraJpaController cjc = new CompraJpaController();
    private DefaultTableModel tablaC;
    private List<Compra> listaCompra;
    private Compra compra = new Compra();
    private String accion = "";

    private void Listar() {
        tablaC = (DefaultTableModel) this.tablacompras.getModel();
        if (tablaC.getRowCount() > 0) {
            tablaC.setNumRows(0);
        }
        Object[] obj = new Object[8];

        try {
            listaCompra = cjc.findCompraEntities();
            for (int i = 0; i < listaCompra.size(); i++) {
                compra = (Compra) listaCompra.get(i);
                obj[0] = compra.getIdCompra();
                obj[1] = compra.getIdProducto().getIdProducto();
                obj[2] = compra.getCantidad();
                obj[3] = compra.getPrecioCompra();
                obj[4] = compra.getIdProveedor().getIdProveedor();
                    //Establecemos el formato de la fecha con la que se mostrarán los datos
                    DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //Convertimos a String las fechas de tipo date en el formato antes establecido
                    String fecha = f.format(compra.getFecha());
                obj[5] = Timestamp.valueOf(fecha);
                obj[6] = compra.getTotal();
                obj[7] = compra.getBorrado().equals("1") ? "Activo" : "Inactivo";

                tablaC.addRow(obj);
            }
            this.tablacompras.setModel(tablaC);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de Compras" + e);
        }
    }

    // MÉTODO PARA INHABILITAR OPCIONES
    private void disableFormulario() {
        this.btn_guardar.setEnabled(false);
        this.btn_cancelar.setEnabled(false);
        this.btn_nuevo.setEnabled(true);
        this.btn_editar.setEnabled(true);
        this.btn_eliminar.setEnabled(true);
        this.idcompra_txt.setEnabled(false);
        this.idcompra_txt.setText("");
        this.idProd_txt.setText("");
        this.preciouno_txt.setText("");
         this.preciototal_txt.setText("");
        this.cantidad_txt.setText("");
        this.proveedor_txt.setText("");
        this.responsable_txt.setText("");
        this.fecha_txt.setCalendar(null);
        this.chexbox_estado.setText("Activo");
        this.chexbox_estado.setSelected(false);
    }

    //MÉTODO PARA HABILITAR OPCIONES 
    private void enableFormulario() {
        this.btn_guardar.setEnabled(true);
        this.btn_cancelar.setEnabled(true);
        this.btn_nuevo.setEnabled(false);
        this.btn_editar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.chexbox_estado.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idcompra_txt = new javax.swing.JTextField();
        idProd_txt = new javax.swing.JTextField();
        preciouno_txt = new javax.swing.JTextField();
        cantidad_txt = new javax.swing.JTextField();
        responsable_txt = new javax.swing.JTextField();
        proveedor_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chexbox_estado = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        preciototal_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacompras = new javax.swing.JTable();
        fecha_txt = new com.toedter.calendar.JDateChooser();
        lbl_imagenFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Compras");
        setToolTipText("");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SISTEMA DE Compras");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 337, 37));
        jLabel10.getAccessibleContext().setAccessibleName("SISTEMA DE COMPRAS");

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel2.setText("id producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel3.setText("cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel4.setText("precio unid:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setText("PRecio total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 109, -1, 30));

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel6.setText("proveedor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 249, -1, 30));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel7.setText("FEcha: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 70, 60, 30));

        idcompra_txt.setBackground(new java.awt.Color(204, 204, 204));
        idcompra_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idcompra_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        idcompra_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(idcompra_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, 25));

        idProd_txt.setBackground(new java.awt.Color(204, 204, 204));
        idProd_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idProd_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        idProd_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(idProd_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 25));

        preciouno_txt.setBackground(new java.awt.Color(204, 204, 204));
        preciouno_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        preciouno_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        preciouno_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(preciouno_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, 25));

        cantidad_txt.setBackground(new java.awt.Color(204, 204, 204));
        cantidad_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidad_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cantidad_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(cantidad_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, 25));

        responsable_txt.setBackground(new java.awt.Color(204, 204, 204));
        responsable_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        responsable_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        responsable_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(responsable_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 130, 25));

        proveedor_txt.setBackground(new java.awt.Color(204, 204, 204));
        proveedor_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proveedor_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proveedor_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(proveedor_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, 25));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Responsable:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, 30));

        chexbox_estado.setText("Activo");
        chexbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chexbox_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(chexbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 100, 25));

        btn_guardar.setBackground(new java.awt.Color(153, 255, 204));
        btn_guardar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, 30));

        btn_cancelar.setBackground(new java.awt.Color(153, 255, 204));
        btn_cancelar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 120, 30));

        btn_nuevo.setBackground(new java.awt.Color(153, 255, 204));
        btn_nuevo.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 120, 30));

        btn_editar.setBackground(new java.awt.Color(153, 255, 204));
        btn_editar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 120, 30));

        btn_eliminar.setBackground(new java.awt.Color(153, 255, 204));
        btn_eliminar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 120, 30));

        preciototal_txt.setBackground(new java.awt.Color(204, 204, 204));
        preciototal_txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        preciototal_txt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        preciototal_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(preciototal_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 130, 25));

        jLabel11.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Estado: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 70, 30));

        tablacompras.setBackground(new java.awt.Color(204, 204, 204));
        tablacompras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablacompras.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        tablacompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idCompra", "idProducto", "Cantidad", "Precio Unidad", "Proveedor", "Fecha", "Precio Total", "Borrado"
            }
        ));
        tablacompras.setShowGrid(true);
        jScrollPane1.setViewportView(tablacompras);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 566, 140));

        fecha_txt.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(fecha_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        lbl_imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/unprg/images/fondo10.jpg"))); // NOI18N
        jPanel1.add(lbl_imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("Compra");
        getAccessibleContext().setAccessibleDescription("Compra");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
    
        if (this.validarCajasDeTexto()) {
            try {
                Compra compra = new Compra();
                //compra.setIdProducto(this.idProd_txt.getText());
                    Producto producto = new Producto();
                    producto.setIdProducto(Integer.parseInt(this.idProd_txt.getText().trim()));
                compra.setIdProducto(producto);
                compra.setCantidad(Integer.parseInt(this.cantidad_txt.getText().trim()));
                compra.setPrecioCompra(Double.parseDouble(this.preciouno_txt.getText()));
                    Proveedor proveedor = new Proveedor();
                    proveedor.setIdProveedor(Integer.parseInt(this.proveedor_txt.getText().trim()));
                compra.setIdProveedor(proveedor);
                    //Recuperamos las fechas seleeccionadas:
                    Date fechaE = this.fecha_txt.getDate();
                    //Establecemos el formato en que se desea obtener la fecha
                    DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    //Convertimos a String las fechas de tipo date en el formato antes establecido
                    String fecha = f.format(fechaE);
                    //Pasamos la fecha al formato TimesTamp para poder registrarlas en la base de datos:
                    Timestamp fechaOficial = Timestamp.valueOf(fecha);
                compra.setFecha(fechaOficial);
                compra.setTotal(Double.parseDouble(this.preciototal_txt.getText().trim()));
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(1);
                compra.setResponsable(usuario);                
                compra.setArchivo("Sin archivo");
                compra.setBorrado(this.chexbox_estado.isSelected() ? "1" : "0");

                int respuesta = 0;
                switch (accion) {
                    case "Agregar":
                        cjc.create(compra);
                        respuesta = 1;
                        break;
                        
                    case "Editar":
                        compra.setIdCompra(Integer.parseInt(this.idcompra_txt.getText()));
                        cjc.edit(compra);
                        respuesta = 1;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Acción no encontrada");
                }

                 if (respuesta == 1) {
                    JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
                    this.Listar();
                    this.disableFormulario();
                } else {
                    JOptionPane.showMessageDialog(null, "Algo salió mal en la acción: "+accion);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR en el botón guardar: " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No debe dejar ningún casillero vacío");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.disableFormulario();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        this.enableFormulario();
        accion = "Agregar";
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed

        if (this.tablacompras.getSelectedRowCount() == 1) {
            accion = "Editar"; 
            this.enableFormulario();
            int row = this.tablacompras.getSelectedRow();
            this.idcompra_txt.setText(this.tablacompras.getValueAt(row, 0).toString());

            Compra compra = new Compra();
            compra = cjc.findCompra(Integer.valueOf(idcompra_txt.getText()));
            
            this.idProd_txt.setText(String.valueOf(compra.getIdProducto().getIdProducto()));
            this.cantidad_txt.setText(String.valueOf(compra.getCantidad()));
            this.preciouno_txt.setText(String.valueOf(compra.getPrecioCompra()));
            this.preciototal_txt.setText(String.valueOf(compra.getTotal()));
            this.proveedor_txt.setText(String.valueOf(compra.getIdProveedor().getIdProveedor()));
                //Establecemos el formato en que se desea mostrar la fecha
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //Convertimos a String las fechas de tipo date en el formato antes establecido
                String fecha = f.format(compra.getFecha());
            this.fecha_txt.setDate(Timestamp.valueOf(fecha));
            this.responsable_txt.setText(String.valueOf(compra.getResponsable().getIdUsuario()));
            this.chexbox_estado.setSelected(compra.getBorrado().equals("1"));
  
            if (this.chexbox_estado.isSelected()) {
                this.chexbox_estado.setText("Activo");
            } else {
                this.chexbox_estado.setText("Inactivo");
            }
                        
            this.cantidad_txt.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro o fila de la tabla");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        if (this.tablacompras.getSelectedRowCount() == 1) {
            try {
                int row = this.tablacompras.getSelectedRow();
                int id = Integer.parseInt(this.tablacompras.getValueAt(row, 0).toString()); 
                //String idcompra = this.tablacompras.getValueAt(row, 1).toString();
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a la compra: " + id + "?") == JOptionPane.YES_OPTION) {
                    cjc.destroy(id);
                    JOptionPane.showMessageDialog(null, "Compra eliminada correctamente");
                    this.Listar();
                } else {
                    JOptionPane.showMessageDialog(null, "Por poco !!!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en buscar datos de la tabla para eliminar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void chexbox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chexbox_estadoActionPerformed

        if (this.chexbox_estado.isSelected()) {
            this.chexbox_estado.setText("Activo");
        } else {
            this.chexbox_estado.setText("Inactivo");
        }
    }//GEN-LAST:event_chexbox_estadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JTextField cantidad_txt;
    private javax.swing.JCheckBox chexbox_estado;
    private com.toedter.calendar.JDateChooser fecha_txt;
    private javax.swing.JTextField idProd_txt;
    private javax.swing.JTextField idcompra_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagenFondo;
    private javax.swing.JTextField preciototal_txt;
    private javax.swing.JTextField preciouno_txt;
    private javax.swing.JTextField proveedor_txt;
    private javax.swing.JTextField responsable_txt;
    private javax.swing.JTable tablacompras;
    // End of variables declaration//GEN-END:variables


    public boolean validarCajasDeTexto() {
        boolean retorno;
        if ( this.idProd_txt.getText().trim().equals("") || this.cantidad_txt.getText().trim().equals("")
                || this.preciouno_txt.getText().trim().equals("") 
                || this.proveedor_txt.getText().trim().equals("") || this.preciototal_txt.getText().trim().equals("")) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }
   
}
