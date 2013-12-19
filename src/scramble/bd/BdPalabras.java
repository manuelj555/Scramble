/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scramble.bd;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Aguirre <programador.manuel@gmail.com>
 */
public class BdPalabras {

    protected static Connection con;
    protected static Statement st;
    private static final Logger log = Logger.getLogger(BdPalabras.class.getName());

    protected static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BdPalabras.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection("jdbc:sqlite:bd.db");
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BdPalabras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean exists(String palabra) {
        boolean exists = false;

        try {
            conectar();
            
            palabra = palabra.toLowerCase();
            
            ResultSet rs = st.executeQuery("SELECT count(*) as num FROM palabras"
                    + " WHERE palabra = '" + palabra + "'"
                    + " OR sin_acentos = '" + palabra + "'");

            if (rs.next() && rs.getInt("num") > 0) {
                exists = true;
            }

            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BdPalabras.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }
}
