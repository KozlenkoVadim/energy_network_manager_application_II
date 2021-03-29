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
public class NetworkBuilder{
    private static final Logger LOGGER = Logger.getLogger(NetworkBuilder.class.toString());
    private Node network;

    public Node execute() {
        NodeBuilderFabric newNetwork = new NodeBuilderFabric();
        List<String> list = toCreate(Types.NETWORK);
        newNetwork.toBuild(toGenerateId(Types.NETWORK), Types.NETWORK, list.get(0), list.get(1), Params.builder().lon(Double.valueOf(list.get(2))).lat(Double.valueOf(list.get(3))).build());
        int numberOfSub = toScan(Types.NETWORK);
        for (int i = 0; i < numberOfSub; i++) {
            NodeBuilderFabric newSubstation = new NodeBuilderFabric();
            List<String> listS = toCreate(Types.SUBSTATION);
            newSubstation.toBuild(toGenerateId(Types.SUBSTATION), Types.SUBSTATION, listS.get(0), listS.get(1), Params.builder().lon(Double.valueOf(listS.get(2))).lat(Double.valueOf(listS.get(3))).build());
            int numberOfTrance = toScan(Types.SUBSTATION);
            for (int a = 0; a < numberOfTrance; a++) {
                NodeBuilderFabric newTransformer = new NodeBuilderFabric();
                List<String> listT = toCreate(Types.TRANSFORMER);
                newTransformer.toBuild(toGenerateId(Types.TRANSFORMER), Types.TRANSFORMER,listT.get(0), listT.get(1), Params.builder().lon(Double.valueOf(listT.get(2))).lat(Double.valueOf(listT.get(3))).build() );
                int numberOfFeed = toScan(Types.TRANSFORMER);
                for (int r = 0; r < numberOfFeed; r++) {
                    NodeBuilderFabric newFeeder = new NodeBuilderFabric();
                    List<String> listF = toCreate(Types.FEEDER);
                    newFeeder.toBuild(toGenerateId(Types.FEEDER), Types.FEEDER,listF.get(0), listF.get(1), Params.builder().lon(Double.valueOf(listF.get(2))).lat(Double.valueOf(listF.get(3))).build() );
                    int numberOfRes = toScan(Types.FEEDER);
                    for (int m = 0; m < numberOfRes; m++) {
                        NodeBuilderFabric newResource = new NodeBuilderFabric();
                        List<String> listR = toCreateRes();
                        newResource.toBuild(toGenerateId(Types.RESOURCE), Types.RESOURCE, listR.get(0),listR.get(1), Params.builder().consumes(Integer.valueOf(listR.get(2))).units(listR.get(3)).build() );
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

    private int toScan(Types types) {
        int number = 0;
            System.out.println("Write the number of children for yours " + types + ": ");
            Scanner scanner1 = new Scanner(System.in);
            number = scanner1.nextInt();
        return number;
    }
        private List<String> toCreateRes() {
            List<String> list = new ArrayList<String>();
            System.out.println("Write the name,description,consumes(*),units for yours " + Types.RESOURCE + ": ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                list.add(scanner.nextLine());
                list.add(scanner.nextLine());
                list.add(String.valueOf(scanner.nextInt()));
                list.add(scanner.nextLine());
            }
            return list;
        }
        private List<String> toCreate(Types types) {
            List<String> list = new ArrayList<String>();
            System.out.println("Write the name,description,longitude(*.*),latitude(*.*) for yours " + types + ": ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                list.add(scanner.nextLine());
                list.add(scanner.nextLine());
                list.add(String.valueOf(scanner.nextDouble()));
                list.add(String.valueOf(scanner.nextDouble()));
            }
            return list;
        }

    private String toGenerateId(Types types) {
        String id = types.toString() + (int) (Math.random() * 100);
        return id;
    }

    @Override
    public String toString() {
        return network.toString();
    }
}
