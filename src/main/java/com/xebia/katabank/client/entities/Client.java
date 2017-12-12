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

    public Client(String id, String login, String lastName, String firstName) {
        this.id = UUID.fromString(id);
        this.login = login;
        this.lastName = lastName;
        this.firstName = firstName;
    }

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

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
