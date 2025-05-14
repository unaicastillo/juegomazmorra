package com.unaidarioefra;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Inicializar el SceneManager
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.init(primaryStage);

        // Configurar las vistas
        sceneManager.setScene(SceneID.VistaEstadisticas, "VistaEstadisticas", 800, 600);
        sceneManager.setScene(SceneID.VistaJuego, "VistaJuego", 800, 600);

        // Cargar la vista inicial (VistaEstadisticas)
        sceneManager.loadScene(SceneID.VistaEstadisticas);
    }

    public static void main(String[] args) {
        launch(args);
    }
}