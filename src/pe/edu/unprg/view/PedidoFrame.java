/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package pe.edu.unprg.view;

import com.toedter.calendar.JDateChooser;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.unprg.controller.PedidoJpaController1;
import pe.edu.unprg.entity.Cliente;
import pe.edu.unprg.entity.Pedido;

/**
 *
 * @author asus
 */
public class PedidoFrame extends javax.swing.JInternalFrame {

    //CONSTRUCTOR: Se ejecuta al arrancar o encender el programa
    public PedidoFrame() {
        initComponents();
        //Llamamos al método listar; para mostrar los datos de una tabla desde un inicio
        this.Listar();
        //Habilitamos y deshabilitamos los botones necesarios para evitar errores
        this.disableFormulario();
    }
    //====================================================================================================
    //CREAMOS UN MÉTODO PARA MOSTRAR LOS DATOS EN LA TABLA
    //Instanciamos clases y creamos objetos para usar más adelante(En le método Listar)
    private PedidoJpaController1 pjc = new PedidoJpaController1();
    private DefaultTableModel tabla;
    private List<Pedido> listaPedido;
    private Pedido pedido = new Pedido();
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
        Object[] obj = new Object[6];
        //
        try {
            //Recuperamos la lista de clientes que se tengan registrados en la base de datos
            //listaPedido = pjc.findPedidoEntities();
            listaPedido = pjc.findPedidoEntities();
            //Mostramos los datos de toda la lista de clientes encontrados
            for (int i = 0; i < listaPedido.size(); i++) {
                //Tomar los datos solo de un cliente de la lista de clientes
                pedido = (Pedido) listaPedido.get(i);
                //Asiganar en el arreglo deobjeto los 5 datos del cliente
                obj[0] = pedido.getIdPedido();
                obj[1] = pedido.getCliente().getIdCliente();
                //Establecemos el formato de la fecha con la que se mostrarán los datos
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //Convertimos a String las fechas de tipo date en el formato antes establecido
                String fechaEntrega = f.format(pedido.getFechaEntrega());
                String fechaPedido = f.format(pedido.getFechaInicio());
                obj[2] = Timestamp.valueOf(fechaPedido);
                obj[3] = Timestamp.valueOf(fechaEntrega);
                obj[4] = pedido.getImporteTotal();
                //Si es que el estado del Pedido está en "1" entonces que se muestre "Pendiente"; sino "Entregado"
                obj[5] = pedido.getBorrado().equals("1") ? "Pendiente" : "Entregado";

                //Agregar el pedido en una fila de la "tabla"
                tabla.addRow(obj);
            }
            //Agregar la "tabla" que contiene la lista de pedidos a la tabla visual de nombre "tbl_datos"
            this.tbl_tablaDatos.setModel(tabla);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de pedido: tbl_datos: \n" + e);
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
        this.txt_idPedido.setEnabled(false);
        this.txt_idPedido.setText("");
        this.txt_fechaEntrega.setCalendar(null);
        this.txt_importeTotal.setText("");
        this.txt_fechaPedido.setCalendar(null);
        this.txt_idCliente.setText("");
        this.chexbox_estado.setText("Pendiente");
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        txt_idPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_importeTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chexbox_estado = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txt_idCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tablaDatos = new javax.swing.JTable();
        txt_fechaEntrega = new com.toedter.calendar.JDateChooser();
        txt_fechaPedido = new com.toedter.calendar.JDateChooser();
        lbl_imagenFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Pedido");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_idPedido.setBackground(new java.awt.Color(204, 204, 204));
        txt_idPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_idPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 130, 25));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Fecha pedido: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de entrega: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Importe total: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        txt_importeTotal.setBackground(new java.awt.Color(204, 204, 204));
        txt_importeTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_importeTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_importeTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_importeTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, 25));

        jLabel9.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Estado: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 115, -1, -1));

        chexbox_estado.setText("Entregado");
        chexbox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chexbox_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(chexbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 100, 25));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Id Cliente: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 75, -1, -1));

        txt_idCliente.setBackground(new java.awt.Color(204, 204, 204));
        txt_idCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_idCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txt_idCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 25));

        jLabel10.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SISTEMA DE PEDIDOS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 337, 37));

        btn_nuevo.setBackground(new java.awt.Color(153, 255, 204));
        btn_nuevo.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btn_nuevo.setText("NUEVO");
        btn_nuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 120, 30));

        btn_editar.setBackground(new java.awt.Color(153, 255, 204));
        btn_editar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btn_editar.setText("EDITAR");
        btn_editar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 120, 30));

        btn_eliminar.setBackground(new java.awt.Color(153, 255, 204));
        btn_eliminar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 120, 30));

        btn_cancelar.setBackground(new java.awt.Color(153, 255, 204));
        btn_cancelar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 120, 30));

        btn_guardar.setBackground(new java.awt.Color(153, 255, 204));
        btn_guardar.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btn_guardar.setText("gUARDAR");
        btn_guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 120, 30));

        tbl_tablaDatos.setBackground(new java.awt.Color(204, 204, 204));
        tbl_tablaDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_tablaDatos.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        tbl_tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Pedido", "Id Cliente", "F. Pedido", "F. Entrega", "Total", "Estado"
            }
        ));
        tbl_tablaDatos.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_tablaDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 566, 160));

        txt_fechaEntrega.setBackground(new java.awt.Color(204, 204, 204));
        txt_fechaEntrega.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        jPanel1.add(txt_fechaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 160, 25));

        txt_fechaPedido.setBackground(new java.awt.Color(204, 204, 204));
        txt_fechaPedido.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        jPanel1.add(txt_fechaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, 25));

        lbl_imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/edu/unprg/images/fondo10.jpg"))); // NOI18N
        jPanel1.add(lbl_imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 640, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chexbox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chexbox_estadoActionPerformed
        // Programamos el chetbox cuando esté seleccionado o no:
        if (this.chexbox_estado.isSelected()) {
            //Escribir que está Entregado
            this.chexbox_estado.setText("Entregado");
        } else {
            //Escribir que está Pendiente
            this.chexbox_estado.setText("Pendiente");
        }
    }//GEN-LAST:event_chexbox_estadoActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // Activamos los botones guardar y cancelar; así mismo inabilitamos los botones: nuevo, editar y eliminar
        this.enableFormulario();
        //
        accion = "Agregar";
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        //PROGRAMAMOS EL COTÓN CANCELAR
        this.disableFormulario();//habilitamos y deshabilitamos los botones necesarios
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // Programamos el botón guardar para registrar a un cliente:

        //Recuperamos las fechas seleeccionadas:
        Date fechaE = this.txt_fechaEntrega.getDate();
        Date fechaP = this.txt_fechaPedido.getDate();
        //Establecemos el formato en que se desea obtener la fecha
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Convertimos a String las fechas de tipo date en el formato antes establecido
        String fechaEntrega = f.format(fechaE);
        String fechaPedido = f.format(fechaP);
        //Pasamos la fecha al formato TimesTamp para poder registrarlas en la base de datos:
        Timestamp fecha_Entrega = Timestamp.valueOf(fechaEntrega);
        Timestamp fecha_Pedido = Timestamp.valueOf(fechaPedido);
        if (this.validarCajasDeTexto()) {

            try {
                //Instanciamos la clase pedido
                Pedido pedido = new Pedido();
                //REgistramos los atributos del cliente que escribió en el formulario
                Cliente cliente = new Cliente();
                cliente.setIdCliente(Integer.parseInt(this.txt_idCliente.getText().toString()));
                pedido.setCliente(cliente);
                pedido.setFechaInicio(fecha_Pedido);
                pedido.setFechaEntrega(fecha_Entrega);
                pedido.setImporteTotal(Double.parseDouble(this.txt_importeTotal.getText()));
                pedido.setBorrado(this.chexbox_estado.isSelected() ? "1" : "0");
                //Declaramos una variable respuesta: 
                int respuesta = 0;
                //Creamos un Switch-case para poder controlar la acción que se realise
                switch (accion) {
                    case "Agregar":
                        //Hacemos uso del objeto creado de la clase "ClienteControlador" para agregar un cliente
                        pjc.create(pedido);
                        //CAmbiamos el estado de la variable respuesta: 
                        respuesta = 1;
                        break;
                    case "Editar":
                        //Enviamos el Id del PEDIDO: 
                        pedido.setIdPedido(Integer.parseInt(this.txt_idPedido.getText()));
                        //Hacemos uso del objeto creado de la clase "ClienteControlador" para EDITAR un cliente
                        pjc.edit(pedido);
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
            //Agregamos el ID en la caja de texto del formulario del pedido seleccionado
            this.txt_idPedido.setText(this.tbl_tablaDatos.getValueAt(row, 0).toString());
            //Instacmciar la clase Pedido(Entity)
            Pedido pedido = new Pedido();
            //
            pedido = pjc.findPedido(Integer.parseInt(this.txt_idPedido.getText()));//No sé que gace el método "finCliente"
            //Agregamos los datos del pedido a su respectiva caja de texto
                //Establecemos el formato en que se desea mostrar la fecha
                DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //Convertimos a String las fechas de tipo date en el formato antes establecido
                String fechaEntrega = f.format(pedido.getFechaEntrega());
                String fechaPedido = f.format(pedido.getFechaInicio());
            this.txt_fechaEntrega.setDate(Timestamp.valueOf(fechaEntrega));
            this.txt_fechaPedido.setDate(Timestamp.valueOf(fechaPedido));
            this.txt_importeTotal.setText(pedido.getImporteTotal().toString());
            //Instanciamos la clase Cliente
            Cliente cliente = new Cliente();
            this.txt_idCliente.setText(pedido.getCliente().getIdCliente().toString());
            //ME QUEDÉ AQUÍ
            this.chexbox_estado.setSelected(pedido.getBorrado().equals("1"));
            //Si es que el chexBox está seleccionado entonces mostrar "Entregado"
            if (this.chexbox_estado.isSelected()) {
                //Colocar mensaje de "Entregado"
                this.chexbox_estado.setText("Entregado");
            } else {
                //Mostrar mensaje "Pendiente"
                this.chexbox_estado.setText("Pendiente");
            }
            //Centramos el foco en la caja de importe total
            this.txt_importeTotal.requestFocus();
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
                //Recuperamos el Nombre del cliente que hizo el pedido seleccionado en la tabla: 
                int nombre = Integer.parseInt(this.tbl_tablaDatos.getValueAt(row, 1).toString());
                //Preguntamos si es que está seguro de eliminar al pedido: 
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar al pedido con ID: " + nombre + "?") == JOptionPane.YES_OPTION) {
                    //Eliminamos al cliente, usamos el objeto creado de la clase controlador
                    pjc.destroy(id);
                    //Mostrar mensaje informando que la operación se realizó correctamente: 
                    JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JCheckBox chexbox_estado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_imagenFondo;
    private javax.swing.JTable tbl_tablaDatos;
    private com.toedter.calendar.JDateChooser txt_fechaEntrega;
    private com.toedter.calendar.JDateChooser txt_fechaPedido;
    private javax.swing.JTextField txt_idCliente;
    private javax.swing.JTextField txt_idPedido;
    private javax.swing.JTextField txt_importeTotal;
    // End of variables declaration//GEN-END:variables
    //====================================================================================================
    //CREAMOS UN MÉTODO PARA VALIDAR LAS CAJAS DE TEXTO
    public boolean validarCajasDeTexto() {
        boolean retorno;
        try {
            /*Date fechaE = this.txt_fechaEntrega.getDate();
            Date fechaP = this.txt_fechaPedido.getDate();
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaEntrega = f.format(fechaE);
            String fechaPedido = f.format(fechaP);*/

            if (this.txt_idCliente.getText().trim().equals("") /*|| fechaEntrega.equals("")
                    || fechaPedido.trim().equals("")*/ || this.txt_importeTotal.getText().trim().equals("")) {
                retorno = false;
            } else {
                retorno = true;
            }
            return retorno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validar los datos: "+e);
            return false;
        }
    }
    //====================================================================================================
}
