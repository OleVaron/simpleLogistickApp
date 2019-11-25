package whatever.model;

import java.util.ArrayList;

public class DistributionCenter {
    float lat;
    float lng;
    long startWorkTime;
    long endWorkTime;
    ArrayList<Resource> fleet;


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
}
