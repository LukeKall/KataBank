package com.xebia.katabank.Client;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
public class ClientRepository implements IClientRepository {

    Map<String, Client> allClients = new HashMap<>();

    public ClientRepository() {
        Client client = new Client("pierre-jean", "unknown", "pierre-jean");
        allClients.put(client.getId().toString(), client);
    }

    @Override
    public Client getClient(String id) {
        return allClients.get(id);
    }

    @Override
    public void addClient(Client client) {
        throw new NotImplementedException();
    }

    @Override
    public void removeClient(Client client) {
        throw new NotImplementedException();
    }

    @Override
    public void updateClient(Client client) {
        throw new NotImplementedException();
    }

    @Override
    public List<Client> GetAllClients() {
        return new ArrayList<>(allClients.values());
    }

    @Override
    public Client getClientByLogin(String login) {
       return this.allClients.values()
               .stream()
               .filter(client -> client.getLogin().equals(login))
               .collect(Collectors.toList()).get(0);
    }
}
