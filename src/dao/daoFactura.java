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
import modelos.Factura;

/**
 *
 * @author HJVM
 */
public class daoFactura {

    public int siguienteFactura() {
        String sql = "select max(codFactura) + 1 from factura;";
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt(1);
                return num == 0 ? 1 : num;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return 1;
    }

    public void insertarFactura(Factura f) {
        String sql = "insert into factura values (null, ?,?,?,?);";
        Connection con;
        PreparedStatement ps;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, f.getCodEmpleado());
            ps.setDouble(2, f.getCostoTotal());
            ps.setString(3, f.getFechaFactura());
            ps.setString(4, f.getHoraFactura());

            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }
    }

    public List<Factura> listarFacturas() {
        List<Factura> facts = new ArrayList<>();

        String sql = "select  * from factura;";

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setCodFactura(rs.getInt(1));
                f.setCodEmpleado(rs.getInt(2));
                f.setCostoTotal(rs.getDouble(3));
                f.setFechaFactura(rs.getString(4));
                f.setHoraFactura(rs.getString(5));

                facts.add(f);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return facts;
    }

    public List<Factura> listarFacturasDe(int codEmpleado) {
        List<Factura> facts = new ArrayList<>();

        String sql = "select  * from factura where codEmpleado = ?;";

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codEmpleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura f = new Factura();
                f.setCodFactura(rs.getInt(1));
                f.setCodEmpleado(rs.getInt(2));
                f.setCostoTotal(rs.getDouble(3));
                f.setFechaFactura(rs.getString(4));
                f.setHoraFactura(rs.getString(5));

                facts.add(f);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return facts;
    }

    public Factura buscarFactura(int codFactura) {
        String sql = "select  * from factura where codFactura = ?;";
        Factura f = null;
        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        try {
            con = conf.MySql.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codFactura);
            rs = ps.executeQuery();
            while (rs.next()) {
                f = new Factura();
                f.setCodFactura(rs.getInt(1));
                f.setCodEmpleado(rs.getInt(2));
                f.setCostoTotal(rs.getDouble(3));
                f.setFechaFactura(rs.getString(4));
                f.setHoraFactura(rs.getString(5));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error:" + e);
        }

        return f;
    }

}
