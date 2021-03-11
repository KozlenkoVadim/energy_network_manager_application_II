package network.services;

import network.nodsManager.Node;

public interface NetworkServices {

    void buildNetwork();

    void deleteNetwork(Node network);

    void searchNetworksOnPc();

    Node loadNetworkFromFile();

    void toFile(Node network);


}
