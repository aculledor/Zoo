/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;

/**
 *
 * @author acull
 */
public class EquipoMantenimiento {
    
    private String designacion;
    private String recursos;
    private ArrayList<Mantenimiento> miembrosEquipo;

    public EquipoMantenimiento(String designacion, String recursos) {
        this.designacion = designacion;
        this.recursos = recursos;
    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public ArrayList<Mantenimiento> getMiembrosEquipo() {
        return miembrosEquipo;
    }

}
