/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author acull
 */
public class Personal {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String raza;
    private String aptMagica;

    public Personal(String dni, String nombre, String apellidos, String raza, String aptMagica) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.raza = raza;
        this.aptMagica = aptMagica;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getAptMagica() {
        return aptMagica;
    }

    public void setAptMagica(String aptMagica) {
        this.aptMagica = aptMagica;
    }
    
    
    
}
