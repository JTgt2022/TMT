/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ClienteVO;
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
 * @author jtgt2
 */
public class ClienteDAO extends ConexionDB implements Crud{
    
    //Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String IdCliente="",NombreCliente="",ApellidoCliente="",TipoDocCliente="",NumeroDocCliente="",TelefonoCliente="",DirecionCliente="",CorreoCliente="",EstadoCliente="";

    public ClienteDAO() {
    }
    
    public ClienteDAO(ClienteVO ClVO){
      super();
      
        try {
            conexion = this.obtenerConexion();

            //Traer al DAO los datos del VO para hecer la operación.
            IdCliente=ClVO.getIdCliente();
            NombreCliente=ClVO.getNombreCliente();
            ApellidoCliente=ClVO.getApellidoCliente();
            TipoDocCliente=ClVO.getTipoDocCliente();
            NumeroDocCliente=ClVO.getNumeroDocCliente();
            TelefonoCliente=ClVO.getTelefonoCliente();
            DirecionCliente=ClVO.getDirecionCliente();
            CorreoCliente=ClVO.getCorreoCliente();
            EstadoCliente=ClVO.getEstadoCliente();
            
        } catch (Exception e) {
        
             Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public boolean agregarRegistro() {
        try {
              sql = "INSERT INTO cliente(NombreCliente,ApellidoCliente,TipoDocCliente,NumeroDocCliente,TelefonoCliente,DirecionCliente,CorreoCliente,EstadoCliente) VALUES (?,?,?,?,?,?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NombreCliente);
            puente.setString(2, ApellidoCliente);
            puente.setString(3, TipoDocCliente);
            puente.setString(4, NumeroDocCliente);
            puente.setString(5, TelefonoCliente);
            puente.setString(6, DirecionCliente);
            puente.setString(7, CorreoCliente);
            puente.setString(8, EstadoCliente);
              puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }
    @Override
    public boolean actualizarRegistro() {
        try {
             sql = "UPDATE cliente SET NombreCliente=?,ApellidoCliente=?,TelefonoCliente=?,DirecionCliente=?,CorreoCliente=?,EstadoCliente=? WHERE IdCliente=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NombreCliente);
            puente.setString(2, ApellidoCliente);
            puente.setString(3, TelefonoCliente);
            puente.setString(4, DirecionCliente);
            puente.setString(5, CorreoCliente);
            puente.setString(6, EstadoCliente);
            puente.setString(7, IdCliente);
            
           puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;

    }
    @Override
    public boolean eliminarRegistro() {
       try {
            sql = "delete from Cliente where NumeroDocCliente=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NumeroDocCliente);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }
    
       public ClienteVO consultarDocumento(String NumeroDocCliente) {

        ClienteVO ClVO = null;
        try {
            sql = "select * from Cliente WHERE NumeroDocCliente= ?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NumeroDocCliente);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                ClVO = new ClienteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8),mensajero.getString(9));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return ClVO;
    }

    public ArrayList<ClienteVO> listar() {

        ArrayList<ClienteVO> listaCliente = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT e.IdEmpleado,e.NombreEmpleado,e.ApellidoEmpleado, e.TipoDocEmpleado, e.NumeroDocEmpleado,e.TelefonoCelularEmpleado,e.DirecionEmpleado,e.CorreoEmpleado,e.EstadoEmpleado,u.NombreUsuario from empleado e INNER JOIN usuario u on e.IdUsuarioFK=u.IdUsuario";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                ClienteVO ClVO = new ClienteVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8),mensajero.getString(9));

                listaCliente.add(ClVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return listaCliente;
    }
    
    
    
    
}
