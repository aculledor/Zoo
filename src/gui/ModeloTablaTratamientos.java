/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Tratamiento;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acull
 */
public class ModeloTablaTratamientos  extends AbstractTableModel {

    private java.util.List<Tratamiento> tratamientos;

    public ModeloTablaTratamientos() {
        this.tratamientos = new java.util.ArrayList<Tratamiento>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return tratamientos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Cuidador";
                break;
            case 1:
                nombre = "Medicamentos";
                break;
            case 2:
                nombre = "Fecha Inicio";
                break;
            case 3:
                nombre = "Fecha Final";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
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
                resultado = tratamientos.get(row).getCuidador();
                break;
            case 1:
                resultado = tratamientos.get(row).getMedicamentos();
                break;
            case 2:
                resultado = tratamientos.get(row).getFechaInicio();
                break;
            case 3:
                resultado = tratamientos.get(row).getFechaFin();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            case 1:
                tratamientos.get(row).setMedicamentos((String)v);
                break;
        }
    }

    public void setFilas(java.util.List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
        fireTableDataChanged();
    }

    public java.util.List<Tratamiento> getFilas() {
        return this.tratamientos;
    }

    public Tratamiento obtenerEjemplar(int i) {
        return this.tratamientos.get(i);
    }
    
}
