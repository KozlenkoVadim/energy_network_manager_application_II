package network.services;

import network.nodsManager.Node;

public interface NodeServices {

    Node searchNodeInNetwork(Node network, String id);

    void deleteNodeFromNetwork(Node network, String id);

    Node updateNode(Node network, String id);


}
