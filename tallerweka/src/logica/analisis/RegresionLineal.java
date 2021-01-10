/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.util.Vector;
import weka.classifiers.functions.LinearRegression;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
/**
 *
 * @author dark
 */
public class RegresionLineal extends Supervisado{
    private LinearRegression regresion_lineal;

    public RegresionLineal(String[] cabecera, ArrayList<Vector> datos) {
        super(cabecera, datos);
        this.regresion_lineal = null;
        this.generar();
    }

    @Override
    public void generar() {
        try {
            this.setFv(new FastVector(this.getCabecera().length));
            for (String etiqueta : this.getCabecera()) {
                this.getFv().addElement(new Attribute(etiqueta));
            }
            Instances dataset = new Instances("dataset", this.getFv(), this.getDatos().size());
            dataset.setClassIndex(dataset.numAttributes() - 1);
            int VALOR_ENTERO = 0;
            double VALOR_DOUBLE = 1.1;
            for(int i=0; i < this.getDatos().size(); i++){
                Instance instance = new Instance(this.getCabecera().length);
                for(int j=0; j < this.getDatos().get(i).size(); j++){
                    Object valor = this.getDatos().get(i).get(j);
                    instance.setValue((Attribute)this.getFv().elementAt(j), 
                            valor instanceof Integer?(int)valor:(double)valor
                    );
                }
                dataset.add(instance);
            }
            this.setInstancias(dataset);
            LinearRegression lr=new LinearRegression();
            lr.buildClassifier(dataset);
            this.setRegresion_lineal(lr);
        } catch (Exception ex) {
            Logger.getLogger(RegresionLineal.class.getName()).log(Level.SEVERE, null, ex);
            this.setRegresion_lineal(null);
            this.setInstancias(null);
        }
    }

    @Override
    public double prediccion(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LinearRegression getRegresion_lineal() {
        return regresion_lineal;
    }

    public void setRegresion_lineal(LinearRegression regresion_lineal) {
        this.regresion_lineal = regresion_lineal;
    }

    @Override
    public String evaluacionModelo() {
        if(this.getInstancias() != null){
            try {
                Evaluation ev = new Evaluation(this.getInstancias());
                ev.crossValidateModel(this.getRegresion_lineal(), this.getInstancias(), 10, new Random(1), new String[]{});
                return ev.toSummaryString();
            } catch (Exception ex) {
                Logger.getLogger(RegresionLineal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    @Override
    public double[] coeficienteModelo() {
        if(this.getRegresion_lineal() != null){
            return this.getRegresion_lineal().coefficients();
        }
        return (new double[]{});
    }
    
    
}
