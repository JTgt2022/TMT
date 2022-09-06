/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.ConexionDB;
import Util.Crud;
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
public class UsuarioDAO extends ConexionDB implements Crud {

    //Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String IdUsuario = "", NombreUsuario = "", PasswordUsuario = "",  EstadoUsuario = "";

    //2.metodo contructor para recibir  datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        //3. Conectarse 
        try {
            conexion = this.obtenerConexion();

            //Traer al DAO los datos del VO para hecer la operación.
            IdUsuario = usuVO.getIdUsuario();
            NombreUsuario = usuVO.getNombreUsuario();
            PasswordUsuario = usuVO.getPasswordUsuario();
            EstadoUsuario = usuVO.getEstadoUsuario();
            

        } catch (Exception e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into usuario(NombreUsuario,PasswordUsuario,EstadoUsuario) values (?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NombreUsuario);
            puente.setString(2, PasswordUsuario);
            puente.setString(3, EstadoUsuario);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }
    

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE usuario SET NombreUsuario =?,PasswordUsuario=?,EstadoUsuario=? WHERE IdUsuario= ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NombreUsuario);
             puente.setString(2, PasswordUsuario);  
            puente.setString(3, EstadoUsuario);
            puente.setString(4, IdUsuario);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() {

        try {
            sql = "delete from Usuario where IdUsuario=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, IdUsuario);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }

    public UsuarioVO consultarNombre(String NombreUsuario) {

        UsuarioVO usuVO = null;
        try {
            sql = "select * from usuario WHERE NombreUsuario = ?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NombreUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return usuVO;
    }

    public ArrayList<UsuarioVO> listar() {

        ArrayList<UsuarioVO> listaUsuario = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                UsuarioVO usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));

                listaUsuario.add(usuVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return listaUsuario;
    }

    public boolean iniciarSesion(String usuario, String clave) {

        try {
            conexion = this.obtenerConexion();
            sql = "select * from  usuario where NombreUsuario=? and PasswordUsuario=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                operacion = true;
            }

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {

            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public UsuarioVO consultarUsuario(String NombreUsuario, String PasswordUsuario) {
        UsuarioVO usuVO = null;
        try {
            sql = "select * from usuario where NombreUsuario = ? and PasswordUsuario = ? ";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NombreUsuario);
            puente.setString(2, PasswordUsuario);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {

                usuVO = new UsuarioVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4));

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return usuVO;

    }

    public UsuarioDAO() {
    }
    
    /**public void cambiarVigencia(UsuarioVO UsuVO) throws Exception{
        try{
      
        sql = "update Usuario set EstadoUsuario = "
                + (UsuVO.getEstadoUsuario()== true ? "1" : "0")
                + "where IdUsuario =" + UsuVO.getIdUsuario();
     puente = conexion.prepareStatement(sql);
     mensajero = puente.executeQuery();
                    }
 catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return UsuVO;*/

    }

