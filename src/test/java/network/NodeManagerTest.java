package network;

import network.model.Node;
import network.model.Params;
import network.model.Types;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NodeManagerTest {

    @Test
    void searchNodeInNetwork() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        Node expected = new Node();
        expected.setId("rsc-10");
        expected.setType(Types.RESOURCE);
        expected.setName("Consumer");
        expected.setDescription("Load that belong to fdr-2");
        expected.setParams(Params.builder().consumes(10).units("MWatt").build());
        expected.setChildren(null);
        System.out.println(expected.toString());
        Assert.assertEquals(actual,expected);
    }

    @Test
    void deleteNodeFromNetwork() throws IOException {

    }

    @Test
    void updateNode() {
    }

    @Test
    void addNode() {
    }
}