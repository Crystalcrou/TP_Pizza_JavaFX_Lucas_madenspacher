package fr.madenspacher.menupizza.DAO;

import fr.madenspacher.menupizza.classes.Pizza;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    public List<Pizza> getPizza(){
     List<Pizza> pizzas = new ArrayList<>();
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/madenspa1u_pizza", "madenspa1u_appli", "31815017");

         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT nom, prix, nbIngredients FROM pizza");
         while(rs.next()){
             pizzas.add(new Pizza(rs.getString("nom"),rs.getInt("prix"),rs.getInt("nbIngredients")));
         }

         con.close();
     }catch (Exception e) {
         e.printStackTrace();
     }
     return pizzas;
    }

    public void ajouterPizza(Pizza pizza){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/madenspa1u_pizza", "madenspa1u_appli", "31815017");

            PreparedStatement statement = con.prepareStatement("INSERT INTO pizza (nom, prix, nbIngredients) VALUES (?, ?, ?)");
            statement.setString(1,pizza.getNom());
            statement.setInt(2,pizza.getPrix());
            statement.setInt(3,pizza.getNbIngredients());
            statement.executeUpdate();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void afficherPizza() {
        List<Pizza> pizzas = new PizzaDAO().getPizza();
        pizzas.forEach(System.out::println);

    }

}
