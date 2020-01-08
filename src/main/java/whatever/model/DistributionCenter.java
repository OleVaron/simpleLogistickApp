package whatever.model;

import java.util.ArrayList;

import static whatever.App.getTestFleet;

public class DistributionCenter {
    float lat;
    float lng;
    long startWorkTime;
    long endWorkTime;
    ArrayList<Resource> fleet;


    public DistributionCenter() {
        this.lat = 53.22f;
        this.lng = 50.20f;
        this.startWorkTime = 1000*60*8;
        this.endWorkTime = 1000*60*22;
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

}
