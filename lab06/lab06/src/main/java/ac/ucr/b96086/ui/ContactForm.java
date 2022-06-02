/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.ucr.b96086.ui;


import ac.ucr.b96086.domain.Contact;
import ac.ucr.b96086.persistence.PersistenceContext;
import ac.ucr.b96086.persistence.PersistenceStrategy;
import ac.ucr.b96086.service.ContactService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

public class ContactForm extends Application {
    private TextField name = new TextField();
    private TextField lastName = new TextField();
    private DatePicker dateOfBirth = new DatePicker();
    private Button addButton = new Button("Agregar");

    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label nameLabel = new Label("Nombre");
        Label lastNameLabel = new Label("Apellido");
        Label dateOfBirthLabel = new Label("Fecha de Nacimiento");
        addButton.setOnAction(event -> createContact());


        GridPane form = buildForm(
                nameLabel, name,
                lastNameLabel, lastName,
                dateOfBirthLabel, dateOfBirth,
                addButton
        );

        VBox box =new VBox(10);// vbox vertical box
        box.setPadding(new Insets(5,5,5,50));
        box.getChildren().addAll(form,buildListView());

        Scene scene = new Scene(box, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        reloadContacts();
    }

    private ListView<Contact> buildListView(){
        ListView<Contact> listView = new ListView<>(contacts);
        listView.setMaxSize(500,500);
        return listView;
    }
    private void reloadContacts(){// permite poner  listar los contactos
        contacts.clear();
        contacts.addAll(service.findAll());
    }
    private ContactService service = new ContactService();

    private void createContact() {
        Contact contact = new Contact();
        contact.setName(name.getText());
        contact.setSurname(lastName.getText());
        contact.setBirthdate(dateOfBirth.getValue());
        service.save(contact);
        //clearItems();
        reloadContacts();
    }

    private void clearItems() {
        name.setText("");
        lastName.setText("");
        dateOfBirth.setValue(null);
    }
    private GridPane buildForm(Control... controls) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        IntStream.range(0, controls.length)
                .forEach(index ->
                        grid.add(
                                controls[index], index % 2, index / 2, 1, 1)
                );


        return grid;
    }

    public static void main(String[] args) {
        try {
            PersistenceContext.getInstance().setRoot(new File("data").getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PersistenceContext.getInstance().setStrategy(PersistenceStrategy.XML);
        launch(args);
    }
    public static void maint(String[] args) {
        try {
            PersistenceContext.getInstance().setRoot(new File("data").getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PersistenceContext.getInstance().setStrategy(PersistenceStrategy.JSON);
        launch();
    }
}
