/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.functions.LinearRegression;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author dark
 */
public class KMeans extends NoSupervisado{
    private SimpleKMeans kmeans_simple = null;
    
    public KMeans(String[] cabecera, ArrayList<Vector> datos) {
        super(cabecera, datos);
        generar();
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
            SimpleKMeans skm =new SimpleKMeans();
            skm.buildClusterer(dataset);
            this.setKmeans_simple(skm);
        } catch (Exception ex) {
            Logger.getLogger(RegresionLineal.class.getName()).log(Level.SEVERE, null, ex);
            this.setKmeans_simple(null);
        }
    }

    public void setKmeans_simple(SimpleKMeans kmeans_simple) {
        this.kmeans_simple = kmeans_simple;
    }

    public SimpleKMeans getKmeans_simple() {
        return kmeans_simple;
    }
    
    @Override
    public Vector<Coordenada> centroides() {
        if(this.getKmeans_simple() != null){
            Instances centroides = this.getKmeans_simple().getClusterCentroids();
            Vector<Coordenada> coordenadas = new Vector<Coordenada>();
            for(int i=0; i < centroides.numInstances(); i++){
                Instance temp = centroides.instance(i);
                Coordenada cordenada = new Coordenada(
                        Double.parseDouble(temp.toString(0)), 
                        Double.parseDouble(temp.toString(1))
                );
            }
            return coordenadas;
        }
        return null;
    } 
}
