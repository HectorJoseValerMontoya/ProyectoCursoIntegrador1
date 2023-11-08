/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HJVM
 */
public class MySql {

    public static Connection Conexion() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/valorizacion";
        String user = "root";
        String pass = "admin";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {

        }

        return con;

    }
}
