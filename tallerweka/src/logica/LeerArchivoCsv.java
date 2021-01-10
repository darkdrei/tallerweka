/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.util.Vector;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import modelos.VariableA;

/**
 *
 * @author mario
 */
public class LeerArchivoCsv {
    private String path;
  
    public LeerArchivoCsv(String archivo) {
        this.path = archivo;
    }
    
    public Vector procesar() throws IOException, CsvException {
        Vector datos = new Vector();
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader reader = new CSVReaderBuilder(new FileReader(this.path))
            .withCSVParser(csvParser)
            .build();
        List<String[]> r = reader.readAll();
        r.forEach(x ->{
          if (x.length == 4) {
              VariableA v = new VariableA(x[0], x[1], x[2], x[3]);
              datos.add(v);
          }
        });
        return datos;
    }
}
