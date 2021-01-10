/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.analisis;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dark
 */
public class NoSupervisado extends MetodoAprendizaje implements OperacionesMetodosNoSupervisado{

    public NoSupervisado(String[] cabecera, ArrayList<Vector> datos) {
        super(cabecera, datos);
    }

    @Override
    public void generar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Coordenada> centroides() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
