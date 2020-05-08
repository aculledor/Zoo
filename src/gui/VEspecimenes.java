/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Habitat;

/**
 *
 * @author acull
 */
public class VEspecimenes extends javax.swing.JDialog {
    private VPrincipal padre;
    private FachadaAplicacion fa;
    private ModeloTablaEspecimenes mTablaEspec;
    
    /**
     * Creates new form VEspecimenes
     */
    public VEspecimenes(java.awt.Frame parent, aplicacion.FachadaAplicacion fa) {
        super(parent);
        this.setResizable(false);
        this.fa = fa;
        initComponents();
        this.padre = (VPrincipal) parent;   
        
        mTablaEspec = new ModeloTablaEspecimenes();
        tablaEspec.setModel(mTablaEspec);
        
        this.setTablaEspec();
        
        if(mTablaEspec.getRowCount()> 0){
            tablaEspec.setRowSelectionInterval(0, 0);
            
            fieldId.setText(Integer.toString(mTablaEspec.obtenerEjemplar(0).getIdentificador()));
            fieldEspecie.setText(mTablaEspec.obtenerEjemplar(0).getEspecie());
            fieldHabitat.setText(mTablaEspec.obtenerEjemplar(0).getHabitat());
        }
        
        //actualizarEspecimenes();
    }
    
