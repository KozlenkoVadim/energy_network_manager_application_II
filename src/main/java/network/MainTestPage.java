package network;

import network.model.Node;
import network.services.NetworkServices;

import java.io.IOException;

public class MainTestPage {

    public static void main(String[] args) throws IOException {

        while (true) {
            Node network;

            NetworkBuilder networkBuilder = new NetworkBuilder();
            network = networkBuilder.execute();

            NetworkServices.overview(network);

            }
        }
    }


