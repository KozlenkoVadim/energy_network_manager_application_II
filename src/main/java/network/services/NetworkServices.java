package network.services;

import network.model.Node;

import java.io.File;
import java.util.List;

public interface NetworkServices {

    // This method can display model of your network like schema
    // and display it on console
    public static void toOverview(Node network) {
        try {
            System.out.println('{' + "id:" + network.getId() + '}' + " " + '{' + "name: " + network.getName() + '}' + " " + '{' + "description: " + network.getDescription() + '}');
            for (Node node : network.getChildren()) {
                if (node.getChildren() != null) {
                    toOverview(node);
                } else if (node.getChildren() == null) {
                    System.out.println('{' + "id:" + node.getId() + '}' + " " + '{' + "name: " + node.getName() + '}' + " " + '{' + "description: " + node.getDescription() + '}');
                }
            }
        } catch (NullPointerException e) {
            System.out.println("You entered an incorrect network name, or it does not exist! ");
        }
    }

    //This method assigns a value "null" to the link to your network
    void deleteNetwork(Node network);

    // This method searches for your networks in the path you specify.
    // PathName is the path to the desired directory
    // And returns the list of files type "name.json"
    List<File> searchNetworks(String pathName);
}
