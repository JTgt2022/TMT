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
public class EmpresaProveedoraVO {
    private String IdEmpresaProveedora, NitEmpresaProveedora,RazonSocialEmpresaProveedora,NombreComercialEmpresaProveedora,DireccionEmpresaProveedora,
TelefonoEmpresaProveedora,Numeropago,EstadoEmpresaProveedora;

    public String getIdEmpresaProveedora() {
        return IdEmpresaProveedora;
    }

    public void setIdEmpresaProveedora(String IdEmpresaProveedora) {
        this.IdEmpresaProveedora = IdEmpresaProveedora;
    }

    public String getNitEmpresaProveedora() {
        return NitEmpresaProveedora;
    }

    public void setNitEmpresaProveedora(String NitEmpresaProveedora) {
        this.NitEmpresaProveedora = NitEmpresaProveedora;
    }

    public String getRazonSocialEmpresaProveedora() {
        return RazonSocialEmpresaProveedora;
    }

    public void setRazonSocialEmpresaProveedora(String RazonSocialEmpresaProveedora) {
        this.RazonSocialEmpresaProveedora = RazonSocialEmpresaProveedora;
    }

    public String getNombreComercialEmpresaProveedora() {
        return NombreComercialEmpresaProveedora;
    }

    public void setNombreComercialEmpresaProveedora(String NombreComercialEmpresaProveedora) {
        this.NombreComercialEmpresaProveedora = NombreComercialEmpresaProveedora;
    }

    public String getDireccionEmpresaProveedora() {
        return DireccionEmpresaProveedora;
    }

    public void setDireccionEmpresaProveedora(String DireccionEmpresaProveedora) {
        this.DireccionEmpresaProveedora = DireccionEmpresaProveedora;
    }

    public String getTelefonoEmpresaProveedora() {
        return TelefonoEmpresaProveedora;
    }

    public void setTelefonoEmpresaProveedora(String TelefonoEmpresaProveedora) {
        this.TelefonoEmpresaProveedora = TelefonoEmpresaProveedora;
    }

    public String getNumeropago() {
        return Numeropago;
    }

    public void setNumeropago(String Numeropago) {
        this.Numeropago = Numeropago;
    }

    public String getEstadoEmpresaProveedora() {
        return EstadoEmpresaProveedora;
    }

    public void setEstadoEmpresaProveedora(String EstadoEmpresaProveedora) {
        this.EstadoEmpresaProveedora = EstadoEmpresaProveedora;
    }

    public EmpresaProveedoraVO(String IdEmpresaProveedora, String NitEmpresaProveedora, String RazonSocialEmpresaProveedora, String NombreComercialEmpresaProveedora, String DireccionEmpresaProveedora, String TelefonoEmpresaProveedora, String Numeropago, String EstadoEmpresaProveedora) {
        this.IdEmpresaProveedora = IdEmpresaProveedora;
        this.NitEmpresaProveedora = NitEmpresaProveedora;
        this.RazonSocialEmpresaProveedora = RazonSocialEmpresaProveedora;
        this.NombreComercialEmpresaProveedora = NombreComercialEmpresaProveedora;
        this.DireccionEmpresaProveedora = DireccionEmpresaProveedora;
        this.TelefonoEmpresaProveedora = TelefonoEmpresaProveedora;
        this.Numeropago = Numeropago;
        this.EstadoEmpresaProveedora = EstadoEmpresaProveedora;
    }

    public EmpresaProveedoraVO() {
    }

}