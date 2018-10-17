/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Principal.*;
import static Principal.VentanaHex.modelo2;
import static Principal.VentanaBin.textoABinario;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import panamahitek.Arduino.PanamaHitek_Arduino;

/**
 *
 * @author Francisco
 */
public class VentanaSalida extends javax.swing.JFrame {
    private int cont=0;
    
     PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
    Controls c = new Controls();
    
    public VentanaSalida() {
        initComponents();
        getPorts();
         
    }
    
    public void listaTemp()
    {
        Object fila [] = new Object [VentanaHex.modelo2.getRowCount()];
        Object fila1 [] = new Object [VentanaHex.modelo2.getRowCount()];
        for (int i = 0; i < VentanaHex.modelo2.getRowCount(); i++) 
        {    
            fila1[i]=VentanaHex.modelo2.getValueAt(i, 0);
            fila[i]=textoABinario(VentanaHex.modelo2.getValueAt(i, 1).toString());
        }
        modelo2.addColumn("Código Instrucción",fila1);
        modelo2.addColumn("Instrucción",fila);
    }
    
    public int calcular(int cod,String v1, String v2){
        VentanaHex obj=new VentanaHex();
        int vp1,vp2,pc,pf,acum;
        
        vp1=Rdato(v1,VentanaDec.modelo);
        vp2=Rdato(v2,VentanaDec.modelo);
        
        pc=obj.valorC(v1);
        pf=obj.valorF(v1);
        
        System.out.println(cod);
       
        System.out.println(vp1);
        System.out.println(vp2);
        
        System.out.println(pc);
        System.out.println(pf);
        switch (cod)
        {
            case 0:
                
                    vp1=vp2;
                    VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);
                break;
            case 1:
                
                    vp1=vp1+vp2;
                    VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);

