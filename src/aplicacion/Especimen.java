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
public class Especimen {

    private int numero;
    private String especie;
    private String habitat;
    private String veterinario;
    private String historialMedico;

    public Especimen(int numero, String especie, String habitat, String veterinario, String historialMedico) {
        this.numero = numero;
        this.especie = especie;
        this.habitat = habitat;
        this.veterinario = veterinario;
        this.historialMedico = historialMedico;
    }

    public int getIdentificador() {
        return numero;
    }

    public void setIdentificador(int numero) {
        this.numero = numero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    
    
    
}
