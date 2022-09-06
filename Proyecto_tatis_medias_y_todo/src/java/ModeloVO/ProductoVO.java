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
public class ProductoVO {
    
    private String IdProducto,CodigoDeBarrasProducto,ReferenciaProducto ,DescripcionProducto ,StockProducto,PrecioUnitario,EstadoProducto,IdCategoriaFK,IdEmpresaProveedoraFK;

    public ProductoVO() {
    }
    
     public ProductoVO(String IdProducto, String CodigoDeBarrasProducto, String ReferenciaProducto, String DescripcionProducto, String StockProducto, String PrecioUnitario, String EstadoProducto, String CategoriaFK, String IdEmpresaProveedoraFK) {
        this.IdProducto = IdProducto;
        this.CodigoDeBarrasProducto = CodigoDeBarrasProducto;
        this.ReferenciaProducto = ReferenciaProducto;
        this.DescripcionProducto = DescripcionProducto;
        this.StockProducto = StockProducto;
        this.PrecioUnitario = PrecioUnitario;
        this.EstadoProducto = EstadoProducto;
        this.IdCategoriaFK = CategoriaFK;
        this.IdEmpresaProveedoraFK = IdEmpresaProveedoraFK;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getCodigoDeBarrasProducto() {
        return CodigoDeBarrasProducto;
    }

    public void setCodigoDeBarrasProducto(String CodigoDeBarrasProducto) {
        this.CodigoDeBarrasProducto = CodigoDeBarrasProducto;
    }

    public String getReferenciaProducto() {
        return ReferenciaProducto;
    }

    public void setReferenciaProducto(String ReferenciaProducto) {
        this.ReferenciaProducto = ReferenciaProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String DescripcionProducto) {
        this.DescripcionProducto = DescripcionProducto;
    }

    public String getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(String StockProducto) {
        this.StockProducto = StockProducto;
    }

    public String getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(String PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getEstadoProducto() {
        return EstadoProducto;
    }

    public void setEstadoProducto(String EstadoProducto) {
        this.EstadoProducto = EstadoProducto;
    }

    public String getIdCategoriaFK() {
        return IdCategoriaFK;
    }

    public void setIdCategoriaFK(String IdCategoriaFK) {
        this.IdCategoriaFK = IdCategoriaFK;
    }

    public String getIdEmpresaProveedoraFK() {
        return IdEmpresaProveedoraFK;
    }

    public void setIdEmpresaProveedoraFK(String IdEmpresaProveedoraFK) {
        this.IdEmpresaProveedoraFK = IdEmpresaProveedoraFK;
    }

   

   
}
