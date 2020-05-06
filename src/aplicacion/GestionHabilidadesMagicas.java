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
public class GestionHabilidadesMagicas {
    
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionHabilidadesMagicas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    
    public java.util.List<HabilidadMagica> consultarHabilidadesMagicas(){
        return fbd.consultarHabilidadesMagicas();
    }
    
    public void guardarHabilidadMagica(HabilidadMagica habilidad){
        
        try {
            
            fbd.insertarHabilidadMagica(habilidad);
            
        } catch(SQLException e){
            
            System.out.println(e.getMessage());
            
            try{
                
                fbd.modificarHabilidadMagica(habilidad);
                
            } catch(SQLException e2) {
            
            System.out.println(e2.getMessage());
            
            }
            
        }
    }
    
    public void borrarHabilidadMagica(String especie_id){
        fbd.eliminarHabilidadMagica(especie_id);
    }
    
    public java.util.List<HabilidadMagica> obtenerHabilidadesMagicas(String nombre, String efectos, String aplicaciones){
        return fbd.obtenerHabilidadesMagicas(nombre, efectos, aplicaciones);
    }
    
}
