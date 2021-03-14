package network.services;

import network.model.Node;

import java.io.IOException;

public interface SaveOrLoadService {

    Node load(String fileName, String pathName) throws IOException;

    void save(Node network, String name, String pathName);
}
