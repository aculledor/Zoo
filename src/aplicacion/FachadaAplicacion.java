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

}
