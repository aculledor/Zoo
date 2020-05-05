/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.HabilidadMagica;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nosu
 */
public class ModeloTablaHabilidadesMagicas extends AbstractTableModel{
    
    private java.util.List<HabilidadMagica> propiedades;

    public ModeloTablaHabilidadesMagicas() {
        this.propiedades = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return propiedades.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Nombre";
                break;
            case 1:
                nombre = "Efectos";
                break;
            case 2:
                nombre = "Aplicaciones";
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
                resultado = propiedades.get(row).getNombre();
                break;
            case 1:
                resultado = propiedades.get(row).getEfectos();
                break;
            case 2:
                resultado = propiedades.get(row).getAplicaciones();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {

            case 2:
                propiedades.get(row).setEfectos((String)v);
                break;
            case 3:
                propiedades.get(row).setAplicaciones((String) v);
                break;
        }
    }

    public void setFilas(java.util.List<HabilidadMagica> ejemplares) {
        this.propiedades = ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(HabilidadMagica e) {
        this.propiedades.add(e);
        fireTableRowsInserted(this.propiedades.size() - 1, this.propiedades.size() - 1);
    }

    public void borrarEjemplar(int indice) {
        this.propiedades.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<HabilidadMagica> getFilas() {
        return this.propiedades;
    }

    public HabilidadMagica obtenerEjemplar(int i) {
        return this.propiedades.get(i);
    }
    
}
