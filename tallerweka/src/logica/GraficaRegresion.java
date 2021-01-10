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
public class GraficaRegresion {

    private Vector datos;
    private double[] coef;

    public GraficaRegresion(Vector datos, double[] coef) {
        this.datos = datos;
        this.coef = coef;
    }

    public Vector getDatos() {
        return datos;
    }

    public void setDatos(Vector datos) {
        this.datos = datos;
    }

    public double[] getCoef() {
        return coef;
    }

    public void setCoef(double[] coef) {
        this.coef = coef;
    }

    private XYDataset crearDataset() {
        XYSeries series1 = new XYSeries("Temperatura");
        VariableA v;
        for (int i = 0; i < this.datos.size(); i++) {
            v = (VariableA) this.datos.get(i);
            series1.add(v.getTimestamp(), v.getTemperature());
        }
        XYSeries series2 = new XYSeries("Regresión");
        for (int i = 0; i < this.datos.size(); i++) {
            v = (VariableA) this.datos.get(i);
            Double pred = coef[0] * v.getTimestamp() + coef[2];
            series2.add(v.getTimestamp(), pred);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }

    public ChartPanel generarGrafica() {
        XYDataset dataset = this.crearDataset();
        Grafica g = new Grafica("Regresión Temperatura", "Marca de tiempo", "Temperatura", dataset);
        return g.generarLineChart();
    }
}
