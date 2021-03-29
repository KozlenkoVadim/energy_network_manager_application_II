package network.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Params {
    private double lon;
    private double lat;
    private int consumes;
    private String units;

    @Override
    public String toString() {
        return
                "longitude = " + lon +"\n"+
                        "   " + "latitude = " + lat +"\n"+
                        "   " + "consumes = " + consumes +"\n"+
                        "   " + "units = " + units;
    }
}
