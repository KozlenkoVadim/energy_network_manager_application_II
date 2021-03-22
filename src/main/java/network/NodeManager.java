package network;

import network.model.Node;
import network.services.NodeServices;

public class NodeManager implements NodeServices {

    private static void print(String string) {
        System.out.println(string);
    }


    @Override
    public Node searchNodeInNetwork(Node network, String id) {
        Node entry = null;
        try {
            if (network.getId().equals(id)) {
                print("Your node is " + network.getName() + " !");
                entry = network;
            } else {
                for (Node node : network.getChildren()) {
                    if (node.getId().equals(id)) {
                        print("Your node is " + node.getName() + " !");
                        entry = node;
                    } else if (node.getChildren() != null) {
                        searchNodeInNetwork(node, id);
                    }
                }
            }
        } catch (NullPointerException e) {
            print("You entered an incorrect node name, entry's id, or it does not exist! ");
        }
        return entry;
    }

    @Override
    public Node deleteNodeFromNetwork(Node network, String id) {
        try {
            if (!network.getId().equals(id)) {
                if (network.getChildren() != null) {
                    for (int i = 0; i < network.getChildren().size(); i++) {
                        if (network.getChildren().get(i).getId().equals(id)) {
                            network.getChildren().remove(i);
                        } else {
                            deleteNodeFromNetwork(network.getChildren().get(i), id);
                        }
                    }
                } else {
                    network = null;
                }
            } else {
                network = null;
            }
        } catch (NullPointerException e) {
            print("You entered an incorrect network name, or it does not exist! ");
        }
        return network;
    }

    @Override
    public Node updateNode(Node network, String id, String field, String newParam) {
        Node node = new NodeManager().searchNodeInNetwork(network, id);
        switch (field) {
            case "id":
                node.setId(newParam);
            case "name":
                node.setName(newParam);
            case "description":
                node.setDescription(newParam);
        }
        return node;
    }

    @Override
    public Node addNode(Node network, Node node, String parentId) {
        Node parent = new NodeManager().searchNodeInNetwork(network, parentId);
        parent.setChild(node);
        return network;
    }
}