/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author nosu
 */
public class Protocolo {
    
    private String identificador;
    private String descripcion;
    private String equipamiento;

    public Protocolo(String identificador, String descripcion, String equipamiento) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.equipamiento = equipamiento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }
    
    
    
}
