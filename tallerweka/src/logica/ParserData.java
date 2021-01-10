/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Vector;
import modelos.VariableA;
import java.util.Vector;
import java.util.ArrayList;

/**
 *
 * @author dark
 */
public class ParserData implements ConstruccionData{
    private Vector<VariableA> datos;

    public ParserData(Vector<VariableA> datos) {
        this.datos = datos;
    }

    @Override
    public Etiqueta getDataTemperatura() {
         //To change body of generated methods, choose Tools | Templates.
        ArrayList<Vector> tem_datos = new ArrayList<Vector>();
        for(VariableA dato:datos){
            Vector tem_vector = new Vector();
            tem_vector.add(dato.getTimestamp());
            tem_vector.add(dato.getTemperature());
            tem_datos.add(tem_vector);
        }
        Etiqueta etiqueta = new Etiqueta(tem_datos, new String[]{"Tiempo", "Temperatura"});
        return etiqueta;
    }

    @Override
    public Etiqueta getDataTemperaturaHumedad() {
        ArrayList<Vector> tem_datos = new ArrayList<Vector>();
        for(VariableA dato:datos){
            Vector tem_vector = new Vector();
            tem_vector.add(dato.getTemperature());
            tem_vector.add(dato.getHumidity());
            tem_datos.add(tem_vector);
        }
        Etiqueta etiqueta = new Etiqueta(tem_datos, new String[]{"Temperatura", "Humedad"});
        return etiqueta;
    }

    @Override
    public Etiqueta getDataTemperaturaVelocidad() {
        ArrayList<Vector> tem_datos = new ArrayList<Vector>();
        for(VariableA dato:datos){
            Vector tem_vector = new Vector();
            tem_vector.add(dato.getTemperature());
            tem_vector.add(dato.getSpeed());
            tem_datos.add(tem_vector);
        }
        Etiqueta etiqueta = new Etiqueta(tem_datos, new String[]{"Temperatura", "Velocidad"});
        return etiqueta;
    }
    
    
}