                break;
            case 2:
                vp1=vp1-vp2;
                    VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);

                break;
            case 3:
                vp1=vp1*vp2;
                VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);

                break;
            case 4:
                if(vp2==0){
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE DIVIDIR PARA CERO");
                }else{
                    vp1=vp1/vp2;
                VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);
                }
                break;
            case 5:
                acum=vp1;
               VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);
                break;
            case 6:
                vp1=vp2;
               VentanaDec.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaHex.tablaMemoria.setValueAt(vp1, pc, pf);
                    VentanaBin.tablaMemoria.setValueAt(vp1, pc, pf);
                    updateTabla(v1, vp1, VentanaDec.modelo);
                    updateTabla(v1, vp1, VentanaHex.modelo);
                    updateTabla(v1, vp1, VentanaBin.modelo);
                break;
            

        }
        return vp1;
    
    }
    public void updateTabla(String var,int val,DefaultTableModel modelo)
    {
        System.out.println(var);
        for (int i=0;i<modelo.getRowCount(); i++) 
        {
            if(modelo.getValueAt(i, 0).toString().equals(var))
            {
                System.out.println(modelo.getValueAt( i, 1));
                modelo.setValueAt(val, i, 1);
                System.out.println("----");
                System.out.println(modelo.getValueAt( i, 1));
            }
        }
    }
    
    public int Rdato(String var,DefaultTableModel modelo)
    {
        System.out.println(var);
        int dat=0;
        for (int i=0;i<modelo.getRowCount(); i++) 
        {
            if(modelo.getValueAt(i, 0).toString().equals(var))
            {
                dat=Integer.parseInt(modelo.getValueAt( i, 1).toString());
               
                System.out.println("----");
                System.out.println(dat);
                
            }
        }
        return dat;
    }
    
    private static String asciiToHex(String asciiValue)
{
    char[] chars = asciiValue.toCharArray();
    StringBuffer hex = new StringBuffer();
    for (int i = 0; i < chars.length; i++)
    {
        hex.append(Integer.toHexString((int) chars[i]));
    }
    return hex.toString();
}   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMAR = new javax.swing.JTextField();
        txtMBR = new javax.swing.JTextField();
        txtPC = new javax.swing.JTextField();
        txtIR = new javax.swing.JTextField();
        txtAC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnDI = new javax.swing.JButton();
        btnCO = new javax.swing.JButton();
        btnFO = new javax.swing.JButton();
        btnWO = new javax.swing.JButton();
        txtSHexa = new javax.swing.JTextField();
        txtSdecimal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBusGrant = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        btnEI = new javax.swing.JButton();
        txtCO = new javax.swing.JTextField();
        txtOP1 = new javax.swing.JTextField();
        txtOP2 = new javax.swing.JTextField();
        txtSI = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonEncender2 = new javax.swing.JButton();
        jButtonApagar2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxPorts = new javax.swing.JComboBox();
        jButtonRefresh = new javax.swing.JButton();
        jButtonConectar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMAR.setEditable(false);

        txtMBR.setEditable(false);

        txtPC.setEditable(false);

        txtIR.setEditable(false);

        txtAC.setEditable(false);

        jLabel1.setText("MAR:");

        jLabel2.setText("MBR:");

        jLabel3.setText("PC:");

        jLabel4.setText("IR:");

        jLabel5.setText("AC:");

        btnCargar.setText("FI");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnDI.setText("DI");
        btnDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIActionPerformed(evt);
            }
        });

        btnCO.setText("CO");
        btnCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOActionPerformed(evt);
            }
        });

        btnFO.setText("FO");
        btnFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFOActionPerformed(evt);
            }
        });

        btnWO.setText("WO");
        btnWO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWOActionPerformed(evt);
            }
        });

        txtSHexa.setEditable(false);

        txtSdecimal.setEditable(false);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Resultado en Hexadecimal:");
        jLabel6.setToolTipText("");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Resultado en decimal:");

        btnBusGrant.setText("BusGrant");
        btnBusGrant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusGrantActionPerformed(evt);
            }
        });

        btnRequest.setText("Bus Request");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        btnEI.setText("EI");
        btnEI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEIActionPerformed(evt);
            }
        });

        txtCO.setEditable(false);

        txtOP1.setEditable(false);

        txtOP2.setEditable(false);

        txtSI.setEditable(false);

        jLabel8.setText("CODOP");

        jLabel9.setText("OPERANDO1");

        jLabel10.setText("OPERANDO 2");

        jLabel11.setText("SI.INTRUCCION");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonEncender2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonEncender2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButtonEncender2.setForeground(new java.awt.Color(255, 102, 0));
        jButtonEncender2.setText("Encender");
        jButtonEncender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncender2ActionPerformed(evt);
            }
        });

        jButtonApagar2.setBackground(new java.awt.Color(204, 204, 204));
        jButtonApagar2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButtonApagar2.setForeground(new java.awt.Color(255, 102, 0));
        jButtonApagar2.setText("Apagar");
        jButtonApagar2.setEnabled(false);
        jButtonApagar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagar2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBoxPorts.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBoxPorts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPortsActionPerformed(evt);
            }
        });

        jButtonRefresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refreshicon.png"))); // NOI18N
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonConectar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonConectar.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jButtonConectar.setForeground(new java.awt.Color(0, 153, 204));
        jButtonConectar.setText("Conectar");
        jButtonConectar.setEnabled(false);
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxPorts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jComboBoxPorts))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jButtonConectar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEncender2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jButtonApagar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEncender2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonApagar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnAtras))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSHexa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtSdecimal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btnRequest)
                        .addGap(69, 69, 69)
                        .addComponent(btnBusGrant)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAC, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIR, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMBR, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEI, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnFO, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnDI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(txtCO, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSI, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnWO)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEI)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWO))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSHexa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSdecimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequest)
                    .addComponent(btnBusGrant))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        txtPC.setText((String) modelo2.getValueAt(cont,0));
        cont+=1;
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        VentanaBin vtn=new VentanaBin();
        vtn.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIActionPerformed
        txtMAR.setText((String)txtPC.getText());
        
    }//GEN-LAST:event_btnDIActionPerformed

    private void btnWOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWOActionPerformed
        txtAC.setText("00000000"+Integer.toBinaryString(Integer.parseInt(txtSdecimal.getText())));
    }//GEN-LAST:event_btnWOActionPerformed

    private void btnFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFOActionPerformed
        cont-=1;
        txtIR.setText((String) modelo2.getValueAt(cont,1));
        cont+=1;
        
    }//GEN-LAST:event_btnFOActionPerformed

    private void btnCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOActionPerformed
        cont-=1;
        
        txtMBR.setText((String)txtIR.getText());
        txtCO.setText((String)txtIR.getText().substring(0,1));
        
        txtOP1.setText((String)txtIR.getText().substring(1,3));
        txtOP2.setText((String)txtIR.getText().substring(3,5));
        txtSI.setText((String)txtIR.getText().substring(5,(Integer)txtIR.getText().length()));
        cont+=1;
    }//GEN-LAST:event_btnCOActionPerformed

    private void btnEIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEIActionPerformed
        cont-=1;
        int co=0,s;
        String v1,v2;
        co=Integer.parseInt(txtCO.getText());
        v1=Ingreso.datoI.get(cont).getVar1();
        v2=Ingreso.datoI.get(cont).getVar2();
        s=calcular(co, v1, v2);
        txtSdecimal.setText(Integer.toString(s));
        txtSHexa.setText(asciiToHex(Integer.toString(s)));
        
        cont+=1;
        
    }//GEN-LAST:event_btnEIActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnBusGrantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusGrantActionPerformed
      int vhex,vdec;
      vhex=Integer.parseInt(txtSHexa.getText());
        vdec=Integer.parseInt(txtSdecimal.getText());
        //Se modifica la interface gráfica del botón precionado
       // c.enableButton(jButtonApagar);
        //c.disableButton(btnBusGrant);
        //Se envían un -1- para encender el LED
        try {
            Arduino.sendByte(vdec);
        } catch (Exception ex) {
            Logger.getLogger(VentanaSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnBusGrantActionPerformed

    private void jButtonEncender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncender2ActionPerformed

        //Se modifica la interface gráfica del botón precionado
        c.enableButton(jButtonApagar2);
        c.disableButton(jButtonEncender2);
        //Se envían un -1- para encender el LED
        try {
            Arduino.sendData("1");
        } catch (Exception ex) {
            Logger.getLogger(VentanaSalida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonEncender2ActionPerformed

    private void jButtonApagar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagar2ActionPerformed

        //Se modifica la interface gráfica del botón precionado
        c.enableButton(jButtonEncender2);
        c.disableButton(jButtonApagar2);
        //Se envía un -0- para apagar el LED
        try {
            Arduino.sendData("0");
        } catch (Exception ex) {
            Logger.getLogger(VentanaSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonApagar2ActionPerformed

    private void jComboBoxPortsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPortsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPortsActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        getPorts();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed

        if (jButtonConectar.getText().equals("Desconectar")) {
            try {
                Arduino.killArduinoConnection();
                jButtonConectar.setText("Conectar");
                c.disableButton(jButtonApagar2);
                c.disableButton(jButtonEncender2);
                c.enableConnectionPanel(jButtonRefresh, jComboBoxPorts);
            } catch (Exception ex) {
                Logger.getLogger(VentanaSalida.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                Arduino.arduinoTX(jComboBoxPorts.getSelectedItem().toString(), 9600);
                jButtonConectar.setText("Desconectar");
                c.enableButton(jButtonEncender2);
                c.disableButton(jButtonApagar2);
                c.disableConnectionPanel(jButtonRefresh, jComboBoxPorts);
            } catch (Exception ex) {
                Logger.getLogger(VentanaSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonConectarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSalida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBusGrant;
    private javax.swing.JButton btnCO;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnDI;
    private javax.swing.JButton btnEI;
    private javax.swing.JButton btnFO;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnWO;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonApagar1;
    private javax.swing.JButton jButtonApagar2;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonEncender;
    private javax.swing.JButton jButtonEncender1;
    private javax.swing.JButton jButtonEncender2;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JComboBox jComboBoxPorts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtAC;
    private javax.swing.JTextField txtCO;
    private javax.swing.JTextField txtIR;
    private javax.swing.JTextField txtMAR;
    private javax.swing.JTextField txtMBR;
    private javax.swing.JTextField txtOP1;
    private javax.swing.JTextField txtOP2;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtSHexa;
    private javax.swing.JTextField txtSI;
    private javax.swing.JTextField txtSdecimal;
    // End of variables declaration//GEN-END:variables
     public void getPorts() {
        jComboBoxPorts.removeAllItems();
        if (Arduino.getPortsAvailable() > 0) {
            List lst = Arduino.getSerialPorts();
            for(int i=0; i<lst.size(); i++){
                jComboBoxPorts.addItem(lst.get(i));
            }
            //Arduino.getSerialPorts().forEach(i -> jComboBoxPorts.addItem(i));
            jButtonConectar.setEnabled(true);
            jButtonConectar.setBackground(new Color(255, 255, 255));
        } else {
            jButtonConectar.setEnabled(false);
            jButtonConectar.setBackground(new Color(204, 204, 204));
        }

    }

}
