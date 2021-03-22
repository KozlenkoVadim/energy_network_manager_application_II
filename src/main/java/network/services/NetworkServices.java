package network.services;

import network.model.Node;

import java.io.File;
import java.util.List;

public interface NetworkServices {

    //This method assigns a value "null" to the link to your network
    void deleteNetwork(Node network);

    // This method searches for your networks in the path you specify.
    // PathName is the path to the desired directory
    // And returns the list of files type "name.json"
    List<File> searchNetworks(String pathName);
}
