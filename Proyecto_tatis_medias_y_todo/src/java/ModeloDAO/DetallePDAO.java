/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DetallePedidoVO;
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
 * @author Alexis
 */
    public class DetallePDAO extends ConexionDB implements Crud{

 //Declarar variables y/o objetos 
  private Connection conexion;
  private PreparedStatement puente;
  private ResultSet mensajero;
  
  private boolean operacion= false;
  private String sql;
  
  private String IdPedidoFK="",IdProductoFK="",PrecioUnitario="", Cantidad="";

     public DetallePDAO(DetallePedidoVO DPVO){
      super();
      //3. Conectarse 
      try {
       conexion = this.obtenerConexion();
          
        //Traer al DAO los datos del VO para hecer la operación.
        IdPedidoFK =DPVO.getIdPedidoFK();
        IdProductoFK=DPVO.getIdProductoFK();
        PrecioUnitario=DPVO.getPrecioUnitario();
        Cantidad=DPVO.getCantidad();
        
        
      } catch (Exception e) {
           Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
      }
  }
    @Override
    public boolean agregarRegistro() {
         try {
            sql="insert into detalle_pedido(IdpedidoFK,IdProductoFK,PrecioUnitario,Cantidad) values(?,?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, IdPedidoFK);
            puente.setString(2, IdProductoFK );
            puente.setString(3, PrecioUnitario);
            puente.setString(4, Cantidad);
                         
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
         return operacion;
    }

    @Override
 public boolean actualizarRegistro() {
            try {
            sql="update detalle_pedido set IdProductoFK=?,PrecioUnitario=?,Cantidad=? where IdpedidoFK='?'";
            puente = conexion.prepareCall(sql);
            
            puente.setString(1, IdProductoFK );
            puente.setString(2, PrecioUnitario);
            puente.setString(3, Cantidad);
            puente.setString(4, IdPedidoFK);
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
         return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        
    try {
            sql = "delete from detalle_pedido where IdPedidoFK=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, IdPedidoFK);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {
            Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {
                this.cerrarConexion();

            } catch (SQLException e) {
                Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE, null, e);

            }

        }
        return operacion;
    }
    public DetallePedidoVO consultarDetallePedido(String IdPedidoFK ) {
       DetallePedidoVO DPVO = null;
         try {
            sql="select * from detalle_pedido where IdPedidoFK= ?";
            conexion =this. obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1,IdPedidoFK);
            
            mensajero= puente. executeQuery();
            while (mensajero.next()) {
                  DPVO = new DetallePedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),mensajero.getString(4));
               
                
                
            }
               } catch (SQLException e) {
           Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return DPVO;
         }
    public DetallePDAO() {
    }
     
 public ArrayList<DetallePedidoVO> listar() {
        ArrayList<DetallePedidoVO> Listadetallepedido = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select*from detalle_Pedido";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                  DetallePedidoVO DPVO = new DetallePedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),mensajero.getString(4));

                Listadetallepedido.add(DPVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(DetallePDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return Listadetallepedido;
}
}
    
    

