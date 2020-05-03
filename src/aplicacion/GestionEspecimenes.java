/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author acull
 */
public class GestionEspecimenes {

    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionEspecimenes(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<Especimen> consultarEspecimenes(){
        return fbd.consultarEspecimenes();
    }
    
    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento){
        return fbd.obtenerEspecimenes(id,especie,habitat,enTratamiento);
    }
}
