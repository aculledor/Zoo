/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Protocolo;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nosu
 */
public class ModeloTablaProtocolos extends AbstractTableModel{
    
    private java.util.List<Protocolo> protocolos;

    public ModeloTablaProtocolos() {
        this.protocolos = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return protocolos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Id";
                break;
            case 1:
                nombre = "Descripcion";
                break;
            case 2:
                nombre = "Equipamiento";
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
                resultado = protocolos.get(row).getIdentificador();
                break;
            case 1:
                resultado = protocolos.get(row).getDescripcion();
                break;
            case 2:
                resultado = protocolos.get(row).getEquipamiento();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {

            case 2:
                protocolos.get(row).setDescripcion((String)v);
                break;
            case 3:
                protocolos.get(row).setEquipamiento((String)v);
                break;
        }
    }

    public void setFilas(java.util.List<Protocolo> ejemplares) {
        this.protocolos = ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Protocolo e) {
        this.protocolos.add(e);
        fireTableRowsInserted(this.protocolos.size() - 1, this.protocolos.size() - 1);
    }

    public void borrarEjemplar(int indice) {
        this.protocolos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Protocolo> getFilas() {
        return this.protocolos;
    }

    public Protocolo obtenerEjemplar(int i) {
        return this.protocolos.get(i);
    }
    
}
