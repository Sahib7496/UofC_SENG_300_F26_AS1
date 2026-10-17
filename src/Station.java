import java.util.ArrayList;

public class Station{
    private final String stationId;
    private final String stationZoneId;
    private final int maxDockingPoints;
    private final List<Vehicle> dockedVeicles;

    public Station(String station_id, String stationZone, String stationName, String stationZoneID, String stationId, String stationName1, String stationZoneId, int maxDockingPoints){
        this.stationId = stationId;
        this.stationZoneId = stationZoneId;
        this.maxDockingPoints = maxDockingPoints;
        this.dockedVeicles = new ArrayList<Vehicle>();
    }

}

