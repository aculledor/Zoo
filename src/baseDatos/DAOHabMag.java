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
    
    
    /*
    *   Realizado por Noel
    */
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
    
    
    /*
    *   Realizado por Noel
    */
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
    
    
    /*
    *   Realizado por Noel
    */
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
    
    
    /*
    *   Realizado por Noel
    */
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
    
    
    /*
    *   Realizado por Noel
    */
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
    
    
    /*
    *   Realizado por Abraham
    */
    public java.util.List<String> getListaAsoc(String especie){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select nombrepm "
                            + " from propiedadesmagicas as pr "
                            + " where pr.nombrepm in( "
                                + " select nombrepm2 "
                                + " from poseer as po "
                                + " where po.nombreea1 like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+especie+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("nombrepm"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try { stmCatalogo.close();} catch (SQLException e) {System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    
    /*
    *   Realizado por Abraham
    */
    public java.util.List<String> getListaDes(String especie){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {
            String consulta = "select nombrepm "
                            + " from propiedadesmagicas as pr "
                            + " where pr.nombrepm not in( "
                                + " select nombrepm2 "
                                + " from poseer as po "
                                + " where po.nombreea1 like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+especie+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("nombrepm"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try { stmCatalogo.close();} catch (SQLException e) {System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    
    /*
    *   Realizado por Abraham
    */
    public java.util.List<String> getListaRiesgosAsoc(String nombre){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {
            String consulta = "select designacionri "
                            + " from riesgos as ri "
                            + " where ri.designacionri in( "
                                + " select designacionr "
                                + " from presentar as pr "
                                + " where pr.nombrepm1 like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+nombre+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("designacionri"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try { stmCatalogo.close();} catch (SQLException e) {System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    
    /*
    *   Realizado por Abraham
    */
    public java.util.List<String> getListaRiesgosDes(String nombre){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {
            String consulta = "select designacionri "
                            + " from riesgos as ri "
                            + " where ri.designacionri not in( "
                                + " select designacionr "
                                + " from presentar as pr "
                                + " where pr.nombrepm1 like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+nombre+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("designacionri"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try { stmCatalogo.close();} catch (SQLException e) {System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    
    /*
    *   Realizado por Abraham
    */ 
    public void asignarRiesgos(String porpMag, java.util.List<String> riesgosAsoc){
        Connection con;
        PreparedStatement stmBorrado = null;
        PreparedStatement stmInsercion = null;

        con = super.getConexion();

        try {
            stmBorrado = con.prepareStatement("delete from presentar where nombrepm1 = ?");
            stmBorrado.setString(1, porpMag);
            stmBorrado.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrado.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        try {
            stmInsercion = con.prepareStatement("insert into presentar(nombrepm1, designacionr) values (?,?)");
            for (String c : riesgosAsoc) {
                stmInsercion.setString(1, porpMag);
                stmInsercion.setString(2, c);
                stmInsercion.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrado.close();
                stmInsercion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
}
