/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Especie;
import aplicacion.Especimen;
import aplicacion.HabilidadMagica;
import aplicacion.Protocolo;
import aplicacion.Riesgo;
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
    private DAOHabMag daoHabMag;
    private DAORiesg daoRiesg;
    private DAOProtoc daoProtoc;
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
            daoHabMag = new DAOHabMag(conexion,fa);
            daoRiesg = new DAORiesg(conexion,fa);
            daoProtoc = new DAOProtoc(conexion,fa);
            

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
    
    // NOSU
    
    public java.util.List<Especie> consultarEspecies(){
       return daoEspAnim.consultarEspecies();
    }
    
    public void insertarEspecie(Especie especie) throws SQLException {
        daoEspAnim.insertarEspecie(especie);
    }
    
    public void modificarEspecie(Especie especie) throws SQLException {
        daoEspAnim.modificarEspecie(especie);
    }
    
    public void eliminarEspecie(String especie_id){
        daoEspAnim.eliminarEspecie(especie_id);
    }
    
    public java.util.List<HabilidadMagica> consultarHabilidadesMagicas(){
       return daoHabMag.consultarHabilidadesMagicas();
    }
    
    public void insertarHabilidadMagica(HabilidadMagica pm) throws SQLException {
        daoHabMag.insertarHabilidadMagica(pm);
    }
    
    public void modificarHabilidadMagica(HabilidadMagica pm) throws SQLException {
        daoHabMag.modificarHabilidadMagica(pm);
    }
    
    public void eliminarHabilidadMagica(String especie_id){
        daoHabMag.eliminarHabilidadMagica(especie_id);
    }
    
    public java.util.List<Riesgo> consultarRiesgos(){
       return daoRiesg.consultarRiesgos();
    }
    
    public void insertarRiesgo(Riesgo riesgo) throws SQLException {
        daoRiesg.insertarRiesgo(riesgo);
    }
    
    public void modificarRiesgo(Riesgo riesgo) throws SQLException {
        daoRiesg.modificarRiesgo(riesgo);
    }
    
    public void eliminarRiesgo(String especie_id){
        daoRiesg.eliminarRiesgo(especie_id);
    }
    
    public java.util.List<Protocolo> consultarProtocolos(){
       return daoProtoc.consultarProtocolos();
    }
    
    public void insertarProtocolo(Protocolo protocolo) throws SQLException {
        daoProtoc.insertarProtocolo(protocolo);
    }
    
    public void modificarProtocolo(Protocolo protocolo) throws SQLException {
        daoProtoc.modificarProtocolo(protocolo);
    }
    
    public void eliminarProtocolo(String especie_id){
        daoProtoc.eliminarProtocolo(especie_id);
    }
    
    
    
}
