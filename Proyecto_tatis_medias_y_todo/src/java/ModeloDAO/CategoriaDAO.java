/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;
/**
 *
 * @author jtgt2
 */
import ModeloVO.CategoriaVO;
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
public class CategoriaDAO extends ConexionDB implements Crud{

    
    //Declarar variables y/o objetos 
  private Connection conexion;
  private PreparedStatement puente;
  private ResultSet mensajero;
  
 private boolean operacion;
  
  
  private String sql;  
  
    
     public  ArrayList<CategoriaVO>Listar(){
       ArrayList<CategoriaVO>listaCategoria = new ArrayList<>();
     
        try {
            
            conexion =this. obtenerConexion();
            sql="select * from categoria;";
            puente = conexion.prepareStatement(sql);
            mensajero= puente. executeQuery();
            while (mensajero.next()) {
                
                CategoriaVO catVO= new CategoriaVO(mensajero.getString(1), mensajero.getString(2));
                 listaCategoria.add(catVO);
            }
             
             
      } catch (SQLException e) {
           Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (SQLException e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return listaCategoria;
    
       
     }

    private String IdCategoria="",NombreCategoria="";
  
  //2.metodo contructor para recibir  datos del VO
  
  public CategoriaDAO(){
  }

    public CategoriaDAO(CategoriaVO catVO) {
        super();
        
        //3. Conectarse
        
        try {
            conexion = this.obtenerConexion();
            
            //Traer al DAO los datos del VO para hecer la operación.
       
            IdCategoria =catVO.getIdCategoria();
            NombreCategoria=catVO.getNombreCategoria();
          

            
            
        } catch (Exception e) {
            
            Logger.getLogger(EmpresaProveedoraDAO.class.getName()).log(Level.SEVERE,null, e);
        }
    }

   

    @Override
    public boolean agregarRegistro() {
        try {
            sql="insert into Categoria (NombreCategoria) values(?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1,NombreCategoria );
            
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql="update categoria SET IdCategoria=?,NombreCategoria=? WHERE IdCategoria=?";
            puente = conexion.prepareCall(sql);
            
            puente.setString(1,NombreCategoria);
            puente.setString(2,IdCategoria );
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
        
         }

    @Override
    public boolean eliminarRegistro() {
        
        try {
            sql="DELETE FROM categoria WHERE IdCategoria=?;";
            puente = conexion.prepareCall(sql);
            puente.setString(1,IdCategoria );
           
            
            puente.executeUpdate();
            operacion= true;
            
            
        } catch (SQLException e) {
             Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
        
    }
    
public boolean consultarcategoria(){
{
        
        try {
            conexion =this. obtenerConexion();
            sql="select * from EmpresaProveedora where IdEmpresaProveedora=?";
            puente = conexion.prepareCall(sql);
            puente.setString(1,NombreCategoria);
            puente.setString(2,IdCategoria);
      
            mensajero= puente. executeQuery();
            if (mensajero.next()) {
                
                operacion=true;
                    
                }
            
        } catch (Exception e) {
        }finally{
            
            try {
                this.cerrarConexion();
                
            } catch (Exception e) {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE,null, e);
       
            }
        
        } 
        
        return operacion;
    


}
        
}
    
}

    
    
  