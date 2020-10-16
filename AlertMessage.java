package com.achila.ETLloadservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class AlertMessage {

    int client_id;
    String nationality;
    String description;
    private String operation;
    private  int amount;
    private Date trans_time;

    public AlertMessage(int client_id, String nationality, String description, String operation, int amount, Date trans_time) {
        this.client_id = client_id;
        this.nationality = nationality;
        this.description = description;
        this.operation = operation;
        this.amount = amount;
        this.trans_time = trans_time;
    }

    /*public AlertMessage(@JsonProperty("client_id") int client_id,
                        @JsonProperty("nationality") String nationality,
                        @JsonProperty("description") String description,
                        @JsonProperty("operation") String operation,
                        @JsonProperty("amount") int amount,
                        @JsonProperty("trans_time") Date trans_time) {
        this.client_id = client_id;
        this.nationality = nationality;
        this.description = description;
        this.operation = operation;
        this.amount = amount;
        this.trans_time = trans_time;
    }*/

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTrans_time() {
        return trans_time;
    }

    public void setTrans_time(Date trans_time) {
        this.trans_time = trans_time;
    }

    @Override
    public String toString() {
        return "AlertMessage{" +
                "client_id=" + client_id +
                ", nationality='" + nationality + '\'' +
                ", description='" + description + '\'' +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                ", trans_time=" + trans_time +
                '}';
    }
}
