package network.services;

import network.model.Node;

import java.io.IOException;

public interface NetworkRepository {

    // This method returns the model of network from Json file
    // You must assign the path to yours networks and
    // file name,from that you want to load
    Node load(String fileName, String pathName) throws IOException;

    // This method can save your network in file type ".json"
    // You must assign the path to yours networks and
    // file name,to save in it your network
    void save(Node network, String name, String pathName);
}
