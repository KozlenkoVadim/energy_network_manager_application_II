package network.services;

import network.nodsManager.Node;

public interface NetworkServices {

    public void buildNetwork();

    public void deleteNetwork(Node network);

    public void searchNetworksOnPc();

    public Node loadNetworkFromFile();

    public void toFile(Node network);


}
