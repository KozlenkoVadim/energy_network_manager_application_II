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
    void searchNodeInNetworkFailure() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        Node expected = new Node();
        expected.setId("rsc-1");
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
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        actual = nodeManager.deleteNodeFromNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        Node expected = networkServices.load("newNet.json");
        System.out.println(expected.toString());
        Assert.assertEquals(actual,expected);

    }
    @Test
    void deleteNodeFromNetworkFailure() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        actual = nodeManager.deleteNodeFromNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        Node expected = networkServices.load("sn.json");
        System.out.println(expected.toString());
        Assert.assertEquals(actual,expected);

    }

    @Test
    void updateNode() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        actual = nodeManager.updateNode(newNetwork,"rsc-10", "id", "rsc-14");
        networkServices.save(actual,"actualNet.json");
        System.out.println(actual.toString());
        Node expected = networkServices.load("actualNet.json");
        Assert.assertEquals(actual,expected);

    }

    @Test
    void updateNodeFailure() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        actual = nodeManager.updateNode(newNetwork,"rsc-10", "params", "30");
        Node expected = networkServices.load("sn.json");
        Assert.assertEquals(actual,expected);

    }

    @Test
    void addNode() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        newNetwork = networkServices.load("newNet.json");
        actual = nodeManager.addNode(newNetwork,actual,"fdr-2");
        System.out.println(actual.toString());
        Node expected = networkServices.load("sn.json");
        Assert.assertEquals(actual,expected);
    }


    @Test
    void addNodeFailure() throws IOException {
        NetworkServicesImpl networkServices = new NetworkServicesImpl();
        Node newNetwork = networkServices.load("sn.json");
        NodeManager nodeManager = new NodeManager();
        Node actual = nodeManager.searchNodeInNetwork(newNetwork,"rsc-10");
        System.out.println(actual.toString());
        newNetwork = networkServices.load("sn.json");
        actual = nodeManager.addNode(newNetwork,actual,"fdr-2");
        System.out.println(actual.toString());
        Node expected = networkServices.load("sn.json");
        Assert.assertEquals(actual,expected);
    }
}