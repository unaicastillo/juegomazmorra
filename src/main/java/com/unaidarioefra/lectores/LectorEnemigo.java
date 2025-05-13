package com.unaidarioefra.lectores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.unaidarioefra.Modelo.Enemigo;

public class LectorEnemigo {
    public static ArrayList<Enemigo> leerEnemigos() {
        ArrayList<Enemigo> enemigos = new ArrayList<>();
        ArrayList<HashMap<String, Integer>> datosEnemigos = leerCsv();

        for (HashMap<String, Integer> atributos : datosEnemigos) {
            Enemigo enemigo = new Enemigo(atributos);
            enemigos.add(enemigo);
        }

        return enemigos;
    }

    private static ArrayList<HashMap<String, Integer>> leerCsv() {
        ArrayList<HashMap<String, Integer>> arrayList = new ArrayList<>();
        String archivoCsv = "src/main/resources/com/unaidarioefra/files/ArchivoEnemigos.csv";
        HashMap<String, Integer> archivoEnemigos;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCsv))) {
            String line;
            String lineReader = br.readLine(); 
            String[] encabezados = lineReader.split(",");
            while ((line = br.readLine()) != null) {
                archivoEnemigos = new HashMap<>();
                String[] valores = line.split(",");
                for (int i = 0; i < encabezados.length; i++) {
                    try {
                        archivoEnemigos.put(encabezados[i], Integer.parseInt(valores[i]));
                    } catch (NumberFormatException e) {
                        System.err.println("Valor no numérico en columna '" + encabezados[i] + "': " + valores[i]);
                        archivoEnemigos.put(encabezados[i], 0); 
                    }
                }
                arrayList.add(archivoEnemigos);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return arrayList;
    }
}
