package network;


import lombok.Getter;
import lombok.Setter;
import network.model.Node;
import network.model.Params;
import network.model.Types;
import java.util.Scanner;
import java.util.logging.Logger;

@Getter
@Setter
public class NetworkBuilder {
    private static final Logger LOGGER = Logger.getLogger(NetworkBuilder.class.toString());
    private Node network;

    public Node execute() {
        NodeBuilderFabric newNetwork = create(Types.NETWORK, new NodeBuilderFabric());

        int numberOfSub = scan(Types.NETWORK);
        for (int i = 0; i < numberOfSub; i++) {
            NodeBuilderFabric newSubstation = create(Types.SUBSTATION, new NodeBuilderFabric());

            int numberOfTrance = scan(Types.SUBSTATION);
            for (int a = 0; a < numberOfTrance; a++) {
                NodeBuilderFabric newTransformer = create(Types.TRANSFORMER, new NodeBuilderFabric());

                int numberOfFeed = scan(Types.TRANSFORMER);
                for (int r = 0; r < numberOfFeed; r++) {
                    NodeBuilderFabric newFeeder = create(Types.FEEDER, new NodeBuilderFabric());

                    int numberOfRes = scan(Types.FEEDER);
                    for (int m = 0; m < numberOfRes; m++) {
                        NodeBuilderFabric newResource = createRes(new NodeBuilderFabric());

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
        System.out.println("Write the name, description, consumes(int value) for yours " + Types.RESOURCE + ": ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            newNodeBuilderFabric
                    .buildEntry(generateId(Types.RESOURCE),
                            Types.RESOURCE,
                            scanner.nextLine(),
                            scanner.nextLine(),
                            Params.builder()
                                    .consumes(scanner.nextInt()).units("MWatt")
                                    .build());
        }
        return newNodeBuilderFabric;
    }

    private NodeBuilderFabric create(Types types, NodeBuilderFabric newNodeBuilderFabric) {
        System.out.println("Write the name, description,longitude(double value),latitude(double value) for yours " + types + ": ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            newNodeBuilderFabric
                    .buildEntry(generateId(types),
                            types,
                            scanner.nextLine(),
                            scanner.nextLine(),
                            Params.builder()
                                    .lon(scanner.nextDouble())
                                    .lat(scanner.nextDouble())
                                    .build());
        }
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
