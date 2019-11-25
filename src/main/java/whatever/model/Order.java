package whatever.model;


import java.util.Random;

public class Order {
    static final float MIN_LAT_FOR_SAMARA = 53.183786f;
    static final float MAX_LAT_FOR_SAMARA = 53.258324f;
    static final float MIN_LNG_FOR_SAMARA = 50.095143f;
    static final float MAX_LNG_FOR_SAMARA = 50.238268f;
    static final long DROP_TIME_START = 1574755200000l; //26.11.19 08:00
    static final long DROP_TIME_END = 1574798400000l; //26.11.19 20:00


    float lat;
    float lng;
    long startTimeWindow;
    long endTimeWindow;
    int weight;
    long loadTime;
    long unloadTime;

    public Order(float lat, float lng, long startTimeWindow, long endTimeWindow, int weight, long loadTime, long unloadTime) {
        this.lat = lat;
        this.lng = lng;
        this.startTimeWindow = startTimeWindow;
        this.endTimeWindow = endTimeWindow;
        this.weight = weight;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;

    }

    public Order() {
        Random r = new Random();
        this.lat = MIN_LAT_FOR_SAMARA + r.nextFloat() * (MAX_LAT_FOR_SAMARA - MIN_LAT_FOR_SAMARA);
        this.lng = MIN_LNG_FOR_SAMARA + r.nextFloat() * (MAX_LNG_FOR_SAMARA - MIN_LNG_FOR_SAMARA);
        this.startTimeWindow = DROP_TIME_START * 
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public long getStartTimeWindow() {
        return startTimeWindow;
    }

    public long getEndTimeWindow() {
        return endTimeWindow;
    }

    public int getWeight() {
        return weight;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public long getUnloadTime() {
        return unloadTime;
    }
}
