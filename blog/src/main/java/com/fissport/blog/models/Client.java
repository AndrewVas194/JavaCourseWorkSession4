package com.fissport.blog.models;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClients;

        private String clientName;
        private String email;
        private String number;

    public Long getIdClients() { return idClients; }
    public void setIdClients(Long idClients) {this.idClients = idClients; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Client() {
    }

    public Client(String clientName,String email, String number) {
        this.clientName = clientName;
        this.email = email;
        this.number = number;
    }
}
