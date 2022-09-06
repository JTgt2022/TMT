/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author jtgt2
 */
public class CategoriaVO {
    
     private String IdCategoria,NombreCategoria;

    public CategoriaVO(String IdCategoria, String NombreCategoria) {
        this.IdCategoria = IdCategoria;
        this.NombreCategoria = NombreCategoria;
    }

    public CategoriaVO() {
    }

    public String getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(String IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }
    
   


}
