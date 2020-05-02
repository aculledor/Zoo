/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author acull
 */
public class Tratamiento {

    private String cuidador;
    private String medicamentos;
    private String fechaInicio;
    private String fechaFin;

    public Tratamiento(String cuidador, String medicamentos, String fechaInicio, String fechaFin) {
        this.cuidador = cuidador;
        this.medicamentos = medicamentos;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getCuidador() {
        return cuidador;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
    
    
    
}
