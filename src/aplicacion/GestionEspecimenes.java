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
    
    public void borrarEspecimen(int id, String especie){
        fbd.borrarEspecimen(id,especie);
    }
    
    public void nuevoEspecimen(Integer id, String especie, String habitat, String veterinario){
        fbd.nuevoEspecimen(id,especie,habitat,veterinario);
    }
    
    public void actualizarEspecimen(Integer idAntiguo, Integer idNuevo, String especie, String habitat, String veterinario){
        fbd.actualizarEspecimen(idAntiguo, idNuevo, especie ,habitat, veterinario);
    }
    
    public java.util.List<Especimen> consultarCompHabitat(Especimen espe){
        return fbd.consultarCompHabitat(espe);
    }
    
    public String consultarDescHabitat(String habitat){
        return fbd.consultarDescHabitat(habitat);
    }
    
    public String consultarInfrHabitat(String habitat){
        return fbd.consultarInfrHabitat(habitat);
    }
    
    public java.util.List<Tratamiento> consultarTratamientos(Especimen espe){
        return fbd.consultarTratamientos(espe);
    }
    
    public void nuevoTratamiento(Especimen espe, String cuidador, String medicamentos, String fechainicio, String fechafin){
        fbd.nuevoTratamiento(espe, cuidador, medicamentos, fechainicio, fechafin);
    }
}
