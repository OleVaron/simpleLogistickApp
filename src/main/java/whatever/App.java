package whatever;

import whatever.model.DistributionCenter;
import whatever.model.Order;
import whatever.model.Resource;
import whatever.processor.ScheduleProcessor;
import whatever.processor.impl.MyScheduleProcessor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
//        float startLat = 53.216975f; //strait line
//        float startLng = 50.186870f;
//        float endLat   = 53.232319f;
//        float endLng   = 50.196973f;

        float startLat = 53.249308f;
        float startLng = 50.275468f;
        float endLat   = 53.196071f;
        float endLng   = 50.128869f;

//        OSRMRoutingService osrmRouting = new OSRMRoutingService();
//        System.out.println("osrmRouting = "+osrmRouting.getDistance(startLat, startLng, endLat, endLng));
//        SimpleRout ingService simpleRouting = new SimpleRoutingService();
//        System.out.println("simpleRouting = " +simpleRouting.getDistance(startLat, startLng, endLat, endLng));
        DistributionCenter dc = new DistributionCenter();
        ScheduleProcessor myScheduleProcessor = new MyScheduleProcessor(dc);
        myScheduleProcessor.process();
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

            for (int i = 0; i < 10; i++) {
//                for (int i = 0; i < r.nextInt(count)+1; i++) {
                Order order = new Order();
                resource.getOrders().add(order);
                System.out.println(order);
            }
            resource.getOrders().sort(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.getStartTimeWindow() > o2.getStartTimeWindow()) {
                        return 1;
                    } else if (o1.getStartTimeWindow() < o2.getStartTimeWindow()) {
                        return -1;
                    }
                    return 0;
                }
            });
        }
        return resources;
    }

}
