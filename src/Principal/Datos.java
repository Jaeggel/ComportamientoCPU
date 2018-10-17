/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

/**
 *
 * @author 
 */
public class Datos 
{
    String var=null;
    int valor =0;
    int posC=0;
    int posF=0;

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPosC() {
        return posC;
    }

    public void setPosC(int posC) {
        this.posC = posC;
    }

    public int getPosF() {
        return posF;
    }

    public void setPosF(int posF) {
        this.posF = posF;
    }
    
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\nVariable: ");
        sb.append(var);
        sb.append("\nValor: ");
        sb.append(valor);        
        sb.append("\nPosición Fila: ");
        sb.append(posF);
        sb.append("\nPosición Columna: ");
        sb.append(posC);

        return sb.toString();

    }    
}
