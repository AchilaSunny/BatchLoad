package com.achila.ETLloadservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WCL {

    @Id
    private int wcl_id;
    private int client_id;
    private String nationality;
    private String description;

    public int getWcl_id() {
        return wcl_id;
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
        return "WCL{" +
                "wcl_id=" + wcl_id +
                ", client_id=" + client_id +
                ", nationality='" + nationality + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
