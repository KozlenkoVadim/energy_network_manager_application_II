package network;

public class MainTestPage {
    public static void main(String[] args) {
        NetworkBuilder networkBuilder = new NetworkBuilder();
        networkBuilder.execute();
        System.out.println(networkBuilder.getNetwork().toString());
    }
}
