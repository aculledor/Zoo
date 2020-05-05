/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Especie;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nosu
 */
public class ModeloTablaEspecies extends AbstractTableModel{
    
    private java.util.List<Especie> especies;

    public ModeloTablaEspecies() {
        this.especies = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return especies.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Nombre";
                break;
            case 1:
                nombre = "Esperanza Vida";
                break;
            case 2:
                nombre = "Peligrosidad";
                break;
            case 3:
                nombre = "Anatomia";
                break;
            case 4:
                nombre = "Comportamiento";
                break;
            case 5:
                nombre = "Dieta";
                break;
            case 6:
                nombre = "Patalogias";
                break;
            
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase;

        switch (col) {
            case 1:
                clase = java.lang.Integer.class;
                break;
            case 2:
                clase = java.lang.Integer.class;
                break;
            default:
                clase = java.lang.String.class;
        }
        return clase;
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
                resultado = especies.get(row).getNombre();
                break;
            case 1:
                resultado = especies.get(row).getEspVida();
                break;
            case 2:
                resultado = especies.get(row).getPeligrosidad();
                break;
            case 3:
                resultado = especies.get(row).getDescAnat();
                break;
            case 4:
                resultado = especies.get(row).getDescComp();
                break;
            case 5:
                resultado = especies.get(row).getDieta();
                break;
            case 6:
                resultado = especies.get(row).getComonPat();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            case 1:
                especies.get(row).setEspVida((Integer)v);
                break;
            case 2:
                especies.get(row).setPeligrosidad((Integer)v);
                break;
            case 3:
                especies.get(row).setDescAnat((String) v);
                break;
            case 4:
                especies.get(row).setDescComp((String) v);
                break;
            case 5:
                especies.get(row).setDieta((String) v);
                break;
            case 6:
                especies.get(row).setComonPat((String) v);
                break;
        }
    }

    public void setFilas(java.util.List<Especie> ejemplares) {
        this.especies = ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Especie e) {
        this.especies.add(e);
        fireTableRowsInserted(this.especies.size() - 1, this.especies.size() - 1);
    }

    public void borrarEjemplar(int indice) {
        this.especies.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Especie> getFilas() {
        return this.especies;
    }

    public Especie obtenerEjemplar(int i) {
        return this.especies.get(i);
    }
    
}
