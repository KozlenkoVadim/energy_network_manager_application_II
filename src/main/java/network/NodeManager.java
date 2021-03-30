package network;


import lombok.Data;
import network.model.Node;
import network.services.NodeServices;

import java.util.logging.Logger;

@Data
public class NodeManager implements NodeServices {
    private static final Logger LOGGER = Logger.getLogger(NodeManager.class.toString());
    private Node entry;
    private Node node;
    private Node network;
    @Override
    public Node searchNodeInNetwork(Node network, String id) {

        try {
            if (network.getId().equals(id)) {
                LOGGER.info("Your node is " + network.getName() + " !");
                entry = network;
            } else {
                for (Node node : network.getChildren()) {
                    if (node.getId().equals(id)) {
                        LOGGER.info("Your node is " + node.getName() + " !");
                        entry = node;
                    } else if (node.getChildren() != null) {
                        searchNodeInNetwork(node, id);
                    }
                }
            }
        } catch (NullPointerException e) {
            LOGGER.info("You entered an incorrect node name, entry's id, or it does not exist! ");
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
            LOGGER.info("You entered an incorrect network name, or it does not exist! ");
        }
        return network;
    }

    @Override
    public Node updateNode(Node network, String id, String field, String newParam) {
        node = new NodeManager().searchNodeInNetwork(network, id);
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
