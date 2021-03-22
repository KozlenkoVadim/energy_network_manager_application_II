package network.services;

import network.model.Node;

import java.io.IOException;

public interface NetworkRepository {
    public static final String PATH_NAME = "/media/vadim_kozlenko/MyFiles/GitRepositories/Energy_network_manager_application/src/main/resources/";

    Node load(String fileName) throws IOException;

    void save(Node network, String name);
}