    public final void setTablaEspec(){
        mTablaEspec.setFilas(fa.consultarEspecimenes());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        etiquetaBuscaId = new javax.swing.JLabel();
        etiquetaBuscaEspecie = new javax.swing.JLabel();
        etiquetaBuscaHabitat = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        fieldBuscarHabitat = new javax.swing.JTextField();
        fieldBuscarEspecie = new javax.swing.JTextField();
        fieldBuscarId = new javax.swing.JTextField();
        buscarEnTratamiento = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspec = new javax.swing.JTable();
        fieldId = new javax.swing.JTextField();
        fieldEspecie = new javax.swing.JTextField();
        fieldHabitat = new javax.swing.JTextField();
        etiquetaId = new javax.swing.JLabel();
        etiquetaEspecie = new javax.swing.JLabel();
        etiquetaHabitat = new javax.swing.JLabel();
        etiquetaVeterinario = new javax.swing.JLabel();
        fieldVeterinario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        botonNuevo = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonDetalles = new javax.swing.JButton();

        jButton5.setText("jButton5");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaBuscaId.setText("Id:");

        etiquetaBuscaEspecie.setText("Especie:");

        etiquetaBuscaHabitat.setText("Hábitat:");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        buscarEnTratamiento.setText("En tratamiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(etiquetaBuscaId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaBuscaEspecie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaBuscaHabitat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBuscarHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarEnTratamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaBuscaId)
                    .addComponent(etiquetaBuscaEspecie)
                    .addComponent(etiquetaBuscaHabitat)
                    .addComponent(botonBuscar)
                    .addComponent(fieldBuscarHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarEnTratamiento))
                .addGap(19, 19, 19))
        );

        tablaEspec.setModel(new ModeloTablaEspecimenes());
        tablaEspec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEspecMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEspec);

        etiquetaId.setText("Id:");

        etiquetaEspecie.setText("Especie");

        etiquetaHabitat.setText("Hábitat");

        etiquetaVeterinario.setText("Veterinario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(etiquetaId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(etiquetaEspecie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(etiquetaHabitat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(etiquetaVeterinario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaHabitat)
                        .addComponent(fieldEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaEspecie)
                        .addComponent(etiquetaVeterinario)
                        .addComponent(fieldVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaId))))
        );

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonDetalles.setText("Detalles");
        botonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonDetalles)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonNuevo)
                        .addComponent(botonBorrar)
                        .addComponent(botonGuardar)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        buscarEspecimenes();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        ModeloTablaEspecimenes m;
        m=(ModeloTablaEspecimenes) tablaEspec.getModel();

    
        fa.borrarEspecimen(m.obtenerEjemplar(tablaEspec.getSelectedRow()).getIdentificador(),m.obtenerEjemplar(tablaEspec.getSelectedRow()).getEspecie());
        buscarEspecimenes();
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetallesActionPerformed
        ModeloTablaEspecimenes m;
        m=(ModeloTablaEspecimenes) tablaEspec.getModel();
        fa.visualizarDetallesEspecimen(padre,m.obtenerEjemplar(tablaEspec.getSelectedRow()));
    }//GEN-LAST:event_botonDetallesActionPerformed

    private void tablaEspecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspecMouseClicked
        ModeloTablaEspecimenes m;
        m=(ModeloTablaEspecimenes) tablaEspec.getModel();
        
        botonBorrar.setEnabled(true);
        botonDetalles.setEnabled(true);
       
        fieldId.setText(Integer.toString(m.obtenerEjemplar(tablaEspec.getSelectedRow()).getIdentificador()));
        fieldEspecie.setText(m.obtenerEjemplar(tablaEspec.getSelectedRow()).getEspecie());
        fieldHabitat.setText(m.obtenerEjemplar(tablaEspec.getSelectedRow()).getHabitat());
        fieldVeterinario.setText(m.obtenerEjemplar(tablaEspec.getSelectedRow()).getVeterinario());
    }//GEN-LAST:event_tablaEspecMouseClicked

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        tablaEspec.clearSelection();
        
        botonBorrar.setEnabled(false);
        botonDetalles.setEnabled(false);
        botonGuardar.setEnabled(true);

        fieldId.setText("");
        fieldEspecie.setText("");
        fieldHabitat.setText("");
        fieldVeterinario.setText("");
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(!fieldId.getText().equals("") && !fieldEspecie.getText().equals("") && !fieldHabitat.getText().equals("")){
            if(tablaEspec.getSelectedRow()==-1){
                if(puedeAnhadirse(fieldEspecie.getText(),fieldHabitat.getText())){
                    fa.nuevoEspecimen(Integer.parseInt(fieldId.getText()),fieldEspecie.getText(),fieldHabitat.getText(),
                            fieldVeterinario.getText());
                }
            }
            else{
                ModeloTablaEspecimenes mte = (ModeloTablaEspecimenes) tablaEspec.getModel();
                if(puedeActualizarse(mte.obtenerEjemplar(tablaEspec.getSelectedRow()).getEspecie(),mte.obtenerEjemplar(tablaEspec.getSelectedRow()).getHabitat() ,fieldHabitat.getText())){
                    fa.actualizarEspecimen(mte.obtenerEjemplar(tablaEspec.getSelectedRow()).getIdentificador(),Integer.parseInt(fieldId.getText()),mte.obtenerEjemplar(tablaEspec.getSelectedRow()).getEspecie(),fieldHabitat.getText(),
                            fieldVeterinario.getText());
                }
            }
            buscarEspecimenes();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonDetalles;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JCheckBox buscarEnTratamiento;
    private javax.swing.JLabel etiquetaBuscaEspecie;
    private javax.swing.JLabel etiquetaBuscaHabitat;
    private javax.swing.JLabel etiquetaBuscaId;
    private javax.swing.JLabel etiquetaEspecie;
    private javax.swing.JLabel etiquetaHabitat;
    private javax.swing.JLabel etiquetaId;
    private javax.swing.JLabel etiquetaVeterinario;
    private javax.swing.JTextField fieldBuscarEspecie;
    private javax.swing.JTextField fieldBuscarHabitat;
    private javax.swing.JTextField fieldBuscarId;
    private javax.swing.JTextField fieldEspecie;
    private javax.swing.JTextField fieldHabitat;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldVeterinario;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEspec;
    // End of variables declaration//GEN-END:variables

    public void buscarEspecimenes(){
        ModeloTablaEspecimenes m;

        m=(ModeloTablaEspecimenes) tablaEspec.getModel();
        m.setFilas(fa.obtenerEspecimenes((fieldBuscarId.getText().isEmpty())?null:Integer.parseInt(fieldBuscarId.getText()), fieldBuscarEspecie.getText(), fieldBuscarHabitat.getText(), buscarEnTratamiento.isSelected()));
        if (m.getRowCount() > 0) {
            tablaEspec.setRowSelectionInterval(0, 0);
            botonBorrar.setEnabled(true);
            botonGuardar.setEnabled(true);
            botonDetalles.setEnabled(true);

            fieldId.setText(Integer.toString(m.obtenerEjemplar(0).getIdentificador()));
            fieldEspecie.setText(m.obtenerEjemplar(0).getEspecie());
            fieldHabitat.setText(m.obtenerEjemplar(0).getHabitat());
            fieldHabitat.setText(m.obtenerEjemplar(0).getVeterinario());
        }
        else{
            botonBorrar.setEnabled(false);
            botonGuardar.setEnabled(false);
            botonDetalles.setEnabled(false);

            fieldId.setText("");
            fieldEspecie.setText("");
            fieldHabitat.setText("");
            fieldVeterinario.setText("");
        }
    }
    
    boolean puedeAnhadirse(String especie, String habitat){
        int ocupacion=fa.recuperarOcupacion(habitat);
        
        if(ocupacion < fa.aforoMaximo(habitat)){
            if(fa.puedeContener(especie, habitat)){
                if(fa.isMonoespecie(habitat)){
                    if(ocupacion!=0){
                        if(fa.compararEspecies(especie,habitat)){
                            return true;
                        }
                    }
                    else{
                        return true;
                    }
                }
                else
                    return true;
            }
        }
        
        return false;
    }
    
    boolean puedeActualizarse(String especie,String habitatViejo, String habitatNuevo){
        
        if(habitatViejo.equalsIgnoreCase(habitatNuevo)){
            return true;
        }
        int ocupacion=fa.recuperarOcupacion(habitatNuevo);
        
        if(ocupacion < fa.aforoMaximo(habitatNuevo)){
            if(fa.puedeContener(especie, habitatNuevo)){
                if(fa.isMonoespecie(habitatNuevo)){
                    if(ocupacion!=0){
                        if(fa.compararEspecies(especie,habitatNuevo)){
                            return true;
                        }
                    }
                    else{
                        return true;
                    }
                }
                else
                    return true;
            }
        }
        
        return false;
    }
}
