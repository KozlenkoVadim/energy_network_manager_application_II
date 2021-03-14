package network.model;


import network.services.NetworkManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;

class NodeTest {
    public String pathName = "/media/vadim_kozlenko/MyFiles/GitRepositories/Energy_network_manager_application/src/main/resources/";

    @Test
    void initNetwork() throws IOException {
        Node newNetwork = new NetworkManager().load("sn.json",pathName);
        System.out.println(newNetwork.toString());

    }

    @Test
    void createNetwork() {
        Node actualNode = Node.builder().id("id-1").type(Types.NETWORK).name("nt-1").description("main-network").params(Params.builder().lon(40.3).lat(40.3).build()).children(new ArrayList<>()).build();
        System.out.println(actualNode.toString());
        Node expected = new Node();
        expected.setId("id-1");
        expected.setType(Types.NETWORK);
        expected.setName("nt-1");
        expected.setDescription("main-network");
        expected.setParams(Params.builder().lon(40.3).lat(40.3).build());
        expected.setChildren(new ArrayList<>());
        Assert.assertEquals(actualNode, expected);
    }

    @Test
    void createNetworkFailure() {
        Node actualNode = Node.builder().id("id-1").type(Types.NETWORK).name("nt-1").description("main-network").params(Params.builder().lon(40.3).lat(40.3).build()).children(new ArrayList<>()).build();
        Node expected = new Node();
        expected.setId("id-2");
        expected.setType(Types.NETWORK);
        expected.setName("nt-2");
        expected.setDescription("main-network");
        expected.setParams(Params.builder().lon(40.2).lat(40.4).build());
        expected.setChildren(new ArrayList<>());
        Assert.assertEquals(actualNode, expected);
    }
}