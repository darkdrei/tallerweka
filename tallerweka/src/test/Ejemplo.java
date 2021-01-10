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
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import weka.classifiers.Evaluation;
/**
 *
 * @author dark
 */
public class Ejemplo {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception{
        String ruta = "/home/dark/Documents/Estudio/Seminario/software_libre/tallerweka/tallerweka/regresion.arff";
        Instances instancias = new Instances(new BufferedReader(new FileReader(ruta)));
        instancias.setClassIndex(instancias.numAttributes()-1);
        
        /** Regresión Lineal */
        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(instancias);
        out.print("==========================================");
        out.println("LR  "+lr);
        out.println("Coeficientes "+Arrays.toString(lr.coefficients()));
        out.print("==========================================");
        Evaluation ev = new Evaluation(instancias);
        ev.crossValidateModel(lr, instancias, 10, new Random(1), new String[]{});
        out.println(""+ev.toSummaryString());
        out.print("==========================================");
        
        /** Predecir los resultados*/
        double coeficientes[] = lr.coefficients();
        double prediccion = 1000*coeficientes[0]+ coeficientes[2];
        out.println("Predicción para 1000: "+ prediccion);
    }
}
