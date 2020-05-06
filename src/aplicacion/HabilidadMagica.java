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
public class HabilidadMagica {
    
    private String nombre;
    private String efectos;
    private String aplicaciones;

    public HabilidadMagica(String nombre, String efectos, String aplicaciones) {
        this.nombre = nombre;
        this.efectos = efectos;
        this.aplicaciones = aplicaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEfectos() {
        return efectos;
    }

    public void setEfectos(String efectos) {
        this.efectos = efectos;
    }

    public String getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(String aplicaciones) {
        this.aplicaciones = aplicaciones;
    }
    
    
    
}
