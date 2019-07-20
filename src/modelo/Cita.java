package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cita {
    
    private int citaId;
    private Date citaFecha;
    private Diagnostico diagnostico;

    public int getCitaId() {
        return citaId;
    }

    public void setCitaId(int citaId) {
        this.citaId = citaId;
    }

    public Date getCitaFecha() {
        return citaFecha;
    }

    public void setCitaFecha(Date citaFecha) {
        this.citaFecha = citaFecha;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    
    
}
