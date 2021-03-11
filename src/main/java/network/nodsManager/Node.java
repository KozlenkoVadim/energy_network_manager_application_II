package network.nodsManager;



import java.util.ArrayList;

public class Node {
    private String id;
    private Types type;
    private String name;
    private String descriptions;
    private Params params;
    private ArrayList<Node> children = new ArrayList<>();

    private Node(String id, Types type, String name, String descriptions, Params params, ArrayList<Node> children) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.descriptions = descriptions;
        this.params = params;
        this.children = children;
    }

    private Node(String id, Types type, String name, String descriptions, Params params) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.descriptions = descriptions;
        this.params = params;
    }

    public static Node createNodeTypeNetwork(String id, Types type, String name, String descriptions, Params params, ArrayList<Node> children){
        return new Node(id, Types.NETWORK, name, descriptions, Params.createParamsForNodeTypeNotResources(params.getLon(), params.getLat()), children);
    }

    public static Node createNodeTypeSubstation(String id, Types type, String name, String descriptions, Params params, ArrayList<Node> children){
        return new Node(id, Types.SUBSTATION, name, descriptions, Params.createParamsForNodeTypeNotResources(params.getLon(), params.getLat()), children);
    }

    public static Node createNodeTypeTransformer(String id, Types type, String name, String descriptions, Params params, ArrayList<Node> children){
        return new Node(id, Types.TRANSFORMER, name, descriptions, Params.createParamsForNodeTypeNotResources(params.getLon(), params.getLat()), children);
    }

    public static Node createNodeTypeFeeder(String id, Types type, String name, String descriptions, Params params, ArrayList<Node> children){
        return new Node(id, Types.FEEDER, name, descriptions, Params.createParamsForNodeTypeNotResources(params.getLon(), params.getLat()), children);
    }

    public static Node createNodeTypeResource(String id, Types type, String name, String descriptions, Params params){
        return new Node(id, Types.RESOURCE, name, descriptions, Params.createParamsForNodeTypeResources(params.getConsumes(), params.getUnits()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{ " +
                "id= '" + id + '\'' +
                ", type= " + type +
                ", name='" + name + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", params=" + params +
                ", children=" + children +
                '}';
    }
}
