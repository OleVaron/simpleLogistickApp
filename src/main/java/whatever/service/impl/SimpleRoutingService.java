package whatever.service.impl;

import whatever.service.RoutingService;


//https://www.geodatasource.com/developers/java
public class SimpleRoutingService implements RoutingService {

    public long getDistance(float startLat,float startLng,float endLat,float endLng){
        double theta = startLng - endLng;
        double dist = Math.sin(Math.toRadians(startLat)) * Math.sin(Math.toRadians(endLat)) + Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1609.344;
        return (long)dist;
    }
}
