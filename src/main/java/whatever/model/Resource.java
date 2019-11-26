package whatever.model;

import java.util.ArrayList;

public class Resource {
    long speed;
    long capacity;
    ArrayList<Order> orders;

    public Resource(long speed, long capacity) {
        this.speed = speed;
        this.capacity = capacity;
        this.orders = new ArrayList<Order>();
    }

    public Resource() {
        this.speed = 50;
        this.capacity = 2000;
        this.orders = new ArrayList<Order>();
    }

    public long getSpeed() {
        return speed;
    }

    public long getCapacity() {
        return capacity;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
