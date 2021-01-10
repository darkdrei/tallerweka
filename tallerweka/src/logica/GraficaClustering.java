/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Vector;
import modelos.VariableA;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author mario
 */
public class GraficaClustering {

    private Vector datos;

    public GraficaClustering(Vector datos) {
        this.datos = datos;
    }

    public Vector getDatos() {
        return datos;
    }

    public void setDatos(Vector datos) {
        this.datos = datos;
    }

    private XYDataset crearDatasetTemHum() {
        XYSeries series1 = new XYSeries("Temperatura y Humedad");
        VariableA v;
        for (int i = 0; i < this.datos.size(); i++) {
            v = (VariableA) this.datos.get(i);
            series1.add(v.getTemperature(), (Number) v.getHumidity());
        }
//        XYSeries series2 = new XYSeries("Humedad");
//        for (int i = 0; i < this.datos.size(); i++) {
//            v = (VariableA) this.datos.get(i);
//            series2.add(v.getTimestamp(), pred);
//        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // dataset.addSeries(series2);
        return dataset;
    }

    private XYDataset crearDatasetTemVel() {
        XYSeries series1 = new XYSeries("Temperatura y Velocidad");
        VariableA v;
        for (int i = 0; i < this.datos.size(); i++) {
            v = (VariableA) this.datos.get(i);
            series1.add(v.getTemperature(), v.getSpeed());
        }
//        XYSeries series2 = new XYSeries("Humedad");
//        for (int i = 0; i < this.datos.size(); i++) {
//            v = (VariableA) this.datos.get(i);
//            series2.add(v.getTimestamp(), pred);
//        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        // dataset.addSeries(series2);
        return dataset;
    }

    public ChartPanel generarGraficaTemHum() {
        XYDataset dataset = this.crearDatasetTemHum();
        Grafica g = new Grafica("Clostering Temperatura y Humedad", "Temperatura", "Humedad", dataset, 2);
        return g.generar();
    }

    public ChartPanel generarGraficaTemVel() {
        XYDataset dataset = this.crearDatasetTemVel();
        Grafica g = new Grafica("Clostering Temperatura y Velocidad", "Temperatura", "Velocidad", dataset, 2);
        return g.generar();
    }
}
