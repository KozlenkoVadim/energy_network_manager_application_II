package network;

import lombok.Data;
import network.model.Node;
import network.model.Params;
import network.model.Types;

import java.util.ArrayList;

@Data
public class NodeBuilderFabric {
    Node newNode;

    public Node toBuild(String id, Types types, String name, String description, Params params) {

        if (types.equals(Types.NETWORK) || types.equals(Types.SUBSTATION) || types.equals(Types.TRANSFORMER) || types.equals(Types.FEEDER)) {
            newNode = Node.builder().id(id).type(types).name(name).description(description).params(Params.builder().lat(params.getLat()).lon(params.getLon()).build()).children(new ArrayList<>()).build();
        } else if (types.equals(Types.RESOURCE)) {
            newNode = Node.builder().id(id).type(Types.RESOURCE).name(name).description(description).params(Params.builder().consumes(params.getConsumes()).units(params.getUnits()).build()).build();
        }
        return newNode;
    }

    @Override
    public String toString() {
        return newNode.toString();
    }
}
