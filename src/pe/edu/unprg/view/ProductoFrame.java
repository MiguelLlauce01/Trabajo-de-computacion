/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pe.edu.unprg.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unprg.controller.ProductoJpaController;
import pe.edu.unprg.entity.Producto;
import pe.edu.unprg.entity.Precio;
import pe.edu.unprg.entity.TipoProducto;

public class ProductoFrame extends javax.swing.JInternalFrame {

    //CONSTRUCTOR:  arrancar o encender el programa
    public ProductoFrame() {
        initComponents();
        this.Listar();
        this.disableFormulario();
    }

    //CREAMOS UN MÉTODO PARA MOSTRAR LOS DATOS EN LA TABLA
    private ProductoJpaController cjc = new ProductoJpaController();
    private DefaultTableModel tablaP;
    private List<Producto> listaP;
    private Producto producto = new Producto();
    private String accion = "";

    private void Listar() {
        tablaP = (DefaultTableModel) this.productos_tabla.getModel();

        if (tablaP.getRowCount() > 0) {
            tablaP.setNumRows(0);
        }
        Object[] obj = new Object[7];
        try {
            listaP = cjc.findProductoEntities();

            for (int i = 0; i < listaP.size(); i++) {

                producto = (Producto) listaP.get(i);
                obj[0] = producto.getIdProducto();
                obj[1] = producto.getNombreProducto();
                obj[2] = producto.getDescripcion();
                obj[3] = producto.getPrecio().getPrecioMayor();
                obj[4] = producto.getStock();
                obj[5] = producto.getMarca();
                obj[6] = producto.getBorrado().equals("1") ? "Activo" : "Inactivo";

                tablaP.addRow(obj);

            }

            this.productos_tabla.setModel(tablaP);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de Productos" + e);
        }
    }

    // MÉTODO PARA INHABILITAR OPCIONES
    private void disableFormulario() {
        this.btn_guardar.setEnabled(false);
        this.btn_cancelar.setEnabled(false);
        this.btn_nuevo.setEnabled(true);
        this.btn_editar.setEnabled(true);
        this.btn_eliminar.setEnabled(true);
        this.txt_id.setEnabled(false);
        this.txt_id.setText("");
        this.txt_nombre.setText("");
        this.txt_stock.setText("");
        this.txt_descripcion.setText("");
        this.txt_precio.setText("");
        this.txt_marca.setText("");
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
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chexbox_estado = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productos_tabla = new javax.swing.JTable();
        lbl_imagenFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Producto");
        setToolTipText("");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SISTEMA DE PRODUCTOS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 337, 37));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 69, -1, 30));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 30));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel3.setText("descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 100, 30));

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel4.setText("stock:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 199, -1, 30));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Marca:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, 30));

        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, 25));

        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 25));

        txt_stock.setBackground(new java.awt.Color(204, 204, 204));
        txt_stock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_stock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_stock.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, 25));

        txt_descripcion.setBackground(new java.awt.Color(204, 204, 204));
        txt_descripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_descripcion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_descripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, 25));

        txt_marca.setBackground(new java.awt.Color(204, 204, 204));
        txt_marca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_marca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_marca.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 130, 25));

        txt_precio.setBackground(new java.awt.Color(204, 204, 204));
        txt_precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_precio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Estado: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, 30));

        chexbox_estado.setText("Activo");
        chexbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chexbox_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(chexbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 100, 25));

        btn_guardar.setBackground(new java.awt.Color(153, 255, 204));
        btn_guardar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 120, 30));

        btn_cancelar.setBackground(new java.awt.Color(153, 255, 204));
        btn_cancelar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 30));

        btn_nuevo.setBackground(new java.awt.Color(153, 255, 204));
        btn_nuevo.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 120, 30));

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
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 120, 30));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel7.setText("precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 70, 30));

        productos_tabla.setBackground(new java.awt.Color(204, 204, 204));
        productos_tabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        productos_tabla.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        productos_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nombre", "descripcion", "precio", "stock", "marca", "estado"
            }
        ));
        productos_tabla.setShowGrid(true);
        jScrollPane1.setViewportView(productos_tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 566, 160));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (this.validarCajasDeTexto()) {
            try {
                Producto producto = new Producto();

                producto.setNombreProducto(this.txt_nombre.getText());
                producto.setDescripcion(this.txt_descripcion.getText());
                Precio precio = new Precio();
                precio.setIdPrecio(1);
                producto.setPrecio(precio);
                producto.setStock(Integer.parseInt(this.txt_stock.getText()));
                TipoProducto tproducto = new TipoProducto();
                tproducto.setIdTipoProducto(6);
                producto.setIdTipoProducto(tproducto);
                producto.setMarca(this.txt_marca.getText());
                producto.setBorrado(this.chexbox_estado.isSelected() ? "1" : "0");

                int respuesta = 0;
                switch (accion) {
                    case "Agregar":
                        cjc.create(producto);
                        respuesta = 1;
                        break;

                    case "Editar":
                        producto.setIdProducto(Integer.valueOf(this.txt_id.getText()));
                        cjc.edit(producto);
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
                    JOptionPane.showMessageDialog(null, "Algo salió mal");
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

        if (this.productos_tabla.getSelectedRowCount() == 1) {
            accion = "Editar";
            this.enableFormulario();
            int row = this.productos_tabla.getSelectedRow();
            this.txt_id.setText(this.productos_tabla.getValueAt(row, 0).toString());

            Producto producto = new Producto();
            producto = cjc.findProducto(Integer.valueOf(txt_id.getText()));

            this.txt_nombre.setText(producto.getNombreProducto());
            this.txt_descripcion.setText(producto.getDescripcion());
            this.txt_stock.setText(String.valueOf(producto.getStock()));
            this.txt_precio.setText(String.valueOf(producto.getPrecio().getIdPrecio()));
            this.txt_marca.setText(producto.getMarca());
            this.chexbox_estado.setSelected(producto.getBorrado().equals("1"));

            if (this.chexbox_estado.isSelected()) {
                this.chexbox_estado.setText("Activo");
            } else {
                this.chexbox_estado.setText("Inactivo");
            }
            this.txt_nombre.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro o fila de la tabla");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        if (this.productos_tabla.getSelectedRowCount() == 1) {
            try {
                int row = this.productos_tabla.getSelectedRow();
                int id = Integer.parseInt(this.productos_tabla.getValueAt(row, 0).toString());
                String nombre = this.productos_tabla.getValueAt(row, 1).toString();
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al producto: " + nombre + "?") == JOptionPane.YES_OPTION) {
                    cjc.destroy(id);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
                    this.Listar();
                } else {
                    JOptionPane.showMessageDialog(null, "Por poco !!!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El producto no se puede eliminar, pero si puede quedar inactivo \n"
                                                    + " Diríjase a EDITAR y seleccione inactivo");
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
    private javax.swing.JCheckBox chexbox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagenFondo;
    private javax.swing.JTable productos_tabla;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables

    public boolean validarCajasDeTexto() {
        boolean retorno;
        if (this.txt_nombre.getText().trim().equals("") || this.txt_descripcion.getText().trim().equals("")
                || this.txt_precio.getText().trim().equals("") || this.txt_stock.getText().trim().equals("")
                || this.txt_marca.getText().trim().equals("")) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }

}
