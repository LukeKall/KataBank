package test.java.com.xebia.katabank.client.portfolio;

import com.xebia.katabank.client.entities.Client;
import com.xebia.katabank.client.portfolio.ClientPortfolio;

import java.util.ArrayList;
import java.util.List;

/**
 * Tests de la classe ClientPortfolio
 */
public class ClientPortfolioTest {

    @Inject
    ClientPortfolio clientPortfolio;

    @Test
    public void testGetClient(){
        Client client = new Client("3a841dea-df4d-11e7-80c1-9a214cf093ae","pierre-jean", "unknown", "pierre-jean");
        assertEquals(client, clientPortfolio.getClient("3a841dea-df4d-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testAddClient(){
        Client client = new Client("663d591c-df50-11e7-80c1-9a214cf093ae","pierre-jean", "unknown", "pierre-jean");
        clientPortfolio.addClient(client);
        assertNotNull(clientPortfolio.getClient("663d591c-df50-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testRemoveClient(){
        clientPortfolio.removeClient("3a841dea-df4d-11e7-80c1-9a214cf093ae");
        assertNull(clientPortfolio.getClient("3a841dea-df4d-11e7-80c1-9a214cf093ae"));
    }

    @Test
    public void testUpdateClient(){
        Client client = new Client("3a841dea-df4d-11e7-80c1-9a214cf093ae","pierre-jean", "other", "pierre-jean");
        clientPortfolio.updateClient(client);
        assertEquals("other", clientPortfolio.getClient("3a841dea-df4d-11e7-80c1-9a214cf093ae").getLastName());
    }

    @Test
    public void testGetAllClients(){
        Client client = new Client("663d591c-df50-11e7-80c1-9a214cf093ae","pierre-jean", "unknown", "pierre-jean");
        clientPortfolio.addClient(client);
        List<Client> clientListTemoin = new ArrayList<>();
        clientListTemoin.add(client);
        clientListTemoin.add( clientPortfolio.getClient("3a841dea-df4d-11e7-80c1-9a214cf093ae"));
        List<Client> results = clientPortfolio.getAllClients();
        assertEquals(2, results.size());
        assertTrue(clientListTemoin.containsAll(results));
    }

    @Test
    public void testGetClientByLogin(){
        Client client = new Client("3a841dea-df4d-11e7-80c1-9a214cf093ae","pierre-jean", "unknown", "pierre-jean");
        assertEquals(client, clientPortfolio.getClientByLogin("pierre-jean"));
    }
}
