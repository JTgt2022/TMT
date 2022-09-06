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
public class PedidoVO {
    
    private String Idpedido,NumeroFacturaPedido,FechaPedido,FechaRecibido,FechaVencimientoPago,IdEmpresaProveedoraFK,IVA,Descuento,EstadoPedido;
     public PedidoVO(String Idpedido, String NumeroFacturaPedido, String FechaPedido, String FechaRecibido, String FechaVencimientoPago, String IdEmpresaProveedoraFK, String IVA, String Descuento, String EstadoPedido) {
        this.Idpedido = Idpedido;
        this.NumeroFacturaPedido = NumeroFacturaPedido;
        this.FechaPedido = FechaPedido;
        this.FechaRecibido = FechaRecibido;
        this.FechaVencimientoPago = FechaVencimientoPago;
        this.IdEmpresaProveedoraFK = IdEmpresaProveedoraFK;
        this.IVA = IVA;
        this.Descuento = Descuento;
        this.EstadoPedido = EstadoPedido;
    }

        public PedidoVO() {
    }
        

    public String getIdpedido() {
        return Idpedido;
    }

    public void setIdpedido(String Idpedido) {
        this.Idpedido = Idpedido;
    }

    public String getNumeroFacturaPedido() {
        return NumeroFacturaPedido;
    }

    public void setNumeroFacturaPedido(String NumeroFacturaPedido) {
        this.NumeroFacturaPedido = NumeroFacturaPedido;
    }

    public String getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(String FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

    public String getFechaRecibido() {
        return FechaRecibido;
    }

    public void setFechaRecibido(String FechaRecibido) {
        this.FechaRecibido = FechaRecibido;
    }

    public String getFechaVencimientoPago() {
        return FechaVencimientoPago;
    }

    public void setFechaVencimientoPago(String FechaVencimientoPago) {
        this.FechaVencimientoPago = FechaVencimientoPago;
    }

    public String getIdEmpresaProveedoraFK() {
        return IdEmpresaProveedoraFK;
    }

    public void setIdEmpresaProveedoraFK(String IdEmpresaProveedoraFK) {
        this.IdEmpresaProveedoraFK = IdEmpresaProveedoraFK;
    }

    public String getIVA() {
        return IVA;
    }

    public void setIVA(String IVA) {
        this.IVA = IVA;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String Descuento) {
        this.Descuento = Descuento;
    }

    public String getEstadoPedido() {
        return EstadoPedido;
    }

    public void setEstadoPedido(String EstadoPedido) {
        this.EstadoPedido = EstadoPedido;
    }

   
}

    