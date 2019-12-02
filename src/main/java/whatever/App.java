package whatever;

import whatever.model.Order;
import whatever.model.Resource;
import whatever.service.OSRMRouting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        try {
            Long aLong =  OSRMRouting.getPathDuration();
            System.out.println(aLong);
        } catch (Exception e) {
            System.out.println(e);
        }
//        ArrayList<Resource> resources = getTestFleet(10);
    }

    public static ArrayList<Resource> getTestFleet(int count) {
        ArrayList<Resource> resources = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            resources.add(new Resource());
        }
        fillByFakeOrder(resources, 10);
        return resources;
    }

    public static ArrayList<Resource> fillByFakeOrder(ArrayList<Resource> resources, int count) {
        Random r = new Random();
        for (Resource resource: resources) {
            for (int i = 0; i < r.nextInt(count)+1; i++) {
                Order order = new Order();
                resource.getOrders().add(order);
                System.out.println(order);
            }
        }
        return resources;
    }

}
