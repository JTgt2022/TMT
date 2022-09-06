/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Alexis
 */
public class DetallePedidoVO {
     public DetallePedidoVO() {
    }
     private String IdPedidoFK,IdProductoFK,PrecioUnitario,Cantidad;

    public DetallePedidoVO(String IdPedidoFK, String IdProductoFK, String PrecioUnitario, String Cantidad) {
        this.IdPedidoFK = IdPedidoFK;
        this.IdProductoFK = IdProductoFK;
        this.PrecioUnitario = PrecioUnitario;
        this.Cantidad = Cantidad;
    }

    public String getIdPedidoFK() {
        return IdPedidoFK;
    }

    public void setIdPedidoFK(String IdPedidoFK) {
        this.IdPedidoFK = IdPedidoFK;
    }

    public String getIdProductoFK() {
        return IdProductoFK;
    }

    public void setIdProductoFK(String IdProductoFK) {
        this.IdProductoFK = IdProductoFK;
    }

    public String getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(String PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

   
}
