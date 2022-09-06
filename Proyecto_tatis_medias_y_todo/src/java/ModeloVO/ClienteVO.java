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
public class ClienteVO {
        
        private String IdCliente,NombreCliente,ApellidoCliente,TipoDocCliente,NumeroDocCliente,TelefonoCliente,DirecionCliente,CorreoCliente,EstadoCliente;

        public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }

    public String getTipoDocCliente() {
        return TipoDocCliente;
    }

    public void setTipoDocCliente(String TipoDocCliente) {
        this.TipoDocCliente = TipoDocCliente;
    }

    public String getNumeroDocCliente() {
        return NumeroDocCliente;
    }

    public void setNumeroDocCliente(String NumeroDocCliente) {
        this.NumeroDocCliente = NumeroDocCliente;
    }

    public String getDirecionCliente() {
        return DirecionCliente;
    }

    public void setDirecionCliente(String DirecionCliente) {
        this.DirecionCliente = DirecionCliente;
    }

    public String getCorreoCliente() {
        return CorreoCliente;
    }

    public void setCorreoCliente(String CorreoCliente) {
        this.CorreoCliente = CorreoCliente;
    }

    public String getEstadoCliente() {
        return EstadoCliente;
    }

    public void setEstadoCliente(String EstadoCliente) {
        this.EstadoCliente = EstadoCliente;
    }

    public ClienteVO() {
    }

    public ClienteVO(String IdCliente, String NombreCliente, String ApellidoCliente, String TipoDocCliente, String NumeroDocCliente,String TelefonoCliente, String DirecionCliente, String CorreoCliente, String EstadoCliente) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.ApellidoCliente = ApellidoCliente;
        this.TipoDocCliente = TipoDocCliente;
        this.NumeroDocCliente = NumeroDocCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.DirecionCliente = DirecionCliente;
        this.CorreoCliente = CorreoCliente;
        this.EstadoCliente = EstadoCliente;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String TelefonoCliente) {
        this.TelefonoCliente = TelefonoCliente;
    }
}
