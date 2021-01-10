/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import static java.lang.System.out;
/**
 *
 * @author dark
 */
public class KmeansUno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        // TODO code application logic here
        String ruta = "/home/dark/Documents/Estudio/Seminario/software_libre/tallerweka/tallerweka/regresion.arff";
        Instances instancias = new Instances(new BufferedReader(new FileReader(ruta)));
        
        SimpleKMeans skm = new SimpleKMeans();
        skm.buildClusterer(instancias);
        
    }
    
}
