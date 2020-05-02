/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Especimen;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaEspecimenes extends AbstractTableModel {

    private java.util.List<Especimen> especimenes;

    public ModeloTablaEspecimenes() {
        this.especimenes = new java.util.ArrayList<Especimen>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return especimenes.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Identificador";
                break;
            case 1:
                nombre = "Especie";
                break;
            case 2:
                nombre = "Hábitat";
                break;
            case 3:
                nombre = "Veterinario";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.Integer.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.String.class;
                break;
            case 3:
                clase = java.lang.String.class;
                break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col > 0;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = especimenes.get(row).getIdentificador();
                break;
            case 1:
                resultado = especimenes.get(row).getEspecie();
                break;
            case 2:
                resultado = especimenes.get(row).getHabitat();
                break;
            case 3:
                resultado = especimenes.get(row).getVeterinario();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            case 1:
                especimenes.get(row).setEspecie((String)v);
                break;
            case 2:
                especimenes.get(row).setHabitat((String) v);
                break;
            case 3:
                especimenes.get(row).setVeterinario((String) v);
                break;
        }
    }

    public void setFilas(java.util.List<Especimen> ejemplares) {
        this.especimenes = ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Especimen e) {
        this.especimenes.add(e);
        fireTableRowsInserted(this.especimenes.size() - 1, this.especimenes.size() - 1);
    }

    public void borrarEjemplar(int indice) {
        this.especimenes.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Especimen> getFilas() {
        return this.especimenes;
    }

    public Especimen obtenerEjemplar(int i) {
        return this.especimenes.get(i);
    }
}
