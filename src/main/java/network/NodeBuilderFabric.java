package network;

import lombok.Data;
import network.model.Node;
import network.model.Params;
import network.model.Types;

import java.util.ArrayList;
import java.util.logging.Logger;

@Data
public class NodeBuilderFabric{
    private static final Logger LOGGER = Logger.getLogger(NodeBuilderFabric.class.toString());
    private Node newNode;

    public Node buildEntry(String id, Types types, String name, String description, Params params) {

        if (types.equals(Types.NETWORK) || types.equals(Types.SUBSTATION) || types.equals(Types.TRANSFORMER) || types.equals(Types.FEEDER)) {
            newNode = Node.builder().id(id).type(types).name(name).description(description).params(Params.builder().lat(params.getLat()).lon(params.getLon()).build()).children(new ArrayList<>()).build();
            LOGGER.info(types + " created");
        } else if (types.equals(Types.RESOURCE)) {
            newNode = Node.builder().id(id).type(Types.RESOURCE).name(name).description(description).params(Params.builder().consumes(params.getConsumes()).units(params.getUnits()).build()).children(null).build();
            LOGGER.info(types + " created");
        }
        return newNode;
    }

    @Override
    public String toString() {
        return newNode.toString();
    }
}
