/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import gui.VPrincipal;
import java.sql.SQLException;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionEspecimenes ce;
    GestionEspecies cea;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        ce = new GestionEspecimenes(fgui, fbd);
        cea = new GestionEspecies(fgui,fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
    }
    
    public void visualizarEspecimenes(VPrincipal padre){
        fgui.visualizarEspecimenes(padre);
    }
    
    public void visualizarEspecies(VPrincipal padre){
        fgui.visualizarEspecies(padre);
    }
    
    public java.util.List<Especimen> consultarEspecimenes(){
        return ce.consultarEspecimenes();
    }
    
    public java.util.List<Especie> consultarEspecies(){
        return cea.consultarEspecies();
    }

    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento){
        return ce.obtenerEspecimenes(id,especie,habitat,enTratamiento);
    }
    
    public void visualizarDetallesEspecimen(VPrincipal padre){
        fgui.visualizarDetallesEspecimen(padre);
    }
    
    
    public void guardarEspecie(Especie especie){
        cea.guardarEspecie(especie);
    }
    
    public void borrarEspecie(String especie_id){
        cea.borrarEspecie(especie_id);
    }
}
