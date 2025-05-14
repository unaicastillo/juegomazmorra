package com.unaidarioefra.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.InputStream;

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
    @FXML
    private GridPane gridPane;

    private HashMap<Integer, Image> imagenesEnemigos;
    private ArrayList<Enemigo> enemigos;

    GestorMapa gestorMapa;
    Juego juego;

    @FXML
    public void initialize() {
        // Cargar imágenes de los enemigos
        imagenesEnemigos = new HashMap<>();
        imagenesEnemigos.put(2, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/esbirro.png")));
        imagenesEnemigos.put(3, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/esqueleto.png")));
        imagenesEnemigos.put(4, new Image(getClass().getResourceAsStream("/com/unaidarioefra/images/zombie.png")));

        // Obtener la lista de enemigos desde el juego
        enemigos = Juego.getInstance().getEnemigos();
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
        // Limpiar las imágenes de los enemigos en el mapa
        gridPane.getChildren().removeIf(node -> node instanceof ImageView && node.getUserData() != null);

        // Pintar cada enemigo en su posición
        for (Enemigo enemigo : enemigos) {
            ImageView enemigoView = new ImageView(imagenesEnemigos.get(enemigo.getTipo()));
            enemigoView.setFitWidth(gridPane.getPrefWidth() / 20); // Ajustar al tamaño de la celda
            enemigoView.setFitHeight(gridPane.getPrefHeight() / 20);
            enemigoView.setPreserveRatio(true);
            enemigoView.setUserData("enemigo"); // Marcar como enemigo para poder limpiar después
            gridPane.add(enemigoView, enemigo.getPosicionX(), enemigo.getPosicionY());
        }
    }

    private void moverEnemigos() {
        // Mover cada enemigo a una nueva posición aleatoria dentro del mapa
        for (Enemigo enemigo : enemigos) {
            int nuevaX = enemigo.getPosicionX() + (int) (Math.random() * 3) - 1; // Movimiento aleatorio (-1, 0, 1)
            int nuevaY = enemigo.getPosicionY() + (int) (Math.random() * 3) - 1;

            // Asegurarse de que el enemigo no salga del mapa
            nuevaX = Math.max(0, Math.min(nuevaX, 19));
            nuevaY = Math.max(0, Math.min(nuevaY, 19));

            // Actualizar la posición del enemigo
            enemigo.setPosicionX(nuevaX);
            enemigo.setPosicionY(nuevaY);
        }
    }

    @Override
    public void onChange() {
        // Mover enemigos y actualizar el mapa
        moverEnemigos();
        pintarPersonajes();
    }

    public void cargarImagen() {
        InputStream inputStream = getClass().getResourceAsStream("/com/unaidarioefra/images/imagen.png");
        if (inputStream == null) {
            System.err.println("Error: No se pudo cargar la imagen en la ruta especificada.");
        } else {
            Image imagen = new Image(inputStream);
        }
    }
}
