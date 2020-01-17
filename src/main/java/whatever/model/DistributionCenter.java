package whatever.model;

import whatever.processor.Location;

import java.util.ArrayList;

import static whatever.App.getTestFleet;

public class DistributionCenter implements Location {

    float lat;
    float lng;
    long startWorkTime;
    long endWorkTime;
    ArrayList<Resource> fleet;


    public DistributionCenter() {
        this.lat = 53.22f;
        this.lng = 50.20f;

        this.startWorkTime = Order.DROP_TIME_START;
        this.endWorkTime = Order.DROP_TIME_END;
        this.fleet = getTestFleet(1);
    }

    public DistributionCenter(float lat, float lng, long beginWindowTime, long endWindowTime, ArrayList<Resource> fleet) {
        this.lat = lat;
        this.lng = lng;
        this.startWorkTime = beginWindowTime;
        this.endWorkTime = endWindowTime;
        this.fleet = fleet;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public long getBeginWindowTime() {
        return startWorkTime;
    }

    public long getEndWindowTime() {
        return endWorkTime;
    }

    public ArrayList<Resource> getFleet() {
        return fleet;
    }

    public void setFleet(ArrayList<Resource> fleet) {
        this.fleet = fleet;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lat/Lng = ").append(this.lat).append(" / ").append(this.lng).append("\n")
                .append("Work Time = ").append(this.startWorkTime).append(" / ").append(this.endWorkTime);
        return stringBuilder.toString();
    }

}
