package network.services;

import network.model.Node;

public interface NodeServices {

    // This method may search node you need by its id
    // in your created network
    Node searchNodeInNetwork(Node network, String id);

    // This method may search node you need by its id
    // in your created network and deletes it
    Node deleteNodeFromNetwork(Node network, String id);

    // This method may search node you need by its id
    // in your created network and can update fields you need
    Node updateNode(Node network, String id, String field, String newParam);

    //This method can Add new Node to your network by it parent id
    Node addNode(Node network, Node node, String parentId);

}
