package network.nodsManager;

public class Params {
    private double lon;
    private double lat;
    private String consumes;
    private String units;

    private Params() {
    }

    private Params(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    private Params(String cons, String uni) {
        this.consumes = cons;
        this.units = uni;
    }

    public static Params createParamsForNodeTypeNotResources(double lon, double lat) {
        return new Params(lon, lat);
    }

    public static Params createParamsForNodeTypeResources(String cons, String uni) {
        return new Params(cons, uni);
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getConsumes() {
        return consumes;
    }

    public void setConsumes(String consumes) {
        this.consumes = consumes;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return
                "longitude = " + lon + "\n" +
                        "   " + "latitude = " + lat + "\n" +
                        "   " + "consumes = " + consumes + "\n" +
                        "   " + "units = " + units;
    }
}
