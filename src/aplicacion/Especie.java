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
public class Especie {

    private String nombre;
    private int espVida;
    private String descAnat;
    private String comonPat;
    private int peligrosidad;
    private String descComp;
    private String dieta;

    public Especie(String nombre, int espVida, String descAnat, String comonPat, int peligrosidad, String descComp, String dieta) {
        this.nombre = nombre;
        this.espVida = espVida;
        this.descAnat = descAnat;
        this.comonPat = comonPat;
        this.peligrosidad = peligrosidad;
        this.descComp = descComp;
        this.dieta = dieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEspVida() {
        return espVida;
    }

    public void setEspVida(int espVida) {
        this.espVida = espVida;
    }

    public String getDescAnat() {
        return descAnat;
    }

    public void setComonPat(String comonPat) {
        this.comonPat = comonPat;
    }

    public String getComonPat() {
        return comonPat;
    }

    public void setDescAnat(String descAnat) {
        this.descAnat = descAnat;
    }

    public int getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(int peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public String getDescComp() {
        return descComp;
    }

    public void setDescComp(String descComp) {
        this.descComp = descComp;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    
    
    
}
