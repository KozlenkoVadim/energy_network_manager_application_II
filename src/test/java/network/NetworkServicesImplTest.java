package network;

import network.model.Node;
import network.services.NetworkServices;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.Logger;

class NetworkServicesImplTest {
    private static final Logger LOGGER = Logger.getLogger("NetworkServicesImplTest");
    @Test
    void deleteNetwork() {
    }

    @Test
    void searchNetworks() {
        NetworkServices networkServices;
        networkServices =  new NetworkServicesImpl();
        networkServices.searchNetworks();

    }

    @Test
    void load() throws IOException {
        Node node;
            node = new NetworkServicesImpl().load("s.json");
        try {
            System.out.println(node.toString());
        }catch (NullPointerException e){
            LOGGER.info("node is null");
        }

    }

    @Test
    void save() {
    }
}