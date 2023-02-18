/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pe.edu.unprg.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unprg.controller.ClienteJpaController;
import pe.edu.unprg.entity.Cliente;

/**
 *
 * @author asus
 */
public class ClienteFrame extends javax.swing.JInternalFrame {

    //CONSTRUCTOR: Se ejecuta al arrancar o encender el programa
    public ClienteFrame() {
        initComponents();
        //Llamamos al método listar; para mostrar los datos de una tabla desde un inicio
        this.Listar();
        //Habilitamos y deshabilitamos los botones necesarios para evitar errores
        this.disableFormulario();
    }

    //====================================================================================================
    //CREAMOS UN MÉTODO PARA MOSTRAR LOS DATOS EN LA TABLA
    //Instanciamos clases y creamos objetos para usar más adelante(En le método Listar)
    private ClienteJpaController cjc = new ClienteJpaController();
    private DefaultTableModel tabla;
    private List<Cliente> listaCliente;
    private Cliente cliente = new Cliente();
    private String accion = "";

    private void Listar() {
        //
        tabla = (DefaultTableModel) this.tbl_tablaDatos.getModel();
        //Controlamos si es que se han encontrado registros en la tabla
        if (tabla.getRowCount() > 0) {
            //Vaciar o eliminar los datos
            tabla.setNumRows(0);
        }
        //Crear un objeto de arreglo de objetos de 5 columnas
        Object[] obj = new Object[8];
        //
        try {
            //Recuperamos la lista de clientes que se tengan registrados en la base de datos
            listaCliente = cjc.findClienteEntities();
            //Mostramos los datos de toda la lista de clientes encontrados
            for (int i = 0; i < listaCliente.size(); i++) {
                //Tomar los datos solo de un cliente de la lista de clientes
                cliente = (Cliente) listaCliente.get(i);
                //Asiganar en el arreglo deobjeto los 5 datos del cliente
                obj[0] = cliente.getIdCliente();
                obj[1] = cliente.getNombre();
                obj[2] = cliente.getApellidoM();
                obj[3] = cliente.getApellidoP();
                obj[4] = cliente.getUbicacion();
                obj[5] = cliente.getDni();
                obj[6] = cliente.getTelefono();
                //Si es que el estado del cliente está en "1" entonces que se muestre "Activo"; sino "Inactivo"
                obj[7] = cliente.getBorrado().equals("1") ? "Activo" : "Inactivo";

                //Agregar el cliente en una fila de la "tabla"
                tabla.addRow(obj);
            }
            //Agregar la "tabla" que contiene la lista de clientes a la tabla visual de nombre "tbl_datos"
            this.tbl_tablaDatos.setModel(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla: tbl_datos: \n" + e);
        }
    }

    //====================================================================================================
    //CREAMOS UN MÉTODO PARA INHABILITAR OPCIONES EN EL FORULARIO DE CLIENTES
    private void disableFormulario() {
        this.btn_guardar.setEnabled(false);
        this.btn_cancelar.setEnabled(false);
        this.btn_nuevo.setEnabled(true);
        this.btn_editar.setEnabled(true);
        this.btn_eliminar.setEnabled(true);
        this.txt_id.setEnabled(false);
        this.txt_id.setText("");
        this.txt_nombre.setText("");
        this.txt_apellidoMaterno.setText("");
        this.txt_apellidoPaterno.setText("");
        this.txt_ubicacion.setText("");
        this.txt_dni.setText("");
        this.txt_telefono.setText("");
        this.chexbox_estado.setText("Activo");
        this.chexbox_estado.setSelected(false);
    }

    //CREAMOS UN MÉTODO PARA HABILITAR OPCIONES EN EL FORULARIO DE CLIENTES
    private void enableFormulario() {
        this.btn_guardar.setEnabled(true);
        this.btn_cancelar.setEnabled(true);
        this.btn_nuevo.setEnabled(false);
        this.btn_editar.setEnabled(false);
        this.btn_eliminar.setEnabled(false);
        this.chexbox_estado.setSelected(true);
    }
    //====================================================================================================

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
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellidoMaterno = new javax.swing.JTextField();
        txt_apellidoPaterno = new javax.swing.JTextField();
        txt_dni = new javax.swing.JTextField();
        txt_ubicacion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chexbox_estado = new javax.swing.JCheckBox();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tablaDatos = new javax.swing.JTable();
        lbl_imagenFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cliente");
        setToolTipText("");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SISTEMA DE CLIENTES");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 337, 37));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Apell. Paterno: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Apell. Materno: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 205, -1, -1));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Dni: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 115, -1, -1));

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Ubicación: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 255, -1, -1));

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Teléfono: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 75, -1, -1));

        txt_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_id.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, 25));

        txt_nombre.setBackground(new java.awt.Color(204, 204, 204));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 25));

        txt_apellidoMaterno.setBackground(new java.awt.Color(204, 204, 204));
        txt_apellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellidoMaterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_apellidoMaterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_apellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, 25));

        txt_apellidoPaterno.setBackground(new java.awt.Color(204, 204, 204));
        txt_apellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellidoPaterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_apellidoPaterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_apellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, 25));

        txt_dni.setBackground(new java.awt.Color(204, 204, 204));
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_dni.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 130, 25));

        txt_ubicacion.setBackground(new java.awt.Color(204, 204, 204));
        txt_ubicacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ubicacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ubicacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, 25));

        txt_telefono.setBackground(new java.awt.Color(204, 204, 204));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Estado: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 155, -1, -1));

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
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 120, 30));

        btn_cancelar.setBackground(new java.awt.Color(153, 255, 204));
        btn_cancelar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 120, 30));

        btn_nuevo.setBackground(new java.awt.Color(153, 255, 204));
        btn_nuevo.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_nuevo.setText("Nuevo");
        btn_nuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 120, 30));

        btn_editar.setBackground(new java.awt.Color(153, 255, 204));
        btn_editar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 120, 30));

        btn_eliminar.setBackground(new java.awt.Color(153, 255, 204));
        btn_eliminar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, 30));

        tbl_tablaDatos.setBackground(new java.awt.Color(204, 204, 204));
        tbl_tablaDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_tablaDatos.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        tbl_tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "A_paterno", "A_materno", "Ubicación", "Dni", "Teléfono", "Estado"
            }
        ));
        tbl_tablaDatos.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_tablaDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 566, 160));

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
        // Programamos el botón guardar para registrar a un cliente:
        if (this.validarCajasDeTexto()) {

            try {
                //Instanciamos la clase cliente
                Cliente cliente = new Cliente();
                //REgistramos los atributos del cliente que escribió en el formulario
                cliente.setNombre(this.txt_nombre.getText());
                cliente.setApellidoP(this.txt_apellidoPaterno.getText());
                cliente.setApellidoM(this.txt_apellidoMaterno.getText());
                cliente.setUbicacion(this.txt_ubicacion.getText());
                cliente.setDni(this.txt_dni.getText());
                cliente.setTelefono(this.txt_telefono.getText());
                cliente.setBorrado(this.chexbox_estado.isSelected() ? "1" : "0");
                //Declaramos una variable respuesta: 
                int respuesta = 0;
                //Creamos un Switch-case para poder controlar la acción que se realise
                switch (accion) {
                    case "Agregar":
                        //Hacemos uso del objeto creado de la clase "ClienteControlador" para agregar un cliente
                        cjc.create(cliente);
                        //CAmbiamos el estado de la variable respuesta: 
                        respuesta = 1;
                        break;
                    case "Editar":
                        //Enviamos el Id del cliente: 
                        cliente.setIdCliente(Integer.parseInt(this.txt_id.getText()));
                        //Hacemos uso del objeto creado de la clase "ClienteControlador" para EDITAR un cliente
                        cjc.edit(cliente);
                        //CAmbiamos el estado de la variable respuesta: 
                        respuesta = 1;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Acción no encontrada");
                }

                if (respuesta == 1) {
                    //Mostramos mensaje de confirmación de registro
                    JOptionPane.showMessageDialog(null, "Operación realizada con éxito");
                    //Mostramos los clientes registrados en la tabla de listado
                    this.Listar();
                    //Habilitamos la opción "Nuevo, editar y eliminar" Y deshabilitamos la opción "guardar y cancelar"
                    this.disableFormulario();
                } else {
                    JOptionPane.showMessageDialog(null, "Algo salió mal: No hay programación para esta acción :v");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR en el botón guardar: " + e);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No debe dejar ningún casillero vacío");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        //PROGRAMAMOS EL COTÓN CANCELAR
        this.disableFormulario();//habilitamos y deshabilitamos los botones necesarios
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // Activamos los botones guardar y cancelar; así mismo inabilitamos los botones: nuevo, editar y eliminar
        this.enableFormulario();
        //
        accion = "Agregar";
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // Programamamos el botón EDitar o "Update"=ACtualizar
        //Controlamos que se haya seleccionado un registro(fila) de la tabla
        if (this.tbl_tablaDatos.getSelectedRowCount() == 1) {
            //Actualizamos el estado de la variable "accion"
            accion = "Editar"; //Este estado afectará cuando se presione el "botón guardar"
            //Habilitamos y deshabilitamos los botones necesarios
            this.enableFormulario();
            //Guardamos el número de fila que se ha seleccionado
            int row = this.tbl_tablaDatos.getSelectedRow();
            //Agregamos el ID en la caja de texto del formulario del cliente seleccionado
            this.txt_id.setText(this.tbl_tablaDatos.getValueAt(row, 0).toString());
            //Instacmciar la clase cliente
            Cliente cliente = new Cliente();
            //
            cliente = cjc.findCliente(Integer.parseInt(txt_id.getText()));//No sé que gace el método "finCliente"
            //Agregamos los datos del cliente a su respectiva caja de texto3
            this.txt_nombre.setText(cliente.getNombre());
            this.txt_apellidoPaterno.setText(cliente.getApellidoP());
            this.txt_apellidoMaterno.setText(cliente.getApellidoM());
            this.txt_ubicacion.setText(cliente.getUbicacion());
            this.txt_dni.setText(cliente.getDni());
            this.txt_telefono.setText(cliente.getTelefono());
            this.chexbox_estado.setSelected(cliente.getBorrado().equals("1"));
            //Si es que el chexBox está seleccionado entonces mostrar "Activo"
            if (this.chexbox_estado.isSelected()) {
                //Colocar mensaje de "Activo"
                this.chexbox_estado.setText("Activo");
            } else {
                //Mostrar mensaje "Inactivo"
                this.chexbox_estado.setText("Inativo");
            }
            //Centramos el foco en la caja de nombres:
            this.txt_nombre.requestFocus();
        } else {
            //Mostrar mnesaje para que seleccione un registro
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro o fila de la tabla");
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // PROGRAMAMOS EL BOTÓN ELIMINAR
        //Validamos si es que se ha seleccionado una fila o un rgistro de la tabla
        if (this.tbl_tablaDatos.getSelectedRowCount() == 1) {
            try {
                //Recuperamos el número de fila que ha sido seleccionado de la tabla
                int row = this.tbl_tablaDatos.getSelectedRow();
                //REcuperamos el ID de la fila seleccionada: 
                int id = Integer.parseInt(this.tbl_tablaDatos.getValueAt(row, 0).toString());
                //Recuperamos el Nombre del cliente seleccionado en la tabla: 
                String nombre = this.tbl_tablaDatos.getValueAt(row, 1).toString();
                //Preguntamos si es que está seguro de eliminar al cliente: 
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a: " + nombre + "?") == JOptionPane.YES_OPTION) {
                    //Eliminamos al cliente, usamos el objeto creado de la clase controlador
                    cjc.destroy(id);
                    //Mostrar mensaje informando que la operación se realizó correctamente: 
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
                    //Listamos los clientes registrados actualmente: 
                    this.Listar();
                } else {
                    JOptionPane.showMessageDialog(null, "En hora buena, casito se ha eliminado el registro :v \n "
                            + "Ten más cuidado para la próxima, si? jajaja");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en buscar datos de la tabla para eliminar");
            }
        } else {
            //Sino se ha seleccionado una fila de la tabla, entonces mostrar mensaje: 
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro");
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void chexbox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chexbox_estadoActionPerformed
        // Programamos el chetbox cuando esté seleccionado o no:
        if (this.chexbox_estado.isSelected()) {
            //Escribir que está activo
            this.chexbox_estado.setText("Activo");
        } else {
            //Escribir que está Inactivo
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagenFondo;
    private javax.swing.JTable tbl_tablaDatos;
    private javax.swing.JTextField txt_apellidoMaterno;
    private javax.swing.JTextField txt_apellidoPaterno;
    private javax.swing.JTextField txt_dni;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ubicacion;
    // End of variables declaration//GEN-END:variables

    //====================================================================================================
    //CREAMOS UN MÉTODO PARA VALIDAR LAS CAJAS DE TEXTO
    public boolean validarCajasDeTexto() {
        boolean retorno;
        if (this.txt_nombre.getText().trim().equals("") || this.txt_apellidoPaterno.getText().trim().equals("")
                || this.txt_apellidoMaterno.getText().trim().equals("") || this.txt_ubicacion.getText().trim().equals("")
                || this.txt_dni.getText().trim().equals("") || this.txt_telefono.getText().trim().equals("")) {
            retorno = false;
        } else {
            retorno = true;
        }
        return retorno;
    }
    //====================================================================================================
}
