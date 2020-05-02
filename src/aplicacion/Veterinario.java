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
public class Veterinario extends Personal {
    
    private String id;

    public Veterinario(String id, String dni, String nombre, String apellidos, String raza, String aptMagica) {
        super(dni, nombre, apellidos, raza, aptMagica);
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    
}
