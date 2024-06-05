package fr.madenspacher.menupizza;

import fr.madenspacher.menupizza.DAO.PizzaDAO;
import fr.madenspacher.menupizza.classes.Pizza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static fr.madenspacher.menupizza.DAO.PizzaDAO.afficherPizza;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuPizza-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Menu pizza");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        afficherPizza();
        new PizzaDAO().ajouterPizza(new Pizza("Reine", 15, 4));
        afficherPizza();

    }


}