package network;

import network.model.Node;
import network.model.Params;
import network.model.Types;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class NodeBuilderFabricTest {

    @Test
    void toBuild() {
        NodeBuilderFabric nodeBuilderFabric = new NodeBuilderFabric();
        Node actualNode = nodeBuilderFabric.toBuild("id-1", Types.NETWORK,"nt-1","main-network", Params.builder().lon(40.3).lat(40.3).build());
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
    void toBuildFeilure() {
        NodeBuilderFabric nodeBuilderFabric = new NodeBuilderFabric();
        Node actualNode = nodeBuilderFabric.toBuild("id- 1",Types.NETWORK,"nt- 1","main network", Params.builder().lon(40.3).lat(40.3).build());
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
    void toBuildRes() {
        NodeBuilderFabric nodeBuilderFabric = new NodeBuilderFabric();
        Node actualNode = nodeBuilderFabric.toBuild("rsc-10",Types.RESOURCE,"Consumer","Load that belong to fdr-2", Params.builder().consumes("10").units("MWatt").build());
        System.out.println(actualNode.toString());
        Node expected = new Node();
        expected.setId("rsc-10");
        expected.setType(Types.RESOURCE);
        expected.setName("Consumer");
        expected.setDescription("Load that belong to fdr-2");
        expected.setParams(Params.builder().consumes("10").units("MWatt").build());
        expected.setChildren(null);
        Assert.assertEquals(actualNode, expected);
    }

    @Test
    void toBuildResFeilure() {
        NodeBuilderFabric nodeBuilderFabric = new NodeBuilderFabric();
        Node actualNode = nodeBuilderFabric.toBuild("rsc-10",Types.RESOURCE,"Consumer","Load that belong to fdr-2", Params.builder().consumes("10").units("MWatt").build());
        System.out.println(actualNode.toString());
        Node expected = new Node();
        expected.setId("rsc-10");
        expected.setType(Types.RESOURCE);
        expected.setName("Consumer");
        expected.setDescription("Load that belong to fdr-2");
        expected.setParams(Params.builder().consumes("10").units("MWatt").build());
        expected.setChildren(new ArrayList<>());
        Assert.assertEquals(actualNode, expected);
    }
}