/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import gui.VPrincipal;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionEspecimenes ce;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        ce = new GestionEspecimenes(fgui, fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
    }
    
    public void visualizarEspecimenes(VPrincipal padre){
        fgui.visualizarEspecimenes(padre);
    }
    
    public java.util.List<Especimen> consultarEspecimenes(){
        return ce.consultarEspecimenes();
    }

    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento){
        return ce.obtenerEspecimenes(id,especie,habitat,enTratamiento);
    }
    
    public void visualizarDetallesEspecimen(VPrincipal padre, Especimen espe){
        fgui.visualizarDetallesEspecimen(padre,espe);
    }
    
    public void borrarEspecimen(int id, String especie){
        ce.borrarEspecimen(id,especie);
    }
    
    public void nuevoEspecimen(Integer id, String especie, String habitat, String veterinario){
        ce.nuevoEspecimen(id,especie,habitat,veterinario);
    }
    
    public java.util.List<Especimen> consultarCompHabitat(Especimen espe){
        return ce.consultarCompHabitat(espe);
    }
    
    public java.util.List<Tratamiento> consultarTratamientos(Especimen espe){
        return ce.consultarTratamientos(espe);
    }
    
    public void nuevoTratamiento(Especimen espe, String cuidador, String medicamentos, String fechainicio, String fechafin){
        ce.nuevoTratamiento(espe, cuidador, medicamentos, fechainicio, fechafin);
    }
}
