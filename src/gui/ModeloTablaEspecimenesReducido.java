/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Especimen;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acull
 */
public class ModeloTablaEspecimenesReducido extends AbstractTableModel {

    private java.util.List<Especimen> especimenes;

    public ModeloTablaEspecimenesReducido() {
        this.especimenes = new java.util.ArrayList<Especimen>();
    }

    public int getColumnCount() {
        return 2;
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
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
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
        }
        return resultado;
    }

    public void setFilas(java.util.List<Especimen> ejemplares) {
        this.especimenes = ejemplares;
        fireTableDataChanged();
    }

    public java.util.List<Especimen> getFilas() {
        return this.especimenes;
    }

    public Especimen obtenerEjemplar(int i) {
        return this.especimenes.get(i);
    }
}
