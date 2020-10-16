package com.achila.ETLloadservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private int trans_id;

    private int client_id;
    private String operation;
    private  int amount;
    private Date trans_time;

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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
        return "transaction{" +
                "trans_id=" + trans_id +
                ", client_id=" + client_id +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                ", trans_time=" + trans_time +
                '}';
    }
}
