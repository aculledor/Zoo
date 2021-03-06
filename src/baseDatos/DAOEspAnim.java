/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especie;
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
    
    
    /*
    *   Realizado por Noel
    */
    public java.util.List<Especie> consultarEspecies() {
        
        java.util.List<Especie> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        
        con = this.getConexion();
        
        try{
            
            String consulta = "select nombreea, esperanzavida, descripcionanatomica,"
                    + "patologiascomunes, nivelpeligro, comportamientocomun, dieta"
                    + " from especiesanimales";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado.add(new Especie(rsCatalogo.getString("nombreea"), rsCatalogo.getInt("esperanzavida"),
                            rsCatalogo.getString("descripcionanatomica"), rsCatalogo.getString("patologiascomunes"),
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
    
    
    /*
    *   Realizado por Noel
    */
    public void insertarEspecie(Especie especie) throws SQLException {
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        //try{
            
            stmCatalogo=con.prepareStatement("insert into especiesanimales(nombreea,"
                    + "esperanzavida, descripcionanatomica, patologiascomunes,"
                    + "nivelpeligro, comportamientocomun, dieta) "+
                                      "values (?,?,?,?,?,?,?)");
            
            stmCatalogo.setString(1, especie.getNombre());
            stmCatalogo.setInt(2, especie.getEspVida());
            stmCatalogo.setString(3, especie.getDescAnat());
            stmCatalogo.setString(4, especie.getComonPat());
            stmCatalogo.setInt(5, especie.getPeligrosidad());
            stmCatalogo.setString(6, especie.getDescComp());
            stmCatalogo.setString(7, especie.getDieta());
            
            stmCatalogo.executeUpdate();
            
        /*    
        } catch(SQLException e) {
            
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            
        } finally {
            
            try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
        }*/
        
        try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
    }
    
    
    /*
    *   Realizado por Noel
    */
    public void modificarEspecie(Especie especie)  throws SQLException{
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        //try{
            
            stmCatalogo=con.prepareStatement("update especiesanimales "+
                                    "set esperanzavida=?, "+
                                    "descripcionanatomica=?,"+
                                    "patologiascomunes=?,"+
                                    "nivelpeligro=?,"+
                                    "comportamientocomun=?,"+
                                    "dieta=?"+
                                    "where nombreea=?");
            
           
            stmCatalogo.setInt(1, especie.getEspVida());
            stmCatalogo.setString(2, especie.getDescAnat());
            stmCatalogo.setString(3, especie.getComonPat());
            stmCatalogo.setInt(4, especie.getPeligrosidad());
            stmCatalogo.setString(5, especie.getDescComp());
            stmCatalogo.setString(6, especie.getDieta());
            stmCatalogo.setString(7, especie.getNombre());
            
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
    public void eliminarEspecie(String id){
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        try{
            
            stmCatalogo=con.prepareStatement("delete from especiesanimales where nombreea=?");
            
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
    public java.util.List<Especie> obtenerEspecies(String nombre, Integer vida, Integer peligrosidad, String dieta) {
        
        java.util.List<Especie> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select nombreea, esperanzavida, descripcionanatomica,"
                    + "patologiascomunes, nivelpeligro, comportamientocomun, dieta "
                    + "from especiesanimales as ea where nombreea like ? and "
                    + "dieta like ?";
            
            if(vida!=null) consulta += " and esperanzavida=?";
            if(peligrosidad!=null) consulta += " and nivelpeligro=?";
        
            
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+nombre+"%");
            stmCatalogo.setString(2, "%"+dieta+"%");
            if(vida!=null) {
                
                stmCatalogo.setInt(3, vida);
                
                if(peligrosidad!=null) stmCatalogo.setInt(4, peligrosidad);
            
            } else {
                
                if(peligrosidad!=null) stmCatalogo.setInt(3, peligrosidad);
            }
            
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(new Especie(rsCatalogo.getString("nombreea"), rsCatalogo.getInt("esperanzavida"),
                            rsCatalogo.getString("descripcionanatomica"), rsCatalogo.getString("patologiascomunes"),
                            rsCatalogo.getInt("nivelpeligro"), rsCatalogo.getString("comportamientocomun"), rsCatalogo.getString("dieta")));
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
    public void asignarHabilidades(String especie, java.util.List<String> propMag) {
        Connection con;
        PreparedStatement stmBorrado = null;
        PreparedStatement stmInsercion = null;

        con = super.getConexion();

        try {
            stmBorrado = con.prepareStatement("delete from poseer where nombreea1 = ?");
            stmBorrado.setString(1, especie);
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
            stmInsercion = con.prepareStatement("insert into poseer(nombrepm2, nombreea1) values (?,?)");
            for (String c : propMag) {
                stmInsercion.setString(1, c);
                stmInsercion.setString(2, especie);
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