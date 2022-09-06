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
public class EmpleadoVO {

    private String IdEmpleado, NombreEmpleado, ApellidoEmpleado, TipoDocEmpleado, NumeroDocEmpleado, TelefonoCelularEmpleado, DirecionEmpleado, CorreoEmpleado, EstadoEmpleado, IdUsuarioFK;
    
     public EmpleadoVO(String IdEmpleado, String NombreEmpleado, String ApellidoEmpleado, String TipoDocEmpleado, String NumeroDocEmpleado, String TelefonoCelularEmpleado, String DirecionEmpleado, String CorreoEmpleado, String EstadoEmpleado, String IdUsuarioFK) {
        this.IdEmpleado = IdEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.ApellidoEmpleado = ApellidoEmpleado;
        this.TipoDocEmpleado = TipoDocEmpleado;
        this.NumeroDocEmpleado = NumeroDocEmpleado;
        this.TelefonoCelularEmpleado = TelefonoCelularEmpleado;
        this.DirecionEmpleado = DirecionEmpleado;
        this.CorreoEmpleado = CorreoEmpleado;
        this.EstadoEmpleado = EstadoEmpleado;
        this.IdUsuarioFK = IdUsuarioFK;
    }

    public EmpleadoVO() {
    }

    public EmpleadoVO(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
     
    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return ApellidoEmpleado;
    }

    public void setApellidoEmpleado(String ApellidoEmpleado) {
        this.ApellidoEmpleado = ApellidoEmpleado;
    }

    public String getTipoDocEmpleado() {
        return TipoDocEmpleado;
    }

    public void setTipoDocEmpleado(String TipoDocEmpleado) {
        this.TipoDocEmpleado = TipoDocEmpleado;
    }

    public String getNumeroDocEmpleado() {
        return NumeroDocEmpleado;
    }

    public void setNumeroDocEmpleado(String NumeroDocEmpleado) {
        this.NumeroDocEmpleado = NumeroDocEmpleado;
    }

    public String getTelefonoCelularEmpleado() {
        return TelefonoCelularEmpleado;
    }

    public void setTelefonoCelularEmpleado(String TelefonoCelularEmpleado) {
        this.TelefonoCelularEmpleado = TelefonoCelularEmpleado;
    }

    public String getDirecionEmpleado() {
        return DirecionEmpleado;
    }

    public void setDirecionEmpleado(String DirecionEmpleado) {
        this.DirecionEmpleado = DirecionEmpleado;
    }

    public String getCorreoEmpleado() {
        return CorreoEmpleado;
    }

    public void setCorreoEmpleado(String CorreoEmpleado) {
        this.CorreoEmpleado = CorreoEmpleado;
    }

    public String getEstadoEmpleado() {
        return EstadoEmpleado;
    }

    public void setEstadoEmpleado(String EstadoEmpleado) {
        this.EstadoEmpleado = EstadoEmpleado;
    }

    public String getIdUsuarioFK() {
        return IdUsuarioFK;
    }

    public void setIdUsuarioFK(String IdUsuarioFK) {
        this.IdUsuarioFK = IdUsuarioFK;
    }

   
}
