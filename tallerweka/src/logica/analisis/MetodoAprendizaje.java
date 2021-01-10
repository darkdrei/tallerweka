/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.util.Vector;
import weka.core.FastVector;
import java.util.ArrayList;
import weka.core.Instances;
/**
 *
 * @author dark
 */
public abstract class MetodoAprendizaje implements OperacionesGenerales{
    private FastVector fv;
    private ArrayList<Vector> datos;
    private String[] cabecera;
    private Instances instancias;
            
    public MetodoAprendizaje(String cabecera[], ArrayList<Vector> datos){
        this.cabecera = cabecera;
        this.datos = datos;
        this.instancias = null;
    }

    public FastVector getFv() {
        return fv;
    }

    public ArrayList<Vector> getDatos() {
        return datos;
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public void setFv(FastVector fv) {
        this.fv = fv;
    }

    public void setDatos(ArrayList<Vector> datos) {
        this.datos = datos;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }

    public Instances getInstancias() {
        return instancias;
    }

    public void setInstancias(Instances instancias) {
        this.instancias = instancias;
    }

    @Override
    public String toString() {
        return "MetodoAprendizaje{" + "fv=" + fv + ", datos=" + datos + ", cabecera=" + cabecera + '}';
    }
    

    public String evaluacionModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double[] coeficienteModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
