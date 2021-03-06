/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.sql.SQLException;

/**
 *
 * @author nosu
 */
public class GestionRiesgos {
    
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionRiesgos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    
    public java.util.List<Riesgo> consultarRiesgos(){
        return fbd.consultarRiesgos();
    }
    
    public void guardarRiesgo(Riesgo riesgo){
        
        try {
            
            fbd.insertarRiesgo(riesgo);
            
        } catch(SQLException e){
            
            try{
                
                fbd.modificarRiesgo(riesgo);
                
            } catch(SQLException e2) {
            
            System.out.println(e2.getMessage());
            
            }
            
        }
    }
    
    public void borrarRiesgo(String especie_id){
        fbd.eliminarRiesgo(especie_id);
    }
    
    public java.util.List<Riesgo> obteneRiesgos(String tipo, String tratamiento) {
        return fbd.obteneRiesgos(tipo, tratamiento);
    }
    
    public java.util.List<Riesgo> getListaRiesgos(String especie){
        return fbd.getListaRiesgos(especie);
    }
    
    public java.util.List<String> getListaProtoAsoc(String nombre){
        return fbd.getListaProtoAsoc(nombre);
    }
    
    public java.util.List<String> getListaProtoDes(String nombre){
        return fbd.getListaProtoDes(nombre);
    }
        
    public void asignarProto(String riesgo, java.util.List<String> protoAsoc){
        fbd.asignarProto(riesgo,protoAsoc);
    }
    
}
