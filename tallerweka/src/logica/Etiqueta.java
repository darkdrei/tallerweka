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
public class Etiqueta {
    private ArrayList<Vector> datos;
    private String[] cabecera;

    public Etiqueta(ArrayList<Vector> datos, String[] cabecera) {
        this.datos = datos;
        this.cabecera = cabecera;
    }

    public ArrayList<Vector> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Vector> datos) {
        this.datos = datos;
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public void setCabecera(String[] cabecera) {
        this.cabecera = cabecera;
    }
}
