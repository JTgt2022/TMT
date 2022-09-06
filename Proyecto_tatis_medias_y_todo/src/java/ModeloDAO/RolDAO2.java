/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;


import ModeloVO.USUROLVO;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author SENA
 */
public class RolDAO2 extends ConexionDB{

    public RolDAO2() {
    }
    
    //Declarar variables y/o objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
   

    private Boolean operacion = false;
    private String sql;
 public String seleccionarRol(String NombreUsuario, String PasswordUsuario){

String rolU = "";
        
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol as user inner join usuario as usu on usu.IdUsuario = user.IdRol where NombreUsuario = ? and PasswordUsuario= ?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NombreUsuario);
            puente.setString(2, PasswordUsuario);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {
                rolU = mensajero.getString("IdRol");
            }

        } catch (SQLException e) {
            Logger.getLogger(RolDAO2.class.getName()).log(Level.SEVERE, null, e);

        }
        return rolU;
    }

}
