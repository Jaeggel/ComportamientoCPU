/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author DIEGO VELASCO
 */
public class asd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(asciiToHex("5"));
    }
        public static String textoABinario(String texto)
    {
        String textoBinario = "";
        for(char letra : texto.toCharArray())
        {
            textoBinario += String.format("%16s", Integer.toBinaryString(letra));
        }
        return textoBinario.replace("\u0020","\u0030");
    }
        public static char unmangle(int a)
        {      
           char c=(char)a;
           
        return c;   
        }
        
        public static String toBin(int dec)
        {
            int residuo=0;
            String num=Integer.toString(dec);
            int cociente=Integer.parseInt(num);
            String valor="";
            while(cociente !=0)
            {
                residuo=cociente %2;
                cociente=cociente/2;
                valor+=residuo+"";
            }
            StringBuilder builder=new StringBuilder(valor);
            String bin=builder.reverse().toString();
            String acum="",aux="";
            if(bin.length()<8)
            {
                int dif=8-bin.length();
                for (int i = 0; i < dif; i++) 
                {
                    acum+="0";
                }
                aux=acum.concat(bin);    
            }else
            {
                aux=bin;
            }
            String sign="",binF="";
            if(dec>0)
            {
               sign="0000";
            }else
            {
                sign="1111";
            }
            binF=sign.concat(aux);
            
        return binF;    
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
    
}
