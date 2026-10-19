import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Station{
    private final String stationId;
    private final StationZone stationZone;
    private final int maxDockingPoints;
    private final List<Vehicle> dockedVehicles;

    // Constructor
    public Station(String stationId, StationZone stationZone, int maxDockingPoints){
        this.stationId = stationId;
        this.stationZone = stationZone;
        this.maxDockingPoints = maxDockingPoints;
        this.dockedVehicles = new ArrayList<>();
    }

    // Public getters for accessing information about the station
    public String getStationId() {
        return stationId;
    }
    public String getStationZoneId() {
        return stationZoneId;
    }
    public int getMaxDockingPoints() {
        return maxDockingPoints;
    }
    public List<Vehicle> getDockedVehicles() {
        return Collections.unmodifiableList(dockedVehicles);
    }

    /**
     * Check whether there are vehicles available to be rented.
     * @return true if there is a vehicle available at the station, otherwise false.
     */
    public boolean hasVehicleAvailability(){
        return !dockedVehicles.isEmpty();
    }

    /**
     * Check whether there is available space at a docking station
     * @return true if space is available, false if the docking station is full
     */
    public boolean hasFreeDockingPoint(){
        return maxDockingPoints > dockedVehicles.size();
    }

    /**
     * Check whether a docking station is too full
     * @return true if there's no more available space at a docking station, false if there is space available.
     */
    public boolean isTooFull(){
        return maxDockingPoints == dockedVehicles.size();
    }

    /**
     * Check whether a docking station is too empty by checking if there's no available vehicles there.
     * @return true if a station is empty, false if the station has one or more vehicles available.
     */
    public boolean isTooEmpty(){
        return dockedVehicles.isEmpty();
    }

    /**
     * Add vehicle to a docking station
     * @param vehicle vehicle that needs to be added
     * @return true if vehicle is added successfully, false if vehicle could not be added.
     */
    public boolean addVehicleToStation(Vehicle vehicle){
        if(vehicle != null && hasFreeDockingPoint()){
            dockedVehicles.add(vehicle);
            return true;
        }
        return false;
    }

    /**
     * Remove a vehicle from a docking station
     * @param vehicle vehicle that needs to be removed
     * @return true if vehicle is removed successfully, false if vehicle could not be removed.
     */
    public boolean removeVehicleFromStation(Vehicle vehicle){
        if (vehicle != null && dockedVehicles.contains(vehicle)) {
            dockedVehicles.remove(vehicle);
            return true;
        }
        return false;
    }

}

