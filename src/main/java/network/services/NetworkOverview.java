package network.services;

import network.model.Node;

public class NetworkOverview {

        public static void overview(Node network) {
            try {
                print('{' + "id:" + network.getId() + '}' + " " + '{' + "name: " + network.getName() + '}' + " " + '{' + "description: " + network.getDescription() + '}');
                for (Node node : network.getChildren()) {
                    if (node.getChildren() != null) {
                        overview(node);
                    } else if (node.getChildren() == null) {
                        print('{' + "id:" + node.getId() + '}' + " " + '{' + "name: " + node.getName() + '}' + " " + '{' + "description: " + node.getDescription() + '}');
                    }
                }
            } catch (NullPointerException e) {
                print("You entered an incorrect network name, or it does not exist! ");
            }
        }
        private static void print(String string) {
            System.out.println(string);
        }
    }

