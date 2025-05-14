package com.unaidarioefra.controlador;

import java.util.ArrayList;
import java.util.HashMap;

import com.unaidarioefra.Interfaz.Observer;
import com.unaidarioefra.Modelo.Enemigo;
import com.unaidarioefra.Modelo.GestorMapa;
import com.unaidarioefra.Modelo.Juego;
import com.unaidarioefra.Modelo.Mapa;

import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class JuegoControlador implements Observer {

    @FXML
    private AnchorPane anchorPane;

    private GridPane gridPane;
    private HashMap<Integer, Image> imagenesEnemigos;
    private ArrayList<Enemigo> enemigos;

    private GestorMapa gestorMapa;
    private Juego juego;

    @FXML
    public void initialize() {
        // Inicializar imágenes de enemigos
        imagenesEnemigos = new HashMap<>();
        imagenesEnemigos.put(2, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/esbirro.jpg")));
        imagenesEnemigos.put(3, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/esqueleto.jpg")));
        imagenesEnemigos.put(4, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/zombie.jpg")));
    }

    // Este método debe llamarse desde el controlador de portada
    public void iniciar() {
        this.juego = Juego.getInstance();
        this.gestorMapa = juego.getGestorMapas();
        this.enemigos = juego.getEnemigos();

        inicializarVista();
        generarMapa();
        pintarPersonajes();
    }

    public void inicializarVista() {
        // Crear el panel dividido principal
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.75);

        // Crear el GridPane para el mapa
        gridPane = new GridPane();
        gridPane.setPrefSize(600, 600);

        // Configurar 20 filas y columnas
        for (int i = 0; i < 20; i++) {
            gridPane.getRowConstraints().add(new javafx.scene.layout.RowConstraints());
            gridPane.getColumnConstraints().add(new javafx.scene.layout.ColumnConstraints());
        }

        // Crear la barra lateral (vbox)
        VBox vbox = new VBox();
        vbox.setPrefWidth(200);
        vbox.setSpacing(10);

        // Añadir el gridPane y vbox al SplitPane
        splitPane.getItems().addAll(gridPane, vbox);

        // Establecer anclajes del SplitPane al AnchorPane
        AnchorPane.setTopAnchor(splitPane, 0.0);
        AnchorPane.setBottomAnchor(splitPane, 0.0);
        AnchorPane.setLeftAnchor(splitPane, 0.0);
        AnchorPane.setRightAnchor(splitPane, 0.0);

        // Añadir el SplitPane al AnchorPane principal
        anchorPane.getChildren().add(splitPane);
    }

    public void generarMapa() {
        gridPane.getChildren().clear();

        Mapa mapaActual = juego.getGestorMapas().getMapaActual();
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
                ImageView imageView = new ImageView(valor == 0 ? suelo : pared);
                imageView.setFitWidth(anchoCelda);
                imageView.setFitHeight(altoCelda);
                imageView.setPreserveRatio(false);
                gridPane.add(imageView, columna, fila);
            }
        }
    }

    public void cambiarMapa() {
        boolean haySiguiente = gestorMapa.avanzarAlSiguienteMapa();
        if (haySiguiente) {
            juego.getGestorMapas().getMapas().clear();
            generarMapa();
            juego.iniciarentidades();
            pintarPersonajes();
        }
    }

    private void pintarPersonajes() {
        // Limpiar personajes anteriores (pero no las celdas base)
        gridPane.getChildren().removeIf(node -> node instanceof ImageView && node.getUserData() != null);

        for (Enemigo enemigo : enemigos) {
            ImageView enemigoView = new ImageView(imagenesEnemigos.get(enemigo.getTipo()));
            enemigoView.setFitWidth(gridPane.getPrefWidth() / 20);
            enemigoView.setFitHeight(gridPane.getPrefHeight() / 20);
            enemigoView.setPreserveRatio(true);
            enemigoView.setUserData("enemigo");
            gridPane.add(enemigoView, enemigo.getPosicionX(), enemigo.getPosicionY());
        }
    }

    private void moverEnemigos() {
        for (Enemigo enemigo : enemigos) {
            int nuevaX = enemigo.getPosicionX() + (int) (Math.random() * 3) - 1;
            int nuevaY = enemigo.getPosicionY() + (int) (Math.random() * 3) - 1;

            nuevaX = Math.max(0, Math.min(nuevaX, 19));
            nuevaY = Math.max(0, Math.min(nuevaY, 19));

            enemigo.setPosicionX(nuevaX);
            enemigo.setPosicionY(nuevaY);
        }
    }

    @Override
    public void onChange() {
        moverEnemigos();
        pintarPersonajes();
    }
}
