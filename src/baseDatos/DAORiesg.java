/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Riesgo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nosu
 */
public class DAORiesg extends AbstractDAO {
    
    public DAORiesg(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    
    /*
    *   Realizado por Noel
    */
    public java.util.List<Riesgo> consultarRiesgos() {
        
        java.util.List<Riesgo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        
        con = this.getConexion();
        
        try{
            
            String consulta = "select designacionri, tratamiento from riesgos";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado.add(new Riesgo(rsCatalogo.getString("designacionri"),
                                         rsCatalogo.getString("tratamiento")));
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
    public void insertarRiesgo(Riesgo riesgo) throws SQLException {
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("insert into riesgos(designacionri,"
                                                + "tratamiento) values (?,?)");
            
            stmCatalogo.setString(1, riesgo.getTipo());
            stmCatalogo.setString(2, riesgo.getTratamiento());
            
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
    public void modificarRiesgo(Riesgo riesgo)  throws SQLException{
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("update riesgos "+
                                                "set tratamiento=?, "+
                                                "where designacionri=?");
            
           
            stmCatalogo.setString(1, riesgo.getTratamiento());
            stmCatalogo.setString(2, riesgo.getTipo());
            
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
    public void eliminarRiesgo(String id){
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        try{
            
            stmCatalogo=con.prepareStatement("delete from riesgos where designacionri=?");
            
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
    public java.util.List<Riesgo> obteneRiesgos(String tipo, String tratamiento) {
        
        java.util.List<Riesgo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select designacionri, tratamiento from riesgos "
                            + "where designacionri like ? and tratamiento like ?";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+tipo+"%");
            stmCatalogo.setString(2, "%"+tratamiento+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(new Riesgo(rsCatalogo.getString("designacionri"),
                                         rsCatalogo.getString("tratamiento")));
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
    public java.util.List<Riesgo> getListaRiesgos(String habilidad){
        
        java.util.List<Riesgo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmPresentar = null;
        ResultSet rsPresentar;
        con = this.getConexion();

        try {

            String consulta = "select designacionri, tratamiento "
                            + " from riesgos as ri "
                            + " where ri.designacionri in( "
                                + " select designacionr "
                                + " from presentar as pr "
                                + " where pr.nombrepm1 like ? ) "
                    ;
            
            stmPresentar = con.prepareStatement(consulta);
            stmPresentar.setString(1, "%"+habilidad+"%");
            rsPresentar = stmPresentar.executeQuery();
            
            while (rsPresentar.next()) {
                resultado.add(new Riesgo(rsPresentar.getString("designacionri"),
                                         rsPresentar.getString("tratamiento")));
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPresentar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        return resultado;
    }
    
    
    
    /*
    *   Realizado por Abraham
    */
    public java.util.List<String> getListaProtoAsoc(String nombre){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {
            String consulta = "select designacionpro "
                            + " from protocolos as pro "
                            + " where pro.designacionpro in( "
                                + " select protocolo "
                                + " from implicar as im "
                                + " where im.riesgo like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+nombre+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("designacionpro"));
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
    public java.util.List<String> getListaProtoDes(String nombre){
        
        java.util.List<String> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {
            String consulta = "select designacionpro "
                            + " from protocolos as pro "
                            + " where pro.designacionpro not in( "
                                + " select protocolo "
                                + " from implicar as im "
                                + " where im.riesgo like ?) "
                    ;
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+nombre+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(rsCatalogo.getString("designacionpro"));
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
    public void asignarProto(String riesgo, java.util.List<String> protoAsoc){
        Connection con;
        PreparedStatement stmBorrado = null;
        PreparedStatement stmInsercion = null;

        con = super.getConexion();

        try {
            stmBorrado = con.prepareStatement("delete from implicar where riesgo = ?");
            stmBorrado.setString(1, riesgo);
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
            stmInsercion = con.prepareStatement("insert into implicar(protocolo, riesgo) values (?,?)");
            for (String c : protoAsoc) {
                stmInsercion.setString(1, c);
                stmInsercion.setString(2, riesgo);
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
