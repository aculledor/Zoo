/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Riesgo;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nosu
 */
public class ModeloTablaRiesgos extends AbstractTableModel{
    
    private java.util.List<Riesgo> riesgos;

    public ModeloTablaRiesgos() {
        this.riesgos = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return riesgos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Tipo";
                break;
            case 1:
                nombre = "Tratamiento";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        
        return java.lang.String.class;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col > 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = riesgos.get(row).getTipo();
                break;
            case 1:
                resultado = riesgos.get(row).getTratamiento();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {

            case 2:
                riesgos.get(row).setTratamiento((String)v);
                break;
        }
    }

    public void setFilas(java.util.List<Riesgo> ejemplares) {
        this.riesgos = ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Riesgo e) {
        this.riesgos.add(e);
        fireTableRowsInserted(this.riesgos.size() - 1, this.riesgos.size() - 1);
    }

    public void borrarEjemplar(int indice) {
        this.riesgos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Riesgo> getFilas() {
        return this.riesgos;
    }

    public Riesgo obtenerEjemplar(int i) {
        return this.riesgos.get(i);
    }
    
}
