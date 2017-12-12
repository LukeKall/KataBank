package com.xebia.katabank.client.entities;

import java.util.UUID;

/**
 * Représente un client
 */
public class Client {

    private UUID id;
    private String login;
    private String lastName;
    private String firstName;

    public Client(String login, String lastName, String firstName) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
