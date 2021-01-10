/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.util.Vector;
import java.util.ArrayList;
import static java.lang.System.out;
/**
 *
 * @author dark
 */
public class Practicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Vector> data = new ArrayList<Vector>();
        Vector tem = new Vector();
        tem.add(1960);
        tem.add(7952221);
        data.add(tem);
        Vector tem2 = new Vector();
        tem2.add(1961);
        tem2.add(8204218);
        data.add(tem2);
        Vector tem3 = new Vector();
        tem3.add(1962);
        tem3.add(8463701);
        data.add(tem3);
        Vector tem4 = new Vector();
        tem4.add(1963);
        tem4.add(8729277);
        data.add(tem4);
        Vector tem5 = new Vector();
        tem5.add(1964);
        tem5.add(8999214);
        data.add(tem5);
        Vector tem6 = new Vector();
        tem6.add(1965);
        tem6.add(9271978);
        data.add(tem6);
        Vector tem7 = new Vector();
        tem7.add(1966);
        tem7.add(9547502);
        data.add(tem7);
        Vector tem8 = new Vector();
        tem8.add(1967);
        tem8.add(9825088);
        data.add(tem8);
        Vector tem9 = new Vector();
        tem9.add(1968);
        tem9.add(10101749);
        data.add(tem9);
        /*for(int i=0; i< data.size();i++){
            System.out.println("------------ Elemento "+(i));
            for(int j=0;j < data.get(i).size();j++){
                System.out.println(""+data.get(i).get(j));
            }
        }*/
        /* Regresion Lneal */
        RegresionLineal r = new RegresionLineal(new String[]{"Ano", "Poblacion"}, data);
        out.println("Evaluación de modelo: "+r.getRegresion_lineal());
        /* KMeans */
        KMeans km = new KMeans(new String[]{"Ano", "Poblacion"}, data);
        out.println("Evaluación de modelo: "+km.getKmeans_simple());
    }
    
}
