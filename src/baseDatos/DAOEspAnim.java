/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especie;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nosu
 */
public class DAOEspAnim extends AbstractDAO{
    
    public DAOEspAnim(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Especie> consultarEspecies() {
        
        java.util.List<Especie> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        
        con = this.getConexion();
        
        try{
            
            String consulta = "select nombreea, esperanzavida, descripcionanatomica,"
                    + "patalogiascomunes, nivelpeligro, comportamientocomun, dieta";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado.add(new Especie(rsCatalogo.getString("nombreea"), rsCatalogo.getInt("esperanzavida"),
                            rsCatalogo.getString("descripcionanatomica"), rsCatalogo.getString("patalogiascomunes"),
                            rsCatalogo.getInt("nivelpeligro"), rsCatalogo.getString("comportamientocomun"), rsCatalogo.getString("dieta")));
            }
            
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            
        } finally {
            
            try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        return resultado;
    }
    
    
    
    
    
    
}
