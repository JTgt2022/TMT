/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.EmpleadoVO;
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
 * @author User
 */
public class EmpleadoDAO extends ConexionDB implements Crud {

    //Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    private String IdEmpleado="",NombreEmpleado="",ApellidoEmpleado="",TipoDocEmpleado="",NumeroDocEmpleado="",TelefonoCelularEmpleado="",DirecionEmpleado="",CorreoEmpleado="",EstadoEmpleado="",IdUsuarioFK="";
    
      public EmpleadoDAO(EmpleadoVO empVO) {
        super();

        //3. Conectarse 
        try {
            conexion = this.obtenerConexion();

            //Traer al DAO los datos del VO para hecer la operación.
            IdEmpleado = empVO.getIdEmpleado();
        NombreEmpleado = empVO.getNombreEmpleado();
        ApellidoEmpleado = empVO.getApellidoEmpleado();
        TipoDocEmpleado = empVO.getTipoDocEmpleado();
        NumeroDocEmpleado = empVO.getNumeroDocEmpleado();
        TelefonoCelularEmpleado = empVO.getTelefonoCelularEmpleado();
        DirecionEmpleado = empVO.getDirecionEmpleado();
        CorreoEmpleado = empVO.getCorreoEmpleado();
        EstadoEmpleado = empVO.getEstadoEmpleado();
        IdUsuarioFK = empVO.getIdUsuarioFK(); 

        } catch (Exception e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }
      
      
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "INSERT INTO empleado( NombreEmpleado,ApellidoEmpleado,TipoDocEmpleado,NumeroDocEmpleado,TelefonoCelularEmpleado,DirecionEmpleado,CorreoEmpleado,EstadoEmpleado,IdUsuarioFK) VALUES (?,?,?,?,?,?,?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1,NombreEmpleado);
            puente.setString(2,ApellidoEmpleado);
            puente.setString(3,TipoDocEmpleado);
            puente.setString(4,NumeroDocEmpleado);
            puente.setString(5,TelefonoCelularEmpleado);
            puente.setString(6,DirecionEmpleado);
            puente.setString(7,CorreoEmpleado);
            puente.setString(8,EstadoEmpleado);
            puente.setString(9,IdUsuarioFK);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
       try {
            sql = "UPDATE empleado SET NombreEmpleado=?,ApellidoEmpleado=?,TelefonoCelularEmpleado=?,DirecionEmpleado=?,CorreoEmpleado=?,EstadoEmpleado=? WHERE IdEmpleado=?";            
            puente = conexion.prepareCall(sql);
            puente.setString(1, NombreEmpleado);
            puente.setString(2, ApellidoEmpleado);
            puente.setString(3, TelefonoCelularEmpleado);
            puente.setString(4, DirecionEmpleado);
            puente.setString(5, CorreoEmpleado);
            puente.setString(6, EstadoEmpleado);
            puente.setString(7, IdEmpleado);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;

    }

    @Override
    public boolean eliminarRegistro() {
       try {
            sql = "delete from Empleado where NumeroDocEmpleado=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NumeroDocEmpleado);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }

        return operacion;
    }

    public EmpleadoVO consultarDocumento(String NumeroDocEmpleado) {

        EmpleadoVO empVO = null;
        try {
            sql = "select * from empleado WHERE NumeroDocEmpleado=?";
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, NumeroDocEmpleado);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                empVO = new EmpleadoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9),mensajero.getString(10));
            }

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return empVO;
    }

    
    
       public ArrayList<EmpleadoVO> listar() {

        ArrayList<EmpleadoVO> listaEmpleado = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from Empleado";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                EmpleadoVO empVO = new EmpleadoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5),mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), mensajero.getString(10));

                listaEmpleado.add(empVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return listaEmpleado;
    }

  

    public EmpleadoDAO() {
    }
    
}
