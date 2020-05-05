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
public class GestionProtocolos {
    
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionProtocolos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    
    public java.util.List<Protocolo> consultarProtocolos(){
        return fbd.consultarProtocolos();
    }
    
    public void guardarProtocolo(Protocolo protocolo){
        
        try {
            
            fbd.insertarProtocolo(protocolo);
            
        } catch(SQLException e){
            
            System.out.println(e.getMessage());
            
            try{
                
                fbd.modificarProtocolo(protocolo);
                
            } catch(SQLException e2) {
            
            System.out.println(e2.getMessage());
            
            }
        }
    }
    
    public void borrarProtocolo(String especie_id){
        fbd.eliminarProtocolo(especie_id);
    }
    
}
