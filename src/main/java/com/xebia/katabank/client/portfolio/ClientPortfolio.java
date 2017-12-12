package com.xebia.katabank.client.portfolio;

import com.xebia.katabank.client.entities.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Repository qui sotcke les clients en mémoire
 */
@Named
public class ClientPortfolio implements IClientPortfolio {

    Map<String, Client> allClients = new HashMap<>();

    public ClientPortfolio() {
        Client client = new Client("3a841dea-df4d-11e7-80c1-9a214cf093ae","pierre-jean", "unknown", "pierre-jean");
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
    public List<Client> getAllClients() {
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
