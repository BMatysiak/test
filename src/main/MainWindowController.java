package main;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    private Stage stage;

    @FXML private TableView<Client> tableView;

    @FXML private TableColumn<Client, String> clientColumn;
    @FXML private TableColumn<Client, String> brandColumn;
    @FXML private TableColumn<Client, String> modelColumn;
    @FXML private TableColumn<Client, String> specificationColumn;
    @FXML private TableColumn<Client, String> quantityColumn;
    @FXML private TableColumn<Client, String> doneColumn;
    @FXML private TableColumn<Client, String> orderColumn;

    @FXML private Button addButton, deleteButton;

    @FXML private Label clientLabel;

    @FXML private TextField clientInput, brandInput, modelInput, specificationInput, quantityInput, quantityDoneInput, orderInput;

    @Override

    public void initialize(URL location, ResourceBundle resources){
        clientColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("client"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("model"));
        specificationColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("specification"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("quantity"));
        doneColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("quantityDone"));
        orderColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("order"));
        tableView.setItems(getClients());
        getClickedRow();
       // getSelectedCell();
    }

    public void addRowToTable(){
        Client newClient = new Client(clientInput.getText(), brandInput.getText(), modelInput.getText(), specificationInput.getText(),
                                      quantityInput.getText(), quantityDoneInput.getText(), orderInput.getText());
        if(orderInput.getText().equals(tableView.getSelectionModel().getSelectedItem().getOrder())){
            deleteRowFromTable();
        }
        tableView.getItems().add(newClient);
        clientInput.clear();
        brandInput.clear();
        modelInput.clear();
        specificationInput.clear();
        quantityInput.clear();
        quantityDoneInput.clear();
        orderInput.clear();
    }

    public void deleteRowFromTable(){
        ObservableList<Client> selectedClient, clients;
        try{
            clients = tableView.getItems();
            if(clients.size() != 0){
                selectedClient = tableView.getSelectionModel().getSelectedItems();
                selectedClient.forEach(clients::remove);
            }

        }catch(Exception e){

        }
    }
    public void editRowFromTable(){
            if(tableView.getSelectionModel().getSelectedIndex() >= 0){
                clientInput.setText(tableView.getSelectionModel().getSelectedItem().getClient());
                brandInput.setText(tableView.getSelectionModel().getSelectedItem().getBrand());
                modelInput.setText(tableView.getSelectionModel().getSelectedItem().getModel());
                specificationInput.setText(tableView.getSelectionModel().getSelectedItem().getSpecification());
                quantityInput.setText(tableView.getSelectionModel().getSelectedItem().getQuantity());
                quantityDoneInput.setText(tableView.getSelectionModel().getSelectedItem().getQuantityDone());
                orderInput.setText(tableView.getSelectionModel().getSelectedItem().getOrder());

            };
    }

    public ObservableList<Client> getClients(){
        ObservableList<Client> clientsList = FXCollections.observableArrayList();
        clientsList.add(new Client("Shark", "Dell", "E6540", "i5/8/256", "20", "0", "1"));
        clientsList.add(new Client("Memtech", "Dell", "E6440", "i5/4/128", "30", "0", "2"));
        clientsList.add(new Client("Grecja", "HP", "8460p", "i5/8/256", "50", "0", "3"));
        return clientsList;
    }

    public void getClickedRow(){
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() > 0){
                    if(tableView.getSelectionModel().getSelectedIndex() >= 0){
                        clientLabel.setText(tableView.getSelectionModel().getSelectedItem().getClient()
                        + ": " + tableView.getSelectionModel().getSelectedItem().getBrand()
                        + " " + tableView.getSelectionModel().getSelectedItem().getModel()
                        + " " + tableView.getSelectionModel().getSelectedItem().getSpecification()
                        + " " + tableView.getSelectionModel().getSelectedItem().getQuantityDone()
                        + "/" + tableView.getSelectionModel().getSelectedItem().getQuantity()
                        + " " + tableView.getSelectionModel().getSelectedItem().getOrder());

                    }
                }
            }
        });

    }

    public void getSelectedCell(){
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() > 1){
                    if(tableView.getSelectionModel().getSelectedIndex() >= 0){
                        TablePosition position = tableView.getSelectionModel().getSelectedCells().get(0);
                        int row = position.getRow();
                        Client client = tableView.getItems().get(row);
                        TableColumn tableColumn = position.getTableColumn();
                        String data = tableColumn.getCellObservableValue(client).getValue().toString();
                        clientLabel.setText(data);
                    }
                }
            }
        });

    }

    void setStage(Stage stage){
        this.stage = stage;
    }
    public void saveProgram(){
        try{
            FileWriter writer = new FileWriter("test.txt");
            BufferedWriter exit = new BufferedWriter(writer);

            //  wyjscie.write(tableView.getItems());

        }catch(IOException e){

        }
    }

    public static void closeProgram(){

        Platform.exit();
        System.exit(0);

    }
}
