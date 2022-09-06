/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jtgt2
 */
public class ConexionDB {
    
    
    //declarción de variables y objetos
    private String driver, userDB, paswordDB, dataBase,urlDB;
    private Connection conexion;
    
    public ConexionDB(){
        
        //Asignar valores 
    driver="com.mysql.jdbc.Driver";
    userDB="root";
    paswordDB="";
    dataBase="tatis_media_y_todo";
    urlDB="jdbc:mysql://localhost:3306/"+dataBase;
    
        try {
            Class.forName(driver).newInstance();
            conexion= DriverManager.getConnection(urlDB,userDB,paswordDB);
            System.out.println("Conexión ok!");
                    
            
        } catch (Exception e) {
           System.out.println("Error al conectarse " + e.toString()); 
            
        }
        
        
    }
    
    
    public  Connection obtenerConexion(){
    return conexion;
    }
    
    public Connection cerrarConexion() throws  SQLException{
    conexion.close();
    conexion=null;
    return conexion;
    
    }
    
    public static void main (String[] args){
    
    new ConexionDB();
    
    }
    
}
