package whatever.processor.impl;

import whatever.model.DistributionCenter;
import whatever.model.Order;
import whatever.model.OrdersGroup;
import whatever.model.Resource;
import whatever.processor.Location;
import whatever.processor.ScheduleProcessor;
import whatever.service.RoutingService;
import whatever.service.impl.SimpleRoutingService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;

public class MyScheduleProcessor implements ScheduleProcessor {

    RoutingService routingService = new SimpleRoutingService();
    DistributionCenter dc;

    public MyScheduleProcessor(DistributionCenter distributionCenter) {
        dc = distributionCenter;
    }

    @Override
    public void process() {
        System.out.println("-------------------Start planning-------------------");
        for (Resource resource: dc.getFleet() ) {
//            long[] minToTargetArray = new long[resource.getOrders().size()];
//            long[] minToDCAndToTargetArray = new long[resource.getOrders().size()];

            int i = -1;
            int groupOrdersIndex = 0;
            ArrayList<OrdersGroup> bunchOfOrders = new ArrayList<>();


            for (Order order: resource.getOrders()) {
                i++;
                long timeToTarget;
                long timeToDC;
                long timeFromDCToTarget;
                long plannedStartTime;

                if (i == 0) {
                    bunchOfOrders.add(new OrdersGroup(order, dc));
//                    bunchOfOrders.get(groupOrdersIndex).add(order);
                    timeToTarget = (long)getTimeBetweenTargets(dc, order, resource.getSpeed());
                    timeToTarget+= order.getLoadTime();
                    timeToTarget+= order.getUnloadTime();
                    plannedStartTime = order.getStartTimeWindow() - timeToTarget;
                    print(plannedStartTime);
                } else {
                    Order privOrder = resource.getOrders().get(i-1);
                    timeToTarget = (long)getTimeBetweenTargets(privOrder, order, resource.getSpeed());
                    timeToDC = (long)getTimeBetweenTargets(privOrder, dc, resource.getSpeed());
                    timeFromDCToTarget = (long)getTimeBetweenTargets(dc, order, resource.getSpeed());
                    order.getStartTimeWindow();
//                    System.out.println("minToTarget: "+minToTarget+" minToDC: "+minToDC+" minFromDCToTarget: "+minFromDCToTarget);
                }
//                minToTargetArray[i] = minToTarget;
//                minToDCAndToTarget
            }
        }
    }

    protected float getTimeBetweenTargets(Location startPoint, Location endPoint, long metersPerSecond) {
        float result = ((float)routingService.getDistance(startPoint.getLat(), startPoint.getLng(), endPoint.getLat(), endPoint.getLng() ) / metersPerSecond) * 60*60*1000;
        return result;
    }

    void print(long sec) {
        System.out.println(new Date(sec));
    }



}
