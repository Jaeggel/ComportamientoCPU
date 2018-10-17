/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;
import Principal.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class VentanaHex extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public static DefaultTableModel modelo=null;
    DefaultTableModel modelo1=null;
    public static DefaultTableModel modelo2=null;
    public VentanaHex() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana Registro");
        this.setResizable(false);
        String cabecera[]={};
        String datos[][]={};
        String cabecera1[]={"Variable","Dato","PosCol","PosFi"};
        String datos1[][]={};
        modelo=new DefaultTableModel(datos1,cabecera1);
        //modelo1=new DefaultTableModel(datos,cabecera);
        modelo2=new DefaultTableModel();
        tablaInst.setModel(modelo2); 
        tablaValores.setModel(modelo); 
        listaTemp();
        gestDatos();
        tablaTemp();
        
    }
    public void listaTemp()
    {
        Object fila [] = new Object [Ingreso.modelo1.getSize()];
        Object fila1 [] = new Object [Ingreso.modelo1.getSize()];
        String aux="",aux1="",aux2="";
        int posV1=0;
        for (int i = 0; i < Ingreso.modelo1.getSize(); i++) 
        {    
            String cadInst=Ingreso.modelo1.getElementAt(i).toString();
            for (int j = 0; j < cadInst.length(); j++)
            { 
                if(cadInst.charAt(j)==' ')
                {
                    int pos=cadInst.indexOf(" ");        
                    aux=cadInst.substring(0, pos).trim();
                    posV1=cadInst.indexOf(",");
                    aux1=cadInst.substring(pos+1,posV1).trim();
                    aux2=cadInst.substring(posV1+1).trim();
                }    
            valorV(aux1);
            }
            fila1[i]="F"+(i);
            if(i==Ingreso.modelo1.getSize()-1)
            {
                fila[i]=codop(aux)+""+Integer.toHexString(valorC(aux1)+valorF(aux1))+""+Integer.toHexString(valorC(aux2)+valorF(aux2));
            }else
                fila[i]=codop(aux)+""+Integer.toHexString(valorC(aux1)+valorF(aux1))+""+Integer.toHexString(valorC(aux2)+valorF(aux2))+"F"+(i+1);
            
            
        }
        modelo2.addColumn("Código Instrucción",fila1);
        modelo2.addColumn("Instrucción",fila);
        
    }
    public void tablaTemp()
    {
        tablaMemoria.getTableHeader().setVisible(false);
        for (int i = 0; i < modelo.getRowCount(); i++) 
        {
            tablaMemoria.setValueAt(modelo.getValueAt(i, 1),Integer.parseInt(modelo.getValueAt(i,2).toString()),Integer.parseInt(modelo.getValueAt(i,3).toString()));
        }
    }
    public void gestDatos()
    {   
        
        for (int i=0;i<VentanaDec.modelo.getRowCount(); i++) 
        {
            Object fila [] = new Object [VentanaDec.modelo.getColumnCount()];
            for (int j=0; j<VentanaDec.modelo.getColumnCount(); j++)
            {
                fila[j] = VentanaDec.modelo.getValueAt(i,j);
            }
            modelo.addRow(fila);
        }
        for (int i = 0; i < modelo.getRowCount(); i++) 
        {
            tablaValores.setValueAt(Integer.toHexString(Integer.parseInt(VentanaDec.modelo.getValueAt(i,1).toString())),i,1);
        }
    }
    public int codop(String op)
    {
        int valor=0;
        if(op.equals("add") || op.equals("ADD"))
        {
            valor=1;
        }else
            if(op.equals("sub") || op.equals("SUB"))
            {
                valor=2;
            }
        else
            if(op.equals("mpy") || op.equals("MPY"))
            {
                valor=3;
            }
        else
            if(op.equals("div") || op.equals("DIV"))
            {
                valor=4;
            }
        else
            if(op.equals("load") || op.equals("LOAD"))
            {
                valor=5;
            }
        else
            if(op.equals("STOR") || op.equals("stor"))
            {
                valor=6;
            }
        return valor;
    }
    public int valorV (String var)
    {
        int val=0;
        for (int i = 0; i <Ingreso.dato.size(); i++) 
        {
           if(Ingreso.dato.get(i).getVar().equals(var))
           {
                val=Ingreso.dato.get(i).getValor();
           }
        }
        System.out.println("Valor: "+val);
    return val;    
    }
    public int valorC (String var)
    {
        int val=0;
        for (int i = 0; i <Ingreso.dato.size(); i++) 
        {
           if(Ingreso.dato.get(i).getVar().equals(var))
           {
                val=Ingreso.dato.get(i).getPosC();
           }
        }
        System.out.println("Valor: "+val);
    return val;    
    }
    public int valorF (String var)
    {
        int val=0;
        for (int i = 0; i <Ingreso.dato.size(); i++) 
        {
           if(Ingreso.dato.get(i).getVar().equals(var))
           {
                val=Ingreso.dato.get(i).getPosF();
           }
        }
        System.out.println("Valor: "+val);
    return val;    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaValores = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMemoria = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaInst = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(1347, 550));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Registro de Memoria  (HEXADECIMAL)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Pila de Instrucciones: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Valores Establecidos: ");

        tablaValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaValores.setEnabled(false);
        jScrollPane2.setViewportView(tablaValores);

        tablaMemoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6", "Título 7", "Título 8", "Título 9", "Título 10", "Título 11", "Título 12", "Título 13", "Título 14", "Título 15", "Título 16", "Título 17", "Título 18", "Título 19", "Título 20", "Título 21", "Título 22", "Título 23", "Título 24", "Título 25"
            }
        ));
        tablaMemoria.setEnabled(false);
        jScrollPane3.setViewportView(tablaMemoria);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Registros");

        tablaInst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaInst.setEnabled(false);
        jScrollPane4.setViewportView(tablaInst);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1369, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaBin vtn=new VentanaBin();
        vtn.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JTable tablaInst;
    public static javax.swing.JTable tablaMemoria;
    private javax.swing.JTable tablaValores;
    // End of variables declaration//GEN-END:variables
}
