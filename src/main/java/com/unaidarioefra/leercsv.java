package com.unaidarioefra;

import java.io.*;
import java.util.*;

public class leercsv {
    public static List<Entidad> leerCSV(File archivo) {
        List<Entidad> entidad = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Saltar encabezado
            while ((linea = br.readLine()) != null) {
                String[] values = linea.split(",");
                entidad.add(new Entidad(values[0] ,Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entidad;
    }
}