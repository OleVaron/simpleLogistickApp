package whatever.model;

import java.util.ArrayList;

public class OrdersGroup {
    ArrayList<Order> orders;
    DistributionCenter dc;

    public OrdersGroup(Order order, DistributionCenter dc) {
        this.orders = new ArrayList<>();
        this.orders.add(order);
        this.dc = dc;
    }

    boolean addOrder(Order order) {
        return false;
    }
}
