/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import dao.daoEmpleado;
import javax.swing.table.DefaultTableModel;
import modelos.Personal;
/**
 *
 * @author hecto
 */
public class BuscarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form BuscarEmpleado
     */
    DefaultTableModel model;

    public BuscarEmpleado() {
        initComponents();
        this.setLocationRelativeTo(null);//Se centra
        model = (DefaultTableModel) tableEmpleados.getModel();
        btnEmitirFactura.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        btnEmitirFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar por código: ");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre & Apellido", "Área"
            }
        ));
        tableEmpleados.setToolTipText("");
        tableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmpleados);

        btnEmitirFactura.setText("Emitir Factura");
        btnEmitirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEmitirFactura)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmitirFactura)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    daoEmpleado daoE = new daoEmpleado();
    
    private boolean estaEnTabla() {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (txtCodigo.getText().equals(model.getValueAt(i, 0).toString())) {
                return true;
            }
        }

        return false;
    }

    private void verificarBoton() {
//        if (model.getRowCount() != 1){
//            btnEmitirFactura.setEnabled(false);
//        }else 
        if (estaEnTabla()) {
            btnEmitirFactura.setEnabled(true);
        } else {
            btnEmitirFactura.setEnabled(false);
        }
    }

    private void buscar() {
        model.setRowCount(0);
        if (!txtCodigo.getText().equals("")) {
            for(Personal p : daoE.listarEmpleados()){
                if (p.getCodFichaEmpleado().contains(txtCodigo.getText())){
                    String[] arreglo = new String[3];
                    arreglo[0] = p.getCodFichaEmpleado();
                    arreglo[1] = p.getNombreEmpleado() + " & " + p.getApellidoEmpleado();
                    arreglo[2] = p.getAreaEmpleado();
                    
                    model.addRow(arreglo);
                }
            }
        }
        tableEmpleados.setModel(model);
    }

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        buscar();
        verificarBoton();
    }//GEN-LAST:event_txtCodigoKeyReleased

    public Personal recogerDatos() {
        Personal personal = null;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (txtCodigo.getText().equals(model.getValueAt(i, 0).toString())) {
                personal = daoE.buscarEmpleado(txtCodigo.getText());

                return personal;
            }
        }

        return personal;
    }

    private void btnEmitirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirFacturaActionPerformed

        //EmitirFactura fact = new EmitirFactura(model.getValueAt(0, 0).toString(), model.getValueAt(0, 1).toString(), model.getValueAt(0, 2).toString());
        txtCodigo.requestFocus();
        EmitirFactura fact = new EmitirFactura(recogerDatos());
                //JOptionPane.showMessageDialog(this, "hola");

        fact.setVisible(true);


    }//GEN-LAST:event_btnEmitirFacturaActionPerformed

    private void tableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpleadosMouseClicked
        txtCodigo.requestFocus();
        String cod = model.getValueAt(tableEmpleados.getSelectedRow(), 0).toString();
        txtCodigo.setText(cod);
        buscar();
        verificarBoton();
    }//GEN-LAST:event_tableEmpleadosMouseClicked

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        int code = (int) evt.getKeyChar();
        if (!(code >= 48 && code <= 57) || txtCodigo.getText().length() >= 18)
            evt.consume();
    }//GEN-LAST:event_txtCodigoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmitirFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEmpleados;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
