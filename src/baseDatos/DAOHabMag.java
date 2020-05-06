/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.HabilidadMagica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nosu
 */
public class DAOHabMag extends AbstractDAO {
    
    public DAOHabMag(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<HabilidadMagica> consultarHabilidadesMagicas() {
        
        java.util.List<HabilidadMagica> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        
        con = this.getConexion();
        
        try{
            
            String consulta = "select nombrepm, efectos, posiblesaplicaciones "
                            + " from propiedadesmagicas";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado.add(new HabilidadMagica(rsCatalogo.getString("nombrepm"),
                                                   rsCatalogo.getString("efectos"),
                                                    rsCatalogo.getString("posiblesaplicaciones")));
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
    
    
    public void insertarHabilidadMagica(HabilidadMagica propiedad) throws SQLException {
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("insert into propiedadesmagicas(nombrepm,"
                                + "efectos, posiblesaplicaciones) values (?,?,?)");
            
            stmCatalogo.setString(1, propiedad.getNombre());
            stmCatalogo.setString(2, propiedad.getEfectos());
            stmCatalogo.setString(3, propiedad.getAplicaciones());
            
            stmCatalogo.executeUpdate();
        
        try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
    }
    
    
    public void modificarHabilidadMagica(HabilidadMagica propiedad)  throws SQLException{
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("update propiedadesmagicas "+
                                    "set efectos=?, "+
                                    "posiblesaplicaciones=?"+
                                    "where nombrepm=?");
            
           
            stmCatalogo.setString(1, propiedad.getEfectos());
            stmCatalogo.setString(2, propiedad.getAplicaciones());
            stmCatalogo.setString(3, propiedad.getNombre());
            
            stmCatalogo.executeUpdate();
        
        try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
    }
    
    
    public void eliminarHabilidadMagica(String id){
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        try{
            
            stmCatalogo=con.prepareStatement("delete from propiedadesmagicas where nombrepm=?");
            
            stmCatalogo.setString(1, id);
            
            stmCatalogo.executeUpdate();
            
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
    }
    
    
    
    public java.util.List<HabilidadMagica> obtenerHabilidadesMagicas(String nombre, String efectos, String aplicaciones) {
        
        java.util.List<HabilidadMagica> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select nombrepm, efectos, posiblesaplicaciones "
                            + " from propiedadesmagicas as pm where nombrepm like ? "
                            + " and efectos like ? and posiblesaplicaciones like ?";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+nombre+"%");
            stmCatalogo.setString(2, "%"+efectos+"%");
            stmCatalogo.setString(3, "%"+aplicaciones+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(new HabilidadMagica(rsCatalogo.getString("nombrepm"),
                                                   rsCatalogo.getString("efectos"),
                                                    rsCatalogo.getString("posiblesaplicaciones")));
            }

        } catch (SQLException e) {
            
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
