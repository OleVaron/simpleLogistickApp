package whatever;

import whatever.model.Order;
import whatever.model.Resource;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<Resource> resources = getTestFleet(10);
    }

    public static ArrayList<Resource> getTestFleet(int count) {
        ArrayList<Resource> resources = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            resources.add(new Resource());
        }

        return resources;
    }

    public static ArrayList<Resource> fillFakeOrder(ArrayList<Resource> resources, int count) {
        for (Resource resource: resources) {
            for (int i = 0; i < count; i++) {
                resource.getOrders().add(new Order());
            }

        }
        return resources;
    }

}
