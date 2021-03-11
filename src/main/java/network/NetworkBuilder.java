package network;

import network.nodsManager.Node;
import network.services.NodeBuilder;

public abstract class NetworkBuilder implements NodeBuilder {
    @Override
    public Node toBuild() {
        return null;
    }
}
