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
public class GestionEspecies {
    
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionEspecies(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    
    public java.util.List<Especie> consultarEspecies(){
        return fbd.consultarEspecies();
    }
    
    public void guardarEspecie(Especie especie){
        
        try {
            
            fbd.modificarEspecie(especie);
            
        } catch(SQLException e){
            
            try{
                
                fbd.insertarEspecie(especie);
                
            } catch(SQLException e2) {
            
            System.out.println(e2.getMessage());
            
            }
            
        }
    }
    
    public void borrarEspecie(String especie_id){
        fbd.eliminarEspecie(especie_id);
    }
    
}
