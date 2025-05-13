package com.unaidarioefra.controlador;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.unaidarioefra.GestorMapa;
import com.unaidarioefra.Juego;
import com.unaidarioefra.Mapa;
import com.unaidarioefra.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class JuegoControlador implements Observer {

    @FXML
    private AnchorPane anchorPane;
        GridPane gridPane ;
        GestorMapa gestorMapa;
        Juego juego;

        @FXML
        public void initialize() {
         //TODO
        }
    
    public void inicializarVista() {
        // Crear el SplitPane
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.75); // 75% para la primera parte
        
        // Crear el GridPane para el mapa
        gridPane = new GridPane();
        gridPane.setPrefSize(600, 600); // Tamaño inicial
        for (int i = 0; i < 20; i++) {
            gridPane.getRowConstraints().add(new javafx.scene.layout.RowConstraints());
            gridPane.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints());
        }

        // Crear el VBox para los atributos
        VBox vbox = new VBox();
        vbox.setPrefWidth(200); // Tamaño inicial para el 25%
        vbox.setSpacing(10);

        // Añadir el GridPane y el VBox al SplitPane
        splitPane.getItems().addAll(gridPane, vbox);

        // Ajustar el SplitPane al AnchorPane
        AnchorPane.setTopAnchor(splitPane, 0.0);
        AnchorPane.setBottomAnchor(splitPane, 0.0);
        AnchorPane.setLeftAnchor(splitPane, 0.0);
        AnchorPane.setRightAnchor(splitPane, 0.0);

        // Añadir el SplitPane al AnchorPane
        anchorPane.getChildren().add(splitPane);
    }
    
    // public void generarMapa() 
     public void generarMapa() {
        
        gridPane.getChildren().clear();
        Mapa mapaActual = Juego.getInstance().getGestorMapas().getMapaActual();
        int[][] matriz = mapaActual.getMapa();
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double anchoCelda = gridPane.getPrefWidth() / columnas;
        double altoCelda = gridPane.getPrefHeight() / filas;

        Image suelo = new Image(getClass().getResourceAsStream(mapaActual.getSuelo()));
        Image pared = new Image(getClass().getResourceAsStream(mapaActual.getPared()));

        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                int valor = matriz[fila][columna];
                ImageView imageView;
                if (valor == 0) {
                    imageView = new ImageView(suelo);
                } else {
                    imageView = new ImageView(pared);
                }
                imageView.setFitWidth(anchoCelda);
                imageView.setFitHeight(altoCelda);
                imageView.setPreserveRatio(false);
                gridPane.add(imageView, columna, fila);
            }
        }
    }

    // public void cambiarMapa()
    public void cambiarMapa(){
        boolean haySiguiente=gestorMapa.avanzarAlSiguienteMapa();
        if (haySiguiente){
            HashMap<String,Mapa> mapas= juego.getGestorMapas().getMapas();
            mapas.clear();
            generarMapa();
            juego.iniciarentidades();
            pintarPersonajes();
        }
    }

    private void pintarPersonajes() {
        // TODO
    }

    @Override
    public void onChange() {
        // TODO 
        //llamar a una funcion que actualice las imagenes de los personajes
    }
}
