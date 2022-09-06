/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
import Util.ConexionDB;
import Util.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  ModeloVO.PedidoVO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class PedidoDAO extends ConexionDB implements Crud{
 //Declarar variables y/o objetos 
  private Connection conexion;
  private PreparedStatement puente;
  private ResultSet mensajero;
  
  private boolean operacion= false;
  private String sql;
  
  private String IdPedido="",NumeroFacturaPedido="", FechaPedido="", FechaRecibido="", FechaVencimientoPago="",
          IdEmpresaProveedoraFK="",Subtotal="",IVA="",TotalPedido="",Descuento="",EstadoPedido="";
  
  public PedidoDAO(PedidoVO PVO){
      super();
      //3. Conectarse 
      try {
       conexion = this.obtenerConexion();
          
        //Traer al DAO los datos del VO para hecer la operación.
        IdPedido =PVO.getIdpedido();
        NumeroFacturaPedido=PVO.getNumeroFacturaPedido();
        FechaPedido=PVO.getFechaPedido();
        FechaRecibido=PVO.getFechaRecibido();
        FechaVencimientoPago=PVO.getFechaVencimientoPago();
        IdEmpresaProveedoraFK=PVO.getIdEmpresaProveedoraFK();
        IVA=PVO.getIVA();
        Descuento=PVO.getDescuento();
        EstadoPedido=PVO.getEstadoPedido();
        
      } catch (Exception e) {
           Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
      }
  }
    @Override
    public boolean agregarRegistro() {
         try {
            sql="insert into pedido(NumeroFacturaPedido,FechaPedido,FechaRecibido,FechaVencimientoPago,IdEmpresaProveedoraFK,IVA,Descuento,EstadoPedido) values(?,?,?,?,?,?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NumeroFacturaPedido );
            puente.setString(2, FechaPedido);
            puente.setString(3, FechaRecibido );
            puente.setString(4, FechaVencimientoPago );
            puente.setString(5, IdEmpresaProveedoraFK );
            puente.setString(6, IVA );
            puente.setString(7, Descuento );
            puente.setString(8, EstadoPedido );
                   
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
         return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
            try {
            sql="update pedido set NumeroFacturaPedido=?,FechaPedido=?,FechaRecibido=?,FechaVencimientoPago=?,IdEmpresaProveedoraFK=?,IVA=?,Descuento=?,EstadoPedido=? where Idpedido=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1, NumeroFacturaPedido );
            puente.setString(2, FechaPedido);
            puente.setString(3, FechaRecibido );
            puente.setString(4, FechaVencimientoPago );
            puente.setString(5, IdEmpresaProveedoraFK );
            puente.setString(6, IVA );
            puente.setString(7, Descuento );
            puente.setString(8, EstadoPedido );
            puente.setString(9, IdPedido);
                   
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
         return operacion;
    }


    @Override
    public boolean eliminarRegistro() {
                try {
            sql="delete from pedido where NumeroFacturaPedido=?";
            puente = conexion.prepareCall(sql);
            
            puente.setString(1, NumeroFacturaPedido );
            
                   
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
         return operacion;
    }
     public PedidoVO consultarPedido(String IdPedido ){
       PedidoVO PVO = null;
         try {
            sql="select * from pedido where IdPedido= ?";
            conexion =this. obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1,IdPedido);
            
            mensajero= puente. executeQuery();
            while (mensajero.next()) {
                  PVO = new PedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),
                    mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));
               
                
                
            }
             
             
      } catch (SQLException e) {
           Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return PVO;
         }
      public PedidoDAO() {
    }
     
     
     public ArrayList<PedidoVO> listar() {
        ArrayList<PedidoVO> listaPedido = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select*from pedido";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                  PedidoVO PVO = new PedidoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),
                    mensajero.getString(7), mensajero.getString(8), mensajero.getString(9));

                listaPedido.add(PVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return listaPedido;
    }
}
    
    
    

