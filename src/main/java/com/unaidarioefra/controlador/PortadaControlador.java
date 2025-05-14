package com.unaidarioefra.controlador;

import com.unaidarioefra.SceneID;
import com.unaidarioefra.SceneManager;
import com.unaidarioefra.Modelo.Prota;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PortadaControlador {

    @FXML private TextField vidaField;
    @FXML private TextField ataqueField;
    @FXML private TextField defensaField;
    @FXML private TextField evasionField;
    @FXML private TextField velocidadField;
    @FXML private Button confirmButton;

    private Prota prota;

    @FXML
    public void initialize() {
        vidaField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        ataqueField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        defensaField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        evasionField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        velocidadField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        confirmButton.setDisable(true);
    }

    private void validarCampos() {
        boolean camposValidos = !vidaField.getText().isEmpty() &&
                                !ataqueField.getText().isEmpty() &&
                                !defensaField.getText().isEmpty() &&
                                !evasionField.getText().isEmpty() &&
                                !velocidadField.getText().isEmpty();
        confirmButton.setDisable(!camposValidos);
    }

    // Se llama al pulsar el botón "Confirmar"
    @FXML
private void cambiarAVistaJuego() {
    try {
        // Crear el personaje principal con los atributos introducidos
        prota = new Prota(
            Integer.parseInt(vidaField.getText()),
            Integer.parseInt(ataqueField.getText()),
            Integer.parseInt(defensaField.getText()),
            Integer.parseInt(evasionField.getText()),
            Integer.parseInt(velocidadField.getText())
        );
        SceneManager.getInstance().loadScene(SceneID.VistaJuego);

        } catch (NumberFormatException e) {
            System.err.println("Error: Asegúrate de que todos los campos contienen números válidos.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
