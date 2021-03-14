package network.services;

import network.model.Node;

import java.io.File;
import java.util.List;

public interface NetworkServices {

    void deleteNetwork(Node network);

    List<File> searchNetworks(String pathName);
}
