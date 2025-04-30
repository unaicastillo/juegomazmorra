package com.unaidarioefra.lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorEnemigo {
    public static ArrayList leerCsv(String pathInput){
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        String archivoCsv = pathInput+"ArchivoEnemigos.csv"; 
        HashMap<String, String> ArchivoEnemigoss ;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            String line;
            String lineReader=br.readLine();
            String[] encabezados = lineReader.split(","); 

            while ((line = br.readLine()) != null) {
                mapaCoches = new HashMap<>();
                String[] valores = line.split(",");
                
                
                for (int i = 0; i < encabezados.length; i++) {
                    mapaCoches.put(encabezados[i], valores[i]); 
                }
                
                
                arrayList.add(mapaCoches);
                
            }

            


        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return arrayList;

    }
}
