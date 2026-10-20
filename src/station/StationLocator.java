package station;
import vehicle.Vehicle;
import java.util.List;

public class StationLocator {
    /**
     * Find the closest station to the current position of the vehicle.
     * Use the station.LocationDistance object in order to calculate the distance between the 2 geographical points.
     * @param vehicle vehicle used as reference to find the closest station
     * @param stations list of all stations
     * @return closest station to the vehicle from the list of stations.
     */
    public Station findClosestStation(Vehicle vehicle, List<Station> stations) {
        if (vehicle != null && stations != null && !stations.isEmpty()) {
            Station closestStation = null;
            double closestDistance = Double.MAX_VALUE;
            LocationDistance locationDistance = new LocationDistance();
            for (Station station : stations) {
                if(station.hasFreeDockingPoint()){
                    double distanceFromStation = LocationDistance.distanceCalculator(vehicle.getVehicleLatitude(), vehicle.getVehicleLongitude(), station.getStationLatitude(), station.getStationLongitude());
                    if(distanceFromStation < closestDistance){
                        closestDistance = distanceFromStation;
                        closestStation = station;
                    }
                }
            }
            return closestStation;
        }
        return null;
    }
}
