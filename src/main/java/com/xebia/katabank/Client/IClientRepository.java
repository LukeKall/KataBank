package com.xebia.katabank.Client;

import java.util.List;

public interface IClientRepository {

    Client getClient(String id);
    void addClient(Client client);
    void removeClient(Client client);
    void updateClient(Client client);
    List<Client> GetAllClients();
    Client getClientByLogin(String login);
}
