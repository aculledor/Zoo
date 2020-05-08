/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Especimen;
import aplicacion.FachadaAplicacion;

/**
 *
 * @author acull
 */
public class VEspecimen extends javax.swing.JDialog {
    private VPrincipal padre;
    private FachadaAplicacion fa;
    private ModeloTablaTratamientos mTablaTrat;
    private ModeloTablaEspecimenesReducido mTablaReduc;
    private Especimen especimen;
    
    /**
     * Creates new form VEspecimenes
     */
    public VEspecimen(java.awt.Frame parent, aplicacion.FachadaAplicacion fa, Especimen espe) {
        super(parent);
        this.fa = fa;
        this.setResizable(false);
        initComponents();
        this.padre = (VPrincipal) parent; 
        
        
        this.especimen=espe;
        
        //Tabla tratamientos
        mTablaTrat = new ModeloTablaTratamientos();
        tablaTratamientos.setModel(mTablaTrat);
        
        this.setTablaTrat();
        
        if(mTablaTrat.getRowCount()> 0){
            tablaTratamientos.setRowSelectionInterval(0, 0);         
            
            ModeloTablaTratamientos m;
            m=(ModeloTablaTratamientos) tablaTratamientos.getModel();
            
            fieldCuidador.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getCuidador());
            fieldMedicacion.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getMedicamentos());
            fieldFechaInicio.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getFechaInicio());
            fieldFechaFin.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getFechaFin());
        }
        
        //Tabla Especimenes Reducidos
        mTablaReduc = new ModeloTablaEspecimenesReducido();
        tablaReduc.setModel(mTablaReduc);
        
        this.setTablaReduc();
        this.fieldNombreHabitat.setText("Habitat "+especimen.getHabitat());
        this.fielDescripcionHabitat.setText(fa.consultarDescHabitat(especimen.getHabitat()));
        this.fieldInfraestrucHabitat.setText(fa.consultarInfrHabitat(especimen.getHabitat()));
        
        if(mTablaReduc.getRowCount()> 0){
            tablaReduc.setRowSelectionInterval(0, 0);
        }
        
        //Historial Medico
        this.fieldHistorialMedico.setText(especimen.getHistorialMedico());
    }
    
    public final void setTablaTrat(){
        mTablaTrat.setFilas(fa.consultarTratamientos(especimen));
    }
    
    public final void setTablaReduc(){
        mTablaReduc.setFilas(fa.consultarCompHabitat(especimen));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        vHabitat = new javax.swing.JPanel();
        fieldNombreHabitat = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReduc = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        fielDescripcionHabitat = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fieldInfraestrucHabitat = new javax.swing.JTextArea();
        vDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTratamientos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        botonNuevo = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        fieldCuidador = new javax.swing.JTextField();
        etiquetaCuidador = new javax.swing.JLabel();
        etiquetaMedicacion = new javax.swing.JLabel();
        fieldMedicacion = new javax.swing.JTextField();
        etiquetaFechaInicio = new javax.swing.JLabel();
        etiquetaFechaFin = new javax.swing.JLabel();
        fieldFechaFin = new javax.swing.JTextField();
        fieldFechaInicio = new javax.swing.JTextField();
        vHistorial = new javax.swing.JPanel();
        textHistorial = new javax.swing.JScrollPane();
        fieldHistorialMedico = new javax.swing.JTextArea();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fieldNombreHabitat.setEditable(false);
        fieldNombreHabitat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        fieldNombreHabitat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldNombreHabitat.setText("Nombre Habitat");
        fieldNombreHabitat.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Compañeros de Hábitat");

        tablaReduc.setModel(new ModeloTablaEspecimenesReducido());
        jScrollPane2.setViewportView(tablaReduc);

        fielDescripcionHabitat.setEditable(false);
        fielDescripcionHabitat.setColumns(20);
        fielDescripcionHabitat.setRows(5);
        jScrollPane3.setViewportView(fielDescripcionHabitat);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Descripción del Hábitat");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Infraestructuras del Hábitat");

        fieldInfraestrucHabitat.setEditable(false);
        fieldInfraestrucHabitat.setColumns(20);
        fieldInfraestrucHabitat.setRows(5);
        jScrollPane4.setViewportView(fieldInfraestrucHabitat);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 205, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );

        javax.swing.GroupLayout vHabitatLayout = new javax.swing.GroupLayout(vHabitat);
        vHabitat.setLayout(vHabitatLayout);
        vHabitatLayout.setHorizontalGroup(
            vHabitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(vHabitatLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(fieldNombreHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vHabitatLayout.setVerticalGroup(
            vHabitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vHabitatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fieldNombreHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hábitat", vHabitat);

        tablaTratamientos.setModel(new ModeloTablaTratamientos());
        tablaTratamientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTratamientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTratamientos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 778, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        etiquetaCuidador.setText("Cuidador:");

        etiquetaMedicacion.setText("Medicación:");

        etiquetaFechaInicio.setText("Fecha Inicio:");

        etiquetaFechaFin.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaFechaInicio)
                    .addComponent(etiquetaCuidador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(fieldCuidador))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaMedicacion)
                    .addComponent(etiquetaFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldMedicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(fieldFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCuidador)
                    .addComponent(fieldCuidador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaMedicacion)
                    .addComponent(fieldMedicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaFechaInicio)
                        .addComponent(fieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaFechaFin)
                        .addComponent(fieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonGuardar))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout vDatosLayout = new javax.swing.GroupLayout(vDatos);
        vDatos.setLayout(vDatosLayout);
        vDatosLayout.setHorizontalGroup(
            vDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                .addContainerGap())
        );
        vDatosLayout.setVerticalGroup(
            vDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tratamientos", vDatos);

        fieldHistorialMedico.setColumns(20);
        fieldHistorialMedico.setRows(5);
        textHistorial.setViewportView(fieldHistorialMedico);

        javax.swing.GroupLayout vHistorialLayout = new javax.swing.GroupLayout(vHistorial);
        vHistorial.setLayout(vHistorialLayout);
        vHistorialLayout.setHorizontalGroup(
            vHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                .addContainerGap())
        );
        vHistorialLayout.setVerticalGroup(
            vHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Historial Médico", vHistorial);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaTratamientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTratamientosMouseClicked
        ModeloTablaTratamientos m;
        m=(ModeloTablaTratamientos) tablaTratamientos.getModel();
       
        fieldCuidador.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getCuidador());
        fieldMedicacion.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getMedicamentos());
        fieldFechaInicio.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getFechaInicio());
        fieldFechaFin.setText(m.obtenerEjemplar(tablaTratamientos.getSelectedRow()).getFechaFin());
    }//GEN-LAST:event_tablaTratamientosMouseClicked

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        tablaTratamientos.clearSelection();
      
        fieldCuidador.setText("");
        fieldMedicacion.setText("");
        fieldFechaInicio.setText("");
        fieldFechaFin.setText("");
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(tablaTratamientos.getSelectedRow()==-1){
            fa.nuevoTratamiento(especimen, fieldCuidador.getText(),fieldMedicacion.getText(), fieldFechaFin.getText());
            mTablaTrat.setFilas(fa.consultarTratamientos(especimen));
        }
        else{
            fa.actualizarTratamiento(especimen, fieldCuidador.getText(),fieldMedicacion.getText(), fieldFechaInicio.getText(), fieldFechaFin.getText());
            mTablaTrat.setFilas(fa.consultarTratamientos(especimen));
        }
        fa.consultarTratamientos(especimen);
        fieldCuidador.setText("");
        fieldMedicacion.setText("");
        fieldFechaInicio.setText("");
        fieldFechaFin.setText("");
    }//GEN-LAST:event_botonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JLabel etiquetaCuidador;
    private javax.swing.JLabel etiquetaFechaFin;
    private javax.swing.JLabel etiquetaFechaInicio;
    private javax.swing.JLabel etiquetaMedicacion;
    private javax.swing.JTextArea fielDescripcionHabitat;
    private javax.swing.JTextField fieldCuidador;
    private javax.swing.JTextField fieldFechaFin;
    private javax.swing.JTextField fieldFechaInicio;
    private javax.swing.JTextArea fieldHistorialMedico;
    private javax.swing.JTextArea fieldInfraestrucHabitat;
    private javax.swing.JTextField fieldMedicacion;
    private javax.swing.JTextField fieldNombreHabitat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaReduc;
    private javax.swing.JTable tablaTratamientos;
    private javax.swing.JScrollPane textHistorial;
    private javax.swing.JPanel vDatos;
    private javax.swing.JPanel vHabitat;
    private javax.swing.JPanel vHistorial;
    // End of variables declaration//GEN-END:variables
}
