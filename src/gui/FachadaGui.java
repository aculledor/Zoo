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
    VEspecies vea;
    VDatosEspecie vdae;
            

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
        vp.setVisible(true);
    }
    
    public void visualizarEspecimenes(VPrincipal padre){
        this.vesp = new VEspecimenes(padre, fa);
        vesp.setVisible(true);
    }
    
    public void visualizarEspecies(VPrincipal padre){
        this.vea = new VEspecies(padre, fa);
        vea.setVisible(true);
    }
    
    public void visualizarDatosEspecie(VPrincipal padre, String especie){
        this.vdae = new VDatosEspecie(padre, fa, especie);
        vdae.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    public void visualizarDetallesEspecimen(VPrincipal padre,Especimen espe){
        this.vdetesp = new VEspecimen(padre, fa, espe);
        vdetesp.setVisible(true);
    }
}
