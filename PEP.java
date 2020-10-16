package com.achila.ETLloadservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PEP {

    @Id
    private int pep_id;
    private int client_id;
    private String nationality;
    private String description;

    public int getPep_id() {
        return pep_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PEP{" +
                "pep_id=" + pep_id +
                ", client_id=" + client_id +
                ", nationality='" + nationality + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
