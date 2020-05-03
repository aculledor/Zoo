/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Especimen;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class FachadaGui {

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VEspecimenes vesp;
    VEspecimen vdetesp;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
        vp.setVisible(true);
    }
    
    public void visualizarEspecimenes(VPrincipal padre){
        this.vesp = new VEspecimenes(padre, fa);
        vesp.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    public void visualizarDetallesEspecimen(VPrincipal padre){
        this.vdetesp = new VEspecimen(padre, fa);
        vdetesp.setVisible(true);
    }
}
