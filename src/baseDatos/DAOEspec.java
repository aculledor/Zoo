/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especimen;
import aplicacion.Habitat;
import aplicacion.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

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

            String consulta = "select numero, especie, habitates, veterinarioid, historialmedico "
                + "from especimenes "
                + "order by  especie, numero";
        
            stmCatalogo = con.prepareStatement(consulta);
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid"), rsCatalogo.getString("historialmedico")));
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
    
    /**
     *
     * @author Lois
     */
    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento) {
        java.util.List<Especimen> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select numero, especie, habitates, veterinarioid, historialmedico "
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
            
            consulta+="order by especie, numero";
            
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+especie+"%");
            stmCatalogo.setString(2, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid"), rsCatalogo.getString("historialmedico")));
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
    
    
    /**
     *
     * @author Lois
     */
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
    
    
    /**
     *
     * @author Lois
     */
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
    
    
    /**
     *
     * @author Lois
     */
    public void actualizarEspecimen(Integer idAntiguo, Integer idNuevo, String especie, String habitat, String veterinario){
        Connection con;
        PreparedStatement stmUsuario=null;
        
        con=this.getConexion();
        
        if(!veterinario.equals("")){
            String consulta = "update especimenes " + 
                              "set numero = ?, "
                            + "habitates = ?, "
                            + "veterinarioid = ? "
                            + "where numero = ? "
                            + "and especie like ? ";
            try  {
                stmUsuario=con.prepareStatement(consulta);

                stmUsuario.setInt(1, idNuevo);
                stmUsuario.setString(2, habitat);
                stmUsuario.setString(3, veterinario);
                stmUsuario.setInt(4, idAntiguo);
                stmUsuario.setString(5, especie);

                stmUsuario.executeUpdate();

            } catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        else{
            String consulta = "update especimenes " + 
                              "set numero = ?, "
                            + "habitates = ? "
                            + "where numero = ? "
                            + "and especie like ? ";
            try  {
                stmUsuario=con.prepareStatement(consulta);

                stmUsuario.setInt(1, idNuevo);
                stmUsuario.setString(2, habitat);
                stmUsuario.setInt(3, idAntiguo);
                stmUsuario.setString(4, especie);

                stmUsuario.executeUpdate();

            } catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
    }
    
    
    
    /**
     *
     * @author Lois
     */
    public int aforoMaximo(String habitat){
        int resultado=0;
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select aforo "
                    + "from habitats "
                    + "where deshabitat like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getInt("aforo");
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
    
    
    /**
     *
     * @author Lois
     */
    public int recuperarOcupacion(String habitat){
        int resultado=0;
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select count(*) as ocupacion "
                    + "from especimenes "
                    + "where habitates like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getInt("ocupacion");
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
    
    
    /**
     *
     * @author Lois
     */
    public boolean puedeContener(String especie, String habitat){
        String resultado="";
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select especiepd "
                    + "from podercontener "
                    + "where habitatpd like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getString("especiepd");
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
        return resultado.contains(especie);
    }
    
    
    /**
     *
     * @author Lois
     */
    public boolean isMonoespecie(String habitat){
        String resultado="";
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select tipohabitat "
                    + "from habitats "
                    + "where deshabitat like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getString("tipohabitat");
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
        return resultado.equalsIgnoreCase("Monoespecie");
    }
   
    
    /**
     *
     * @author Lois
     */
    public boolean compararEspecies(String especie,String habitat){
        String resultado="";
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select especie "
                    + "from especimenes "
                    + "where habitates like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+habitat+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getString("especie");
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
        return resultado.equalsIgnoreCase(especie);
        
    }
    
    
    /**
     *
     * @author Lois
     */
    public java.util.List<Especimen> consultarCompHabitat(Especimen espe){
        java.util.List<Especimen> resultado = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select numero, especie, habitates, veterinarioid, historialmedico "
                    + "from especimenes "
                    + "where habitates like ? "
                    + "and (numero, especie) != (select numero, especie "
                    +                           "from especimenes "
                    +                           "where numero = ? "
                    +                           "and especie like ?) ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%"+espe.getHabitat()+"%");
            stmCatalogo.setInt(2, espe.getIdentificador());
            stmCatalogo.setString(3, "%"+espe.getEspecie()+"%");
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                resultado.add(new Especimen(rsCatalogo.getInt("numero"), rsCatalogo.getString("especie"),
                            rsCatalogo.getString("habitates"), rsCatalogo.getString("veterinarioid"), rsCatalogo.getString("historialmedico")));
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
    
    
    /**
     *
     * @author Lois
     */
    public String consultarDescHabitat(String habitat){
        String resultado="";
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select desterreno "
                    + "from habitats "
                    + "where deshabitat like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, habitat);
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getString("desterreno");
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
    
    
    /**
     *
     * @author Lois
     */
    public String consultarInfrHabitat(String habitat){
        String resultado="";
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        try {

            String consulta = "select infraestructuraspresentes "
                    + "from habitats "
                    + "where deshabitat like ? ";
        
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, habitat);
            rsCatalogo = stmCatalogo.executeQuery();
            
            while (rsCatalogo.next()) {
                resultado=rsCatalogo.getString("infraestructuraspresentes");
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
    
    
    
    /**
     *
     * @author Lois
     */
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
                    + "and especimenea like ? "
                    + "order by fechainicio ";
        
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
    
    
    /**
     *
     * @author Lois
     */
    public void nuevoTratamiento(Especimen espe, String cuidador, String medicamentos, String fechafin){
        Connection con;
        PreparedStatement stmUsuario=null;
        String consulta;
        LocalDate todayLocalDate = LocalDate.now( ZoneId.of( "Europe/Madrid" ) );
        java.sql.Date sqlDateFin = java.sql.Date.valueOf(fechafin); 
        
        con=this.getConexion();
        if(!fechafin.equals("") && !todayLocalDate.isAfter(sqlDateFin.toLocalDate())){
            consulta = "insert into tratar " + 
                          "(especimenea, especimennum, cuidadorid, medicamentos, fechafin) " +
                          "values (?,?,?,?,?)";
        }
        else{
            consulta = "insert into tratar " + 
                          "(especimenea, especimennum, cuidadorid, medicamentos) " +
                          "values (?,?,?,?)";
        }
        try  {
            stmUsuario=con.prepareStatement(consulta);
            
            stmUsuario.setString(1, espe.getEspecie());
            stmUsuario.setInt(2, espe.getIdentificador());
            stmUsuario.setString(3, cuidador);
            stmUsuario.setString(4, medicamentos);
            if(!fechafin.equals("") && todayLocalDate.isBefore(sqlDateFin.toLocalDate())){
                stmUsuario.setDate(5, sqlDateFin);
            }
            
            stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    
    /**
     *
     * @author Lois
     */
    public void actualizarTratamiento(Especimen espe, String cuidador, String medicamentos, String fechainicio, String fechafin){
        Connection con;
        PreparedStatement stmUsuario=null;
        java.sql.Date sqlDateInicio = java.sql.Date.valueOf(fechainicio); 
        java.sql.Date sqlDateFin=null;
        
        if(!fechafin.equals("")){
            sqlDateFin = java.sql.Date.valueOf(fechafin); 
        }
        
        con=this.getConexion();
        
        String consulta = "update tratar " + 
                          "set cuidadorid = ?, ";
                
        if(!fechafin.equals("") && !sqlDateInicio.toLocalDate().isAfter(sqlDateFin.toLocalDate())){
            consulta += "fechafin = ?, "
                        + "medicamentos = ? "
                        + "where especimenea like ? "
                        + "and especimennum = ? "
                        + "and fechainicio = ? ";
            try  {
                stmUsuario=con.prepareStatement(consulta);

                stmUsuario.setString(1, cuidador);
                stmUsuario.setDate(2, sqlDateFin);
                stmUsuario.setString(3, medicamentos);
                stmUsuario.setString(4, espe.getEspecie());
                stmUsuario.setInt(5, espe.getIdentificador());
                stmUsuario.setDate(6, sqlDateInicio);

                stmUsuario.executeUpdate();

            } catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
        else{
            consulta += "medicamentos = ? "
                        + "where especimenea like ? "
                        + "and especimennum = ? "
                        + "and fechainicio = ? ";
            try  {
                stmUsuario=con.prepareStatement(consulta);

                stmUsuario.setString(1, cuidador);
                stmUsuario.setString(2, medicamentos);
                stmUsuario.setString(3, espe.getEspecie());
                stmUsuario.setInt(4, espe.getIdentificador());
                stmUsuario.setDate(5, sqlDateInicio);

                stmUsuario.executeUpdate();

            } catch (SQLException e){
              System.out.println(e.getMessage());
              this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }finally{
              try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
            }
        }
    }

}
