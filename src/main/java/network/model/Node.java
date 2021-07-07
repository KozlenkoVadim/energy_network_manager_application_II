package network.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  Node {
    private String id;
    private Types type;
    private String name;
    private String description;
    private Params params;
    private ArrayList<Node> children;

    public void setChild(Node child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return this.getType().toString() + ":" + "\n" +
                '{' + "\n" +
                "   " + "id = " + id + "\n" +
                "   " + "type = " + type + "\n" +
                "   " + "name = " + name + "\n" +
                "   " + "description = " + description + "\n" +
                "   " + getParams().toString() + "\n" +
                "   " + "children = " + children + "\n" +
                '}';
    }

}
