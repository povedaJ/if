/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.stream.IntStream;
import javafx.application.Application;

import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author Equipo
 */
public class ContactForm extends Application {

    private TextField nameField = new TextField();
    private TextField lastnameField = new TextField();
    private DatePicker dateOfBirth = new DatePicker();
    private Button addButton = new Button("Agregar");

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label nameLabel = new Label("Nombre");
        Label lastNameLabel = new Label("Apellidos");
        Label dateOfBirthLabel = new Label("Fecha de nacimiento");      
    
    
    GridPane form = buildForm(
            nameLabel, nameField,
            lastNameLabel, lastnameField,
            dateOfBirthLabel, dateOfBirth,
            addButton
    );
    
    Scene scene= new Scene(form,600,600);
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    
    private GridPane buildForm(Control...controls){
        GridPane grid = new GridPane();
        grid.setHgap(10);// ahrega espacio horizontal
        grid.setVgap(10);// agrega espacio vertical 
        grid.setPadding(new Insets(10)); // espacio en los bordes de 10 en todos los bordes 
        
        IntStream.range(0, controls.length).forEach(index->grid.add(controls[index], index % 2, index / 2, 1, 1));
        
        return grid;
}
    
    public static void main(String[] args) {
        launch(args);
                
    }

}
