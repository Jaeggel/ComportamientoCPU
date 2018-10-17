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
public class DatosInst 
{
    String code;
    String var1;
    String var2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }
    
     public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\nOPCode: ");
        sb.append(code);
        sb.append("\nVariable 1: ");
        sb.append(var1);        
        sb.append("\nVariable 2: ");
        sb.append(var2);
        return sb.toString();

    }   
}
