/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especie;
import aplicacion.Especimen;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOEspec daoEspec;
    private DAOEspAnim daoEspAnim;
    //private DAOCategorias daoCategorias;
    //private DAOUsuarios daoUsuarios;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;
        
        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daoEspec = new DAOEspec(conexion, fa);
            daoEspAnim  = new DAOEspAnim(conexion,fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }
    
    public java.util.List<Especimen> consultarEspecimenes(){
       return daoEspec.consultarEspecimenes();
    }

    public java.util.List<Especimen> obtenerEspecimenes(Integer id, String especie, String habitat, boolean enTratamiento){
        return daoEspec.obtenerEspecimenes(id,especie,habitat,enTratamiento);
    }
    
    public java.util.List<Especie> consultarEspecies(){
       return daoEspAnim.consultarEspecies();
    }
    
    public void insertarEspecie(Especie especie) throws SQLException {
        daoEspAnim.insertarEspecie(especie);
    }
    
    public void modificarEspecie(Especie especie) throws SQLException {
        daoEspAnim.insertarEspecie(especie);
    }
    
    public void eliminarEspecie(String especie_id){
        daoEspAnim.eliminarEspecie(especie_id);
    }
    
    
    
}
