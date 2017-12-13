package com.xebia.katabank.client.portfolio;

import com.xebia.katabank.client.entities.Client;

import java.util.List;

/**
 * Repository permettant de gérer la persistance des clients
 */
public interface IClientPortfolio {

    Client getClient(String id);
    void addClient(Client client);
    void removeClient(String id);
    void updateClient(Client client);
    List<Client> getAllClients();
    Client getClientByLogin(String login);
}
