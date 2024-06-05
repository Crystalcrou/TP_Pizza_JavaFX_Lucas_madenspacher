package fr.madenspacher.menupizza;

import fr.madenspacher.menupizza.DAO.PizzaDAO;
import fr.madenspacher.menupizza.classes.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField txtPizza;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtNbIngredient;

    @FXML
    private TableView<Pizza> tableBDD;

    @FXML
    private TableColumn<Pizza, String> colNom;

    @FXML
    private TableColumn<Pizza, Integer> colPrix;

    @FXML
    private TableColumn<Pizza, Integer> colIngredient;

    @FXML
    private Button ajouter;

    @FXML
    private Button vider;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colIngredient.setCellValueFactory(new PropertyValueFactory<>("nbIngredients"));

        PizzaDAO pizzaDAO = new PizzaDAO();
        List<Pizza> pizza = pizzaDAO.getPizza();

        System.out.println(pizza.size());
        ObservableList<Pizza> pizzaList = FXCollections.observableArrayList(pizza);
        tableBDD.setItems(pizzaList);

    }

    @FXML
    public static void supprimerPizza() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/madenspa1u_pizza", "madenspa1u_appli", "31815017");

            PreparedStatement statement = con.prepareStatement("delete from pizza");
            statement.executeUpdate();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}