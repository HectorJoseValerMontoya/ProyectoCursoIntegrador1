/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.DetalleFactura;

/**
 *
 * @author HJVM
 */
public class daoDetalleFactura {

    public int siguienteDetalleFactura() {
        String sql = "select max(codDetalleFactura) + 1 from detalleFactura;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return 1;
    }

    public void insertarDetalleFactura(List<DetalleFactura> dfs) {
        String sql;
        Connection con;
        PreparedStatement ps;

        sql = "insert into detalleFactura values (null, ?,?,?,?);";
        for (DetalleFactura df : dfs) {
            try {
                con = conf.MySql.Conexion();
                ps = con.prepareStatement(sql);
                ps.setInt(1, df.getCodFactura());
                ps.setInt(2, df.getCodActividad());
                ps.setLong(3, df.getCantidadDeActividad());
                ps.setDouble(4, df.getCostoSubtotal());

                ps.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("Error:" + e);
            }
        }
    }
    
    public List<DetalleFactura> listarDetalleFacturaDeFactura(int codFactura){
        List<DetalleFactura> dfs = new ArrayList<>();

        String sql = "select  * from detalleFactura where codFactura = ?;";

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codFactura);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleFactura df = new DetalleFactura();
                df.setCodDetalleFactura(rs.getInt(1));
                df.setCodFactura(rs.getInt(2));
                df.setCodActividad(rs.getInt(3));
                df.setCantidadDeActividad(rs.getInt(4));
                df.setCostoSubtotal(rs.getDouble(5));

                dfs.add(df);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return dfs;
    }
}
