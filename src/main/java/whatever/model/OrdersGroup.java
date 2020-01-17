package whatever.model;

import java.util.ArrayList;

public class OrdersGroup {
    ArrayList<Order> orders;
    DistributionCenter dc;

    public OrdersGroup(Order order) {
        this.orders = new ArrayList<>();
        this.orders.add(order);

    }

    boolean addOrder(Order order) {
        return false;
    }
}
