/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.text.DecimalFormat;
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
        double[] coeficientes = this.coeficienteModelo();
        return (valor*coeficientes[0]+coeficientes[2]);
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
                DecimalFormat df = new DecimalFormat("#.0000");
                Evaluation ev = new Evaluation(this.getInstancias());
                ev.crossValidateModel(this.getRegresion_lineal(), this.getInstancias(), 5, new Random(1), new String[]{});
                String info="\n\tValores de evaluación del modelo ";
                info+="\nCoeficiente de correlacion: "+df.format(ev.correlationCoefficient());
                info+="\nError absoluto medio      : "+df.format(ev.meanAbsoluteError());
                info+="\nError del cuadrado medio  : "+df.format(ev.rootMeanSquaredError());
                info+="\nError absoluto relativo   : "+df.format(ev.relativeAbsoluteError())+" %";
                info+="\nError cuadratico relativo : "+df.format(ev.rootRelativeSquaredError())+" %";
                info+="\nNumero de instancias      : "+((int)ev.numInstances());
                return info;
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
