package network;


import lombok.Getter;
import lombok.Setter;
import network.model.Node;
import network.model.Params;
import network.model.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@Getter
@Setter
public class NetworkBuilder {
    private static final Logger LOGGER = Logger.getLogger(NetworkBuilder.class.toString());
    private Node network;
    private List<String> list;

    public Node execute() {
        NodeBuilderFabric newNetwork = new NodeBuilderFabric();
        newNetwork = create(Types.NETWORK,newNetwork);

        int numberOfSub = scan(Types.NETWORK);
        for (int i = 0; i < numberOfSub; i++) {
            NodeBuilderFabric newSubstation = new NodeBuilderFabric();
            newSubstation = create(Types.SUBSTATION,newSubstation);

            int numberOfTrance = scan(Types.SUBSTATION);
            for (int a = 0; a < numberOfTrance; a++) {
                NodeBuilderFabric newTransformer = new NodeBuilderFabric();
                newTransformer = create(Types.TRANSFORMER, newTransformer);

                int numberOfFeed = scan(Types.TRANSFORMER);
                for (int r = 0; r < numberOfFeed; r++) {
                    NodeBuilderFabric newFeeder = new NodeBuilderFabric();
                    newFeeder = create(Types.FEEDER,newFeeder);

                    int numberOfRes = scan(Types.FEEDER);
                    for (int m = 0; m < numberOfRes; m++) {
                        NodeBuilderFabric newResource = new NodeBuilderFabric();
                        newResource = createRes(newResource);

                        newFeeder.getNewNode().setChild(newResource.getNewNode());
                    }
                    newTransformer.getNewNode().setChild(newFeeder.getNewNode());
                }
                newSubstation.getNewNode().setChild(newTransformer.getNewNode());
            }
            newNetwork.getNewNode().setChild(newSubstation.getNewNode());
        }
        this.network = newNetwork.getNewNode();
        LOGGER.info("Network model created !");
        return network;
    }

    private int scan(Types types) {
        int number = 0;
        System.out.println("Write the number of children for yours " + types + ": ");
        Scanner scanner1 = new Scanner(System.in);
        number = scanner1.nextInt();
        return number;
    }

    private NodeBuilderFabric createRes(NodeBuilderFabric newNodeBuilderFabric) {
        list = new ArrayList<>();
        System.out.println("Write the name, description, consumes(int value) for yours " + Types.RESOURCE + ": ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            list.add(scanner.nextLine());
            list.add(scanner.nextLine());
            list.add(String.valueOf(scanner.nextInt()));
            list.add(scanner.nextLine());
        }
        newNodeBuilderFabric
                .buildEntry(generateId(Types.RESOURCE),
                        Types.RESOURCE,
                        list.get(0),
                        list.get(1),
                        Params.builder()
                                .consumes(Integer.valueOf(list.get(2)))
                                .units(list.get(3))
                                .build());
        return newNodeBuilderFabric;
    }

    private NodeBuilderFabric create(Types types, NodeBuilderFabric newNodeBuilderFabric) {
        list = new ArrayList<>();
        System.out.println("Write the name, description,longitude(double value),latitude(double value) for yours " + types + ": ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            list.add(scanner.nextLine());
            list.add(scanner.nextLine());
            list.add(String.valueOf(scanner.nextDouble()));
            list.add(String.valueOf(scanner.nextDouble()));
        }
        newNodeBuilderFabric
                .buildEntry(generateId(types),
                        types,
                        list.get(0),
                        list.get(1),
                        Params.builder()
                                .lon(Double.valueOf(list.get(2)))
                                .lat(Double.valueOf(list.get(3)))
                                .build());
        return newNodeBuilderFabric;
    }

    private String generateId(Types types) {
        String id = types.toString() + (int) (Math.random() * 100);
        return id;
    }

    @Override
    public String toString() {
        return network.toString();
    }
}
