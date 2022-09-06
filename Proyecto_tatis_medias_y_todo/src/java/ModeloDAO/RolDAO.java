/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.RolVO;
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
 * @author User
 */
public class RolDAO extends ConexionDB{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    
    
    public ArrayList<RolVO> listar() {
        ArrayList<RolVO> listaRol = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
               RolVO rolVO=new RolVO(mensajero.getString(1),mensajero.getString(2));
               listaRol.add(rolVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaRol;
    }

    
}
