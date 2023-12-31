/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import dao.daoEmpleado;
import dao.daoFactura;
import javax.swing.table.DefaultTableModel;
import modelos.Factura;
import modelos.Personal;

/**
 *
 * @author hecto
 */
public class RegistroFacturas extends javax.swing.JFrame {

    /**
     * Creates new form RegistroFacturas
     */
    //String codigoResponsable, fecha;
    boolean facturaSeleccionada = false;

    DefaultTableModel modeloEmpleados;
    DefaultTableModel modeloFacturas;

    daoEmpleado daoE = new daoEmpleado();
    daoFactura daoF = new daoFactura();

    public RegistroFacturas() {
        initComponents();
        this.setLocationRelativeTo(null);//Se centra
        modeloEmpleados = (DefaultTableModel) tablaEmpleados.getModel();
        modeloFacturas = (DefaultTableModel) tablaFacturas.getModel();

        for (Personal p : daoE.listarEmpleados()) {
            String[] arreglo = new String[2];
            arreglo[0] = p.getNombreEmpleado() + " - " + p.getApellidoEmpleado();
            arreglo[1] = p.getCodFichaEmpleado();
            modeloEmpleados.addRow(arreglo);
        }
        tablaEmpleados.setModel(modeloEmpleados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        btnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Factura", "Empleado", "Codigo", "Fecha"
            }
        ));
        tablaFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaFacturas);

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Responsable", "Código"
            }
        ));
        tablaEmpleados.setShowGrid(true);
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEmpleados);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtrar(String codFichaResponsable) {
        modeloFacturas.setRowCount(0);

        int codResponsable = daoE.buscarEmpleado(codFichaResponsable).getCodEmpeado();
        
        for (Factura f : daoF.listarFacturasDe(codResponsable)) {
            Personal p = daoE.buscarEmpleado(codResponsable);
            String[] a = new String[4];
            
            a[0] = String.valueOf(f.getCodFactura());
            a[1] = p.getNombreEmpleado() + " - " + p.getApellidoEmpleado();
            a[2] = p.getCodFichaEmpleado();
            a[3] = f.getFechaFactura() + " - " + f.getHoraFactura();

            modeloFacturas.addRow(a);
        }

        tablaFacturas.setModel(modeloFacturas);
    }

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        filtrar(modeloEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (facturaSeleccionada) {
            FacturaTerminada factTerm = new FacturaTerminada(Integer.parseInt(modeloFacturas.getValueAt(tablaFacturas.getSelectedRow(), 0).toString()));
            factTerm.setVisible(true);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void tablaFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturasMouseClicked
        facturaSeleccionada = true;
    }//GEN-LAST:event_tablaFacturasMouseClicked

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
            java.util.logging.Logger.getLogger(RegistroFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaFacturas;
    // End of variables declaration//GEN-END:variables
}
