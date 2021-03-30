package network;


import lombok.Data;
import network.model.Node;
import network.model.Params;
import network.model.Types;
import network.services.NodeServices;

import java.util.Locale;
import java.util.logging.Logger;

@Data
public class NodeManager implements NodeServices {
    private static final Logger LOGGER = Logger.getLogger(NodeManager.class.toString());
    private Node entry;
    private Node node;
    private Node network;

    @Override
    public Node searchNodeInNetwork(Node network, String id) {
        LOGGER.info("searching... ");
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
        LOGGER.info("completed successfully !");
        return entry;
    }

    @Override
    public Node deleteNodeFromNetwork(Node network, String id) {
        LOGGER.info("trying delete node which have id: " + id);
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
            LOGGER.info("you entered an incorrect network name, or it does not exist! ");
        }
        LOGGER.info("completed successfully !");
        return network;
    }

    @Override
    public Node updateNode(Node network, String id, String field, String newParam) {
        LOGGER.info("trying update node which have id: " + id);
        NodeManager nodeManager = new NodeManager();
        node = nodeManager.searchNodeInNetwork(network, id);
        if (node.getType().equals(Types.NETWORK) || node.getType().equals(Types.SUBSTATION) || node.getType().equals(Types.TRANSFORMER) || node.getType().equals(Types.FEEDER)) {
            switch (field) {
                case "id":
                    node.setId(newParam);
                    break;
                case "name":
                    node.setName(newParam);
                    break;
                case "description":
                    node.setDescription(newParam);
                    break;
                case "params":
                    node.setParams(Params.builder().lon(Double.valueOf(newParam)).lat(Double.valueOf(newParam)).build());
                    break;
            }
        } else {
            switch (field) {
                case "id":
                    node.setId(newParam);
                    break;
                case "name":
                    node.setName(newParam);
                    break;
                case "description":
                    node.setDescription(newParam);
                    break;
                case "params":
                    node.setParams(Params.builder().consumes(Integer.valueOf(newParam)).units(newParam).build());
                    break;
            }
        }
        LOGGER.info("completed successfully !");
        return network;
    }

    @Override
    public Node addNode(Node network, Node node, String parentId) {
        LOGGER.info("trying to add node");
        NodeManager nodeManager = new NodeManager();
        nodeManager.searchNodeInNetwork(network, parentId).setChild(node);
        LOGGER.info("completed successfully !");
        return network;
    }
}
