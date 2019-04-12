package main;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {

    private SimpleStringProperty client, brand, model, specification, quantity, quantityDone, order;

    public Client(String client, String brand, String model, String specification, String quantity, String quantityDone, String order) {
        this.client = new SimpleStringProperty(client);
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.specification = new SimpleStringProperty(specification);
        this.quantity = new SimpleStringProperty(quantity);
        this.quantityDone = new SimpleStringProperty(quantityDone);
        this.order = new SimpleStringProperty(order);
    }

    public String getClient() {
        return client.get();
    }

    public SimpleStringProperty clientProperty() {
        return client;
    }

    public void setClient(String client) {
        this.client.set(client);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getSpecification() {
        return specification.get();
    }

    public SimpleStringProperty specificationProperty() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification.set(specification);
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getQuantityDone() {
        return quantityDone.get();
    }

    public SimpleStringProperty quantityDoneProperty() {
        return quantityDone;
    }

    public void setQuantityDone(String quantityDone) {
        this.quantityDone.set(quantityDone);
    }

    public String getOrder(){
        return order.get();
    }
    public SimpleStringProperty orderProperty(){
        return order;
    }

    public void setOrder(String order) {
        this.order.set(order);
    }


    @Override
    public String toString() {
        return client + ": " + brand + " " + model + " " + specification + ": " + quantity + " " + quantityDone + " " + order;
    }
}
