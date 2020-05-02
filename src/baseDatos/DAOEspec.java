/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especimen;
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
    
}
