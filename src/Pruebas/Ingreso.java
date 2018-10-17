/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Principal.*;
import Principal.*;
import static Principal.Ingreso.modelo1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Pancho
 */
public class Ingreso extends javax.swing.JFrame {
    String variable;
    int valor;
    ArrayList<Datos> dato = new ArrayList<Datos>();
    ArrayList<DatosInst> datoI = new ArrayList<DatosInst>();
    public static DefaultListModel modelo = null;
    public static DefaultListModel modelo1 = null;

    public Ingreso() {

        initComponents();
        //variable=txtVariable.getText();
        //valor=Integer.valueOf(txtValorVar.getText());  
        this.setLocationRelativeTo(null);
        modelo = new DefaultListModel();
        modelo1 = new DefaultListModel();
        
        
            

    }

    public void gestDatos()
    {      
        ArrayList<Datos> dato = new ArrayList<Datos>();
         
        Datos aux=new Datos();        
        aux.setVar(txtVariable.getText());
        aux.setValor(Integer.parseInt(txtValorVar.getText())); 
        //aux.setPosC(rand());
        //aux.setPosF(rand());
        dato.add(aux);
    }
    public int rand()
    {
        int rand=0;
        rand=(int) Math.floor(Math.random()*30);//30-300
        if(rand>24)//255
        {
            rand-=5;//45
        }
        //System.out.println(rand);
        return rand;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInstrucciones = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaInstrucciones = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaVariables = new javax.swing.JList();
        txtVariable = new javax.swing.JTextField();
        txtInstruc = new javax.swing.JTextField();
        btnAñadirInstrucciones = new javax.swing.JButton();
        btnAñadirVariables = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtValorVar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOP = new javax.swing.JTextField();
        txtVar1 = new javax.swing.JTextField();
        txtVar2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ingreso de variables:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Instrucciones:");

        btnInstrucciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });

        btnProcesar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProcesar.setText("Procesar");
        btnProcesar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaInstrucciones);

        jScrollPane1.setViewportView(ListaVariables);

        txtVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVariableActionPerformed(evt);
            }
        });

        btnAñadirInstrucciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadirInstrucciones.setText("Añadir");
        btnAñadirInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirInstruccionesActionPerformed(evt);
            }
        });

        btnAñadirVariables.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadirVariables.setText("Añadir");
        btnAñadirVariables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirVariablesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("=");

        txtValorVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVarActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Operación: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Variable 1:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Variable 2: ");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText(">>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtValorVar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtVar2)
                                .addComponent(txtInstruc, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtOP)
                                .addComponent(txtVar1)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAñadirInstrucciones)
                            .addComponent(btnAñadirVariables)
                            .addComponent(jButton1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnInstrucciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProcesar)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirVariables)
                    .addComponent(jLabel3)
                    .addComponent(txtValorVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInstruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirInstrucciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtVar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInstrucciones)
                    .addComponent(btnProcesar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    private void btnAñadirVariablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirVariablesActionPerformed
        variable=txtVariable.getText();
        valor=Integer.parseInt(txtValorVar.getText());
        String nombre=variable+"="+valor;
        modelo.addElement(nombre);
        
        
        Datos aux=new Datos();
        
        aux.setVar(variable);
        aux.setValor(valor);
        aux.setPosC(rand());
        aux.setPosF(rand());
        dato.add(aux);
        ListaVariables.setModel(modelo);
        
        
     
    }//GEN-LAST:event_btnAñadirVariablesActionPerformed

    private void btnAñadirInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirInstruccionesActionPerformed
        String nombre = txtInstruc.getText();
        modelo1.addElement(nombre);
        DatosInst aux=new DatosInst();
        
        
        
        
        listaInstrucciones.setModel(modelo1);
        txtInstruc.setText("");
        txtOP.setText("");
        txtVar1.setText("");
        txtVar2.setText("");

        
    }//GEN-LAST:event_btnAñadirInstruccionesActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        VentanaDec obj = new VentanaDec();
        obj.setVisible(true);

    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVariableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVariableActionPerformed

    private void txtValorVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          
        for (int i = 0; i <dato.size(); i++) 
        {
            System.out.println(dato.get(i));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String cadInst=txtInstruc.getText();
        String aux="",aux1="",aux2="";
        int posV1=0;
        for (int i = 0; i < cadInst.length(); i++) 
        {
            if(cadInst.charAt(i)==' ')
            {
                int pos=cadInst.indexOf(" ");        
                aux=cadInst.substring(0, pos).trim();
                posV1=cadInst.indexOf(",");
                aux1=cadInst.substring(pos+1,posV1).trim();
                aux2=cadInst.substring(posV1+1).trim();
            }
        }
        txtOP.setText(aux);
        txtVar1.setText(aux1);
        txtVar2.setText(aux2);
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListaVariables;
    private javax.swing.JButton btnAñadirInstrucciones;
    private javax.swing.JButton btnAñadirVariables;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaInstrucciones;
    private javax.swing.JTextField txtInstruc;
    private javax.swing.JTextField txtOP;
    private javax.swing.JTextField txtValorVar;
    private javax.swing.JTextField txtVar1;
    private javax.swing.JTextField txtVar2;
    private javax.swing.JTextField txtVariable;
    // End of variables declaration//GEN-END:variables

     public void listaInstr(List instr) {
        for (int i = 0; i < modelo1.getSize(); i++) {
            
            System.out.println("intruccion #" + i +" "+listaInstrucciones.getModel().getElementAt(i));
            instr.set(i, listaInstrucciones.getModel().getElementAt(i));
        }
        
    }

}
