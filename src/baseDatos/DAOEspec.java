/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especimen;
import aplicacion.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acull
 */
public class DAOEspec extends AbstractDAO {

    public DAOEspec(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Especimen> consultarEspecimenes() {
        java.util.List<Especimen> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select numero, especie, habitates, veterinarioid "
                + "from especimenes";
        
            stmCatalogo = con.prepareStatement(consulta);
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid")));
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
    
    
    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento) {
        java.util.List<Especimen> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select numero, especie, habitates, veterinarioid "
                + "from especimenes as e "
                +"where especie like ?"
                +"  and habitates like ?";
        
            if (id != null)
                consulta = consulta + " and numero = "+id.toString();
            
            
            if (enTratamiento)
            consulta = consulta + "  and exists (select * "+
                                         "              from tratar as tr "+
                                         "             	where e.especie =tr.especimenea "+
                                         "             	and e.numero=tr.especimennum "+
                                         "              and tr.fechafin is null)";
            
            
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+especie+"%");
            stmCatalogo.setString(2, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid")));
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
    
    public void borrarEspecimen(int id, String especie){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("delete from especimenes "+
                                        "where numero = ? "+
                                        "and especie like ?");
        stmUsuario.setInt(1, id);
        stmUsuario.setString(2, especie);
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    
    public void nuevoEspecimen(Integer id, String especie, String habitat, String veterinario){
        Connection con;
        PreparedStatement stmUsuario=null;
        String consulta;
        
        con=this.getConexion();
        if(veterinario.equals("")){
            consulta = "insert into especimenes " + 
                          "(numero, especie, habitates) " +
                          "values (?,?,?)";
        }
        else{
            consulta = "insert into especimenes " + 
                          "(numero, especie, habitates, veterinarioid) " +
                          "values (?,?,?,?)";
        }
        try  {
            stmUsuario=con.prepareStatement(consulta);
            
            stmUsuario.setInt(1, id);
            stmUsuario.setString(2, especie);
            stmUsuario.setString(3, habitat);
            if(!veterinario.equals(""))
                stmUsuario.setString(4, veterinario);
            
            stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public java.util.List<Especimen> consultarCompHabitat(Especimen espe){
        java.util.List<Especimen> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select numero, especie, habitates, veterinarioid "
                    + "from especimenes "
                    + "where habitates like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+espe.getHabitat()+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid")));
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
    
    public java.util.List<Tratamiento> consultarTratamientos(Especimen espe){
        java.util.List<Tratamiento> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select cuidadorid, medicamentos, fechainicio, fechafin "
                    + "from tratar "
                    + "where especimennum = ? "
                    + "and especimenea like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setInt(1, espe.getIdentificador());
            stmCatalogo.setString(2, "%"+espe.getEspecie()+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Tratamiento(rsCatalogo.getString("cuidadorid"), rsCatalogo.getString("medicamentos"),
                            rsCatalogo.getString("fechainicio"), rsCatalogo.getString("fechafin")));
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
