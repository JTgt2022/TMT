
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.ProductoVO;
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
 * @author Jessika Tatiana
 */
public class ProductoDAO extends ConexionDB implements Crud{
      
  private Connection conexion;
  private PreparedStatement puente;
  private ResultSet mensajero;
  
  private boolean operacion= false;
  private String sql;
  
  
  private String IdProducto="",CodigoDeBarrasProducto="",ReferenciaProducto="",DescripcionProducto="",StockProducto="",PrecioUnitario="",EstadoProducto="",IdCategoriaFK="",IdEmpresaProveedoraFK="";
  
  //2.metodo contructor para recibir  datos del VO
  
  public ProductoDAO(){
  }

    public ProductoDAO(ProductoVO proVO) {
        super();
        
        //3. Conectarse
        
        try {
            conexion = this.obtenerConexion();
            
            //Traer al DAO los datos del VO para hecer la operación.
       
            IdProducto =proVO.getIdProducto();
            CodigoDeBarrasProducto=proVO.getCodigoDeBarrasProducto();
            ReferenciaProducto=proVO.getReferenciaProducto();
            DescripcionProducto=proVO.getDescripcionProducto();
            StockProducto=proVO.getStockProducto();
            PrecioUnitario =proVO.getPrecioUnitario();
            EstadoProducto=proVO.getEstadoProducto();
            IdCategoriaFK=proVO.getIdCategoriaFK();
            IdEmpresaProveedoraFK=proVO.getIdEmpresaProveedoraFK();


            
            
        } catch (Exception e) {
            
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }
    }

   

    @Override
    public boolean agregarRegistro() {
        try {
            sql="insert into Producto (CodigoDeBarrasProducto,ReferenciaProducto,DescripcionProducto,StockProducto,PrecioUnitario,"
                    + "EstadoProducto,IdCategoriaFK,IdEmpresaProveedoraFK) values(?,?,?,?,?,?,?,?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1,CodigoDeBarrasProducto);
            puente.setString(2,ReferenciaProducto );
            puente.setString(3,DescripcionProducto);
            puente.setString(4,StockProducto);
            puente.setString(5,PrecioUnitario );
            puente.setString(6,EstadoProducto);
            puente.setString(7,IdCategoriaFK);
            puente.setString(8,IdEmpresaProveedoraFK);
            
            
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql="update producto SET CodigoDeBarrasProducto=?,ReferenciaProducto=?,"+ "DescripcionProducto=?,StockProducto=?,"
                    + "PrecioUnitario=?,EstadoProducto=? WHERE IdProducto=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1,CodigoDeBarrasProducto);
            puente.setString(2,ReferenciaProducto );
            puente.setString(3,DescripcionProducto);
            puente.setString(4,StockProducto);
            puente.setString(5,PrecioUnitario );
            puente.setString(6,EstadoProducto);
            puente.setString(7,IdProducto );
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
        
         }

    @Override
    public boolean eliminarRegistro() {
        
        try {
            sql="DELETE FROM producto WHERE IdProducto=?;";
            puente = conexion.prepareCall(sql);
            puente.setString(1,IdProducto );
           
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
        }
    
    
     public boolean consultarProducto(String CodigoDeBarrasProducto,String ReferenciaProducto ,String DescripcionProducto ,String StockProducto,String PrecioUnitario,String EstadoProducto,String IdCategoriaFK,String IdEmpresaProveedoraFK)
{
        
        try {
            conexion =this. obtenerConexion();
            sql="select * from Producto where IdProducto=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1,CodigoDeBarrasProducto);
            puente.setString(2,ReferenciaProducto );
            puente.setString(3,DescripcionProducto);
            puente.setString(4,StockProducto);
            puente.setString(5,PrecioUnitario );
            puente.setString(6,EstadoProducto);
            puente.setString(7,IdCategoriaFK);
            puente.setString(8,IdEmpresaProveedoraFK);
            mensajero= puente. executeQuery();
            if (mensajero.next()) {
                
                operacion=true;
                    
                }
            
        } catch (Exception e) {
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
    


}
 
     
     
     public ProductoVO consultarCodigodeBarras(String CodigoDeBarrasProducto){
       ProductoVO proVO = null;
         try {
            sql="SELECT *FROM producto where CodigoDeBarrasProducto=?;";
            conexion =this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1,CodigoDeBarrasProducto);
            mensajero= puente.executeQuery();
            if(mensajero.next()) {
                
                proVO= new ProductoVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5), mensajero.getString(6), mensajero.getString(7),mensajero.getString(8),mensajero.getString(9));
                
            }
             
             
      } catch (SQLException e) {
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return proVO;
    
     
     }
     
     public  ArrayList<ProductoVO>Listar(){
       ArrayList<ProductoVO>listaProductos = new ArrayList<>();
     
        try {
            
            conexion =this. obtenerConexion();
            sql="select *from Producto;";
            puente = conexion.prepareStatement(sql);
          
            mensajero= puente. executeQuery();
            while (mensajero.next()) {
                
                ProductoVO proVO= new ProductoVO(IdProducto, CodigoDeBarrasProducto, ReferenciaProducto, DescripcionProducto, StockProducto, PrecioUnitario, EstadoProducto, IdCategoriaFK, IdEmpresaProveedoraFK);
            listaProductos.add(proVO);
            }
             
             
      } catch (SQLException e) {
           Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return listaProductos;
    
       
     } 
     
     
     
    
}


    
    
    

