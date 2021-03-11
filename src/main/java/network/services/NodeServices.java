package network.services;

import network.nodsManager.Node;

public interface NodeServices {

    public Node searchNodeInNetwork(Node network, String id);

    public void deleteNodeFromNetwork(Node network, String id);

    public Node updateNode(Node network, String id);


}
