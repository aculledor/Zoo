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
    GestionHabilidadesMagicas cpm;
    GestionRiesgos cr;
    GestionProtocolos cp;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        ce = new GestionEspecimenes(fgui, fbd);
        cea = new GestionEspecies(fgui,fbd);
        cpm = new GestionHabilidadesMagicas(fgui,fbd);
        cr = new GestionRiesgos(fgui,fbd);
        cp = new GestionProtocolos(fgui,fbd);
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
    
    public void visualizarDatosEspecie(VPrincipal padre, String especie){
        fgui.visualizarDatosEspecie(padre, especie);
    }
    
    public void visualizarRiesgosPropMag(VPrincipal padre, String especie){
        fgui.visualizarRiesgosPropMag(padre, especie);
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
    
    public void visualizarDetallesEspecimen(VPrincipal padre, Especimen espe){
        fgui.visualizarDetallesEspecimen(padre,espe);
    }
        
    public void asignarHabilidades(String especie, java.util.List<String> habilidadesAsoc){
        fbd.asignarHabilidades(especie,habilidadesAsoc);
    }
    
    public java.util.List<String> getListaAsoc(String nombre){
        return cpm.getListaAsoc(nombre);
    }
    
    public java.util.List<String> getListaDes(String nombre){
        return cpm.getListaDes(nombre);
    }
    
    public java.util.List<String> getListaRiesgosAsoc(String nombre){
        return cpm.getListaRiesgosAsoc(nombre);
    }
    
    public java.util.List<String> getListaRiesgosDes(String nombre){
        return cpm.getListaRiesgosDes(nombre);
    }
        
    public void asignarRiesgos(String porpMag, java.util.List<String> riesgosAsoc){
        fbd.asignarRiesgos(porpMag,riesgosAsoc);
    }
    
    public java.util.List<Riesgo> getListaRiesgos(String especie){
        if(cr.getListaRiesgos(especie).isEmpty()){
            java.util.List<Riesgo> aux = new java.util.ArrayList<>();
            aux.add(new Riesgo("","")); return aux;
        }
        return cr.getListaRiesgos(especie);
    }
    
    public java.util.List<Protocolo> getListaProtocolos(String riesgo){
        if(riesgo.isBlank()){
            java.util.List<Protocolo> aux = new java.util.ArrayList<>();
            aux.add(new Protocolo("","","")); return aux;
        }
        return cp.getListaProtocolos(riesgo);
    }
    
    public void borrarEspecimen(int id, String especie){
        ce.borrarEspecimen(id,especie);
    }
    
    public void nuevoEspecimen(Integer id, String especie, String habitat, String veterinario){
        ce.nuevoEspecimen(id,especie,habitat,veterinario);
    }
    
    public int aforoMaximo(String habitat){
        return ce.aforoMaximo(habitat);
    }
    
    public int recuperarOcupacion(String habitat){
        return ce.recuperarOcupacion(habitat);
    }
    
    public boolean puedeContener(String especie, String habitat){
        return ce.puedeContener(especie, habitat);
    }
    
    public boolean isMonoespecie(String habitat){
        return ce.isMonoespecie(habitat);
    }
    
    public boolean compararEspecies(String especie,String habitat){
        return ce.compararEspecies(especie,habitat);
    }
    
    public void actualizarEspecimen(Integer idAntiguo, Integer idNuevo, String especie, String habitat, String veterinario){
        ce.actualizarEspecimen(idAntiguo, idNuevo,especie,habitat,veterinario);
    }
    
    public java.util.List<Especimen> consultarCompHabitat(Especimen espe){
        return ce.consultarCompHabitat(espe);
    }
    
    public String consultarDescHabitat(String habitat){
        return ce.consultarDescHabitat(habitat);
    }
    
    public String consultarInfrHabitat(String habitat){
        return ce.consultarInfrHabitat(habitat);
    }
    
    public java.util.List<Tratamiento> consultarTratamientos(Especimen espe){
        return ce.consultarTratamientos(espe);
    }
    
    public void nuevoTratamiento(Especimen espe, String cuidador, String medicamentos, String fechafin){
        ce.nuevoTratamiento(espe, cuidador, medicamentos, fechafin);
    }
    
    public void actualizarTratamiento(Especimen espe, String cuidador, String medicamentos, String fechainicio, String fechafin){
        ce.actualizarTratamiento(espe, cuidador, medicamentos, fechainicio, fechafin);
    }
    
    ///////////////////////////////////////////////////////
    
    public void guardarEspecie(Especie especie){
        cea.guardarEspecie(especie);
    }
    
    public void borrarEspecie(String especie_id){
        cea.borrarEspecie(especie_id);
    }
    
    public java.util.List<Especie> obtenerEspecies(String nombre, Integer vida, Integer peligrosidad, String dieta) {
        return cea.obtenerEspecies(nombre, vida, peligrosidad, dieta);
    }
    
    public java.util.List<HabilidadMagica> consultarHabilidadesMagicas(){
        return cpm.consultarHabilidadesMagicas();
    }
    
    public void guardarHabilidadMagica(HabilidadMagica pm){
        cpm.guardarHabilidadMagica(pm);
    }
    
    public void borrarHabilidadMagica(String especie_id){
        cpm.borrarHabilidadMagica(especie_id);
    }
    
    public java.util.List<HabilidadMagica> obtenerHabilidadesMagicas(String nombre, String efectos, String aplicaciones){
        return cpm.obtenerHabilidadesMagicas(nombre, efectos, aplicaciones);
    }
    
    public java.util.List<Riesgo> consultarRiesgos(){
        return cr.consultarRiesgos();
    }
    
    public void guardarRiesgo(Riesgo riesgo){
        cr.guardarRiesgo(riesgo);
    }
    
    public void borrarRiesgo(String especie_id){
        cr.borrarRiesgo(especie_id);
    }
    
    public java.util.List<Riesgo> obteneRiesgos(String tipo, String tratamiento) {
        return cr.obteneRiesgos(tipo, tratamiento);
    }
    
    public java.util.List<Protocolo> consultarProtocolos(){
        return cp.consultarProtocolos();
    }
    
    public void guardarProtocolo(Protocolo protocolo){
        cp.guardarProtocolo(protocolo);
    }
    
    public void borrarProtocolo(String especie_id){
        cp.borrarProtocolo(especie_id);
    }
    
    public java.util.List<Protocolo> obteneProtocolos(String id, String descripcion, String equipamiento) {
        return cp.obteneProtocolos(id, descripcion, equipamiento);
    }
    
}
