package network.services;

import network.model.Node;

import java.util.List;

public interface NetworkServices {

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

    void deleteNetwork(Node network);

    List<String> searchNetworks();
}
