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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
                .withSkipLines(1)
                .build();
        List<String[]> r = reader.readAll();
        r.forEach(x -> {
            if (x.length == 4) {
                try {
                    String timestampString = x[0];
                    String timeFormated = timestampString.replace('T', ' ');
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date parsedDate = dateFormat.parse(timeFormated);
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

                    VariableA v = new VariableA(
                            (double) timestamp.getTime(),
                            Double.parseDouble(x[1].replace(',', '.')),
                            Integer.parseInt(x[2]),
                            Double.parseDouble(x[3].replace(',', '.'))
                    );
                    datos.add(v);

                } catch (Exception e) {
                    System.err.println("##### ERROR LeerArchivoCsv #####");
                    System.err.println(e);
                }

            }
        });
        return datos;
    }
}
