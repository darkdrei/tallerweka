/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author mario
 */
public class Grafica {

    private String titulo;
    private String label1;
    private String label2;
    private XYDataset dataset;
    private int type;

    public Grafica(String titulo, String label1, String label2, XYDataset dataset, int type) {
        this.titulo = titulo;
        this.label1 = label1;
        this.label2 = label2;
        this.dataset = dataset;
        this.type = type;
    }

    public ChartPanel generar() {
        JFreeChart chart;
        if (this.type == 1) {
            chart = ChartFactory.createXYLineChart(
                    this.titulo,
                    this.label1,
                    this.label2,
                    this.dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    false,
                    false
            );
        } else {
            chart = ChartFactory.createScatterPlot(
                    this.titulo,
                    this.label1,
                    this.label2,
                    this.dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    false,
                    false
            );
        }
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        ChartPanel cp = new ChartPanel(chart);
        return cp;
    }
}
