package network;

import network.services.NetworkServices;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkServicesImplTest {

    @Test
    void deleteNetwork() {
    }

    @Test
    void searchNetworks() {
        NetworkServices networkServices;
        networkServices =  new NetworkServicesImpl();
        networkServices.searchNetworks("/media/vadim_kozlenko/MyFiles/GitRepositories/Energy_network_manager_application/src/main/resources/");

    }

    @Test
    void load() {
    }

    @Test
    void save() {
    }
}