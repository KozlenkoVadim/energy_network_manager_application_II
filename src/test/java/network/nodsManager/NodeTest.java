package network.nodsManager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void createNodeTypeNetwork() {
        Node newNode = Node.createNodeTypeNetwork("id-1", Types.NETWORK, "nt-1", "main - network", Params.createParamsForNodeTypeNotResources(50.3, 30.4), new ArrayList<>());
        System.out.println(newNode.toString());
    }

    @Test
    void createNodeTypeSubstation() {
        Node newNode = Node.createNodeTypeSubstation("id-2", Types.SUBSTATION, "sab-1", "main - sub", Params.createParamsForNodeTypeNotResources(50.3, 30.4), new ArrayList<>());
        System.out.println(newNode.toString());
    }

    @Test
    void createNodeTypeTransformer() {
        Node newNode = Node.createNodeTypeTransformer("id-1", Types.TRANSFORMER, "tr-1", "main - transformer", Params.createParamsForNodeTypeNotResources(50.3, 30.4), new ArrayList<>());
        System.out.println(newNode.toString());
    }

    @Test
    void createNodeTypeFeeder() {
        Node newNode = Node.createNodeTypeFeeder("id-1", Types.FEEDER, "feed-1", "main - feeder", Params.createParamsForNodeTypeNotResources(50.3, 30.4), new ArrayList<>());
        System.out.println(newNode.toString());
    }

    @Test
    void createNodeTypeResource() {
        Node newNode = Node.createNodeTypeResource("id-1", Types.RESOURCE, "res-1", "main - resource", Params.createParamsForNodeTypeResources("Mwat", "30"));
        System.out.println(newNode.toString());
    }
}