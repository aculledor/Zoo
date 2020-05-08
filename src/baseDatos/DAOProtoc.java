/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Protocolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nosu
 */
public class DAOProtoc extends AbstractDAO {
    
    public DAOProtoc(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Protocolo> consultarProtocolos() {
        
        java.util.List<Protocolo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        
        con = this.getConexion();
        
        try{
            
            String consulta = "select designacionpro, descripcionpro, equipamiento"
                            + " from protocolos";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado.add(new Protocolo(rsCatalogo.getString("designacionpro"),
                                                   rsCatalogo.getString("descripcionpro"),
                                                    rsCatalogo.getString("equipamiento")));
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
    
    
    public void insertarProtocolo(Protocolo precaucion) throws SQLException {
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("insert into protocolos(designacionpro,"
                                + "descripcionpro, equipamiento) values (?,?,?)");
            
            stmCatalogo.setString(1, precaucion.getIdentificador());
            stmCatalogo.setString(2, precaucion.getDescripcion());
            stmCatalogo.setString(3, precaucion.getEquipamiento());
            
            stmCatalogo.executeUpdate();
        
        try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
    }
    
    
    public void modificarProtocolo(Protocolo precaucion)  throws SQLException{
        
        Connection con;
        PreparedStatement stmCatalogo;
        
        con=super.getConexion();
            
            stmCatalogo=con.prepareStatement("update protocolos "+
                                                "set descripcionpro=?, "+
                                                "equipamiento=?"+
                                                "where designacionpro=?");
            
           
            stmCatalogo.setString(1, precaucion.getDescripcion());
            stmCatalogo.setString(2, precaucion.getEquipamiento());
            stmCatalogo.setString(3, precaucion.getIdentificador());
            
            stmCatalogo.executeUpdate();
        
        try {
                stmCatalogo.close();
                
            } catch (SQLException e) {
                
                System.out.println("Imposible cerrar cursores");
            }
    }
    
    
    public void eliminarProtocolo(String id){
        
        Connection con;
        PreparedStatement stmCatalogo=null;
        
        con=super.getConexion();
        
        try{
            
            stmCatalogo=con.prepareStatement("delete from protocolos where designacionpro=?");
            
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
    
    
    
    public java.util.List<Protocolo> obteneProtocolos(String id, String descripcion, String equipamiento) {
        
        java.util.List<Protocolo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select designacionpro, descripcionpro, equipamiento"
                            + " from protocolos as pro where designacionpro like ? "
                            + " and  descripcionpro like ? and equipamiento like ?";
            
            stmCatalogo = con.prepareStatement(consulta);
            
            stmCatalogo.setString(1, "%"+id+"%");
            stmCatalogo.setString(2, "%"+descripcion+"%");
            stmCatalogo.setString(3, "%"+equipamiento+"%");
            
            rsCatalogo = stmCatalogo.executeQuery();
            
            
            while (rsCatalogo.next()) {
                resultado.add(new Protocolo(rsCatalogo.getString("designacionpro"),
                                                   rsCatalogo.getString("descripcionpro"),
                                                    rsCatalogo.getString("equipamiento")));
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
    public java.util.List<Protocolo> getListaProtocolos(String riesgo){
        
        java.util.List<Protocolo> resultado = new java.util.ArrayList<>();
        
        Connection con;
        PreparedStatement stmImplicar = null;
        ResultSet rsImplicar;
        con = this.getConexion();

        try {
            String consulta = "select designacionpro, descripcionpro, equipamiento"
                            + " from protocolos as pro " 
                            + " where pro.designacionpro in( "
                                + " select protocolo "
                                + " from implicar im "
                                + " where im.riesgo like ?) " 
                    ;
            
            stmImplicar = con.prepareStatement(consulta);
            stmImplicar.setString(1, "%"+riesgo+"%");
            rsImplicar = stmImplicar.executeQuery();
            
            while (rsImplicar.next()) {
                resultado.add(new Protocolo(rsImplicar.getString("designacionpro"),
                                            rsImplicar.getString("descripcionpro"),
                                            rsImplicar.getString("equipamiento")));
            } 
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage()); 
        } finally { 
            try { stmImplicar.close(); } catch (SQLException e) {  System.out.println("Imposible cerrar cursores"); }
        }

        return resultado;
    }
}
