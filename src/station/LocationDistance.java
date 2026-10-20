package station;
public class LocationDistance {

    /**
     * Calculate distance between 2 points (decimal degrees) using Haversine formula.
     * @param latitude1 latitude of point 1
     * @param longitude1 longitude of point 1
     * @param latitude2 latitude of point 2
     * @param longitude2 longitude of point 2
     * @return distance between point 1 and point 2 in kilometers.
     */
    public static double distanceCalculator(double latitude1, double longitude1, double latitude2, double longitude2){
        final double radiusOfEarth = 6371.0;

        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);
        longitude1 = Math.toRadians(longitude1);
        longitude2 = Math.toRadians(longitude2);

        // Haversine formula reviewed from https://www.movable-type.co.uk/scripts/latlong.html
        double latitudeDistance  = latitude2 - latitude1;
        double longitudeDistance  = longitude2 - longitude1;
        double a = Math.pow(Math.sin(latitudeDistance/2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(longitudeDistance/2),2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radiusOfEarth * c;
    }
}
