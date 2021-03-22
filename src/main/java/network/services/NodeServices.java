package network.services;

import network.model.Node;

public interface NodeServices {

    Node searchNodeInNetwork(Node network, String id);

    Node deleteNodeFromNetwork(Node network, String id);

    Node updateNode(Node network, String id, String field, String newParam);

    Node addNode(Node network, Node node, String parentId);

}
