package co.edu.uniquindio.almacen.almacen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Almacenview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 655);
        stage.setTitle("Almacen");
        stage.setScene(scene);
        stage.show();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}