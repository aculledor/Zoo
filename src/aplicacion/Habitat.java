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
public class Habitat {

    private String desHabitat;
    private int tam;
    private int aforo;
    private String condMant;
    private String medidasSeg;
    private String desTerreno;
    private String infraestructuras;
    private String tipoHabitat;
    private EquipoMantenimiento equipoMant;

    public Habitat(String desHabitat, int tam, int aforo, String condMant, String medidasSeg, String desTerreno, String infraestructuras, String tipoHabitat, EquipoMantenimiento equipoMant) {
        this.desHabitat = desHabitat;
        this.tam = tam;
        this.aforo = aforo;
        this.condMant = condMant;
        this.medidasSeg = medidasSeg;
        this.desTerreno = desTerreno;
        this.infraestructuras = infraestructuras;
        this.tipoHabitat = tipoHabitat;
        this.equipoMant = equipoMant;
    }

    public String getDesHabitat() {
        return desHabitat;
    }

    public void setDesHabitat(String desHabitat) {
        this.desHabitat = desHabitat;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getCondMant() {
        return condMant;
    }

    public void setCondMant(String condMant) {
        this.condMant = condMant;
    }

    public String getMedidasSeg() {
        return medidasSeg;
    }

    public void setMedidasSeg(String medidasSeg) {
        this.medidasSeg = medidasSeg;
    }

    public String getDesTerreno() {
        return desTerreno;
    }

    public void setDesTerreno(String desTerreno) {
        this.desTerreno = desTerreno;
    }

    public String getInfraestructuras() {
        return infraestructuras;
    }

    public void setInfraestructuras(String infraestructuras) {
        this.infraestructuras = infraestructuras;
    }

    public String getTipoHabitat() {
        return tipoHabitat;
    }

    public void setTipoHabitat(String tipoHabitat) {
        this.tipoHabitat = tipoHabitat;
    }

    public EquipoMantenimiento getEquipoMant() {
        return equipoMant;
    }

    public void setEquipoMant(EquipoMantenimiento equipoMant) {
        this.equipoMant = equipoMant;
    }
    
    
    
}
