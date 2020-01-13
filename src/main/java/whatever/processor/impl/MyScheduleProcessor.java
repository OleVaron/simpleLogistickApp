package whatever.processor.impl;

import whatever.model.DistributionCenter;
import whatever.model.Order;
import whatever.model.Resource;
import whatever.processor.Location;
import whatever.processor.ScheduleProcessor;
import whatever.service.RoutingService;
import whatever.service.impl.SimpleRoutingService;

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
        for (Resource resource: dc.getFleet() ) {
//            long[] minToTargetArray = new long[resource.getOrders().size()];
//            long[] minToDCAndToTargetArray = new long[resource.getOrders().size()];

            int i = -1;
            int groupOrdersIndex = 0;
            ArrayList<ArrayList<Order>> bunchOfOrders = new ArrayList<>();

            for (Order order: resource.getOrders()) {
                i++;
                long minToTarget;
                long minToDC;
                long minFromDCToTarget;
                Long departTime;

                if (i == 0) {
//                    minToTarget = ((resource.getSpeed() / routingService.getDistance(dc.getLat(), dc.getLng(), order.getLat(), order.getLng()) * 60));
                    minToTarget = (long)getMinutesBetweenTargets(dc, order, resource.getSpeed())+1;
                    minToTarget+= order.getLoadTime();
                    minToTarget+= order.getUnloadTime();
//                    departTime = order.getStartTimeWindow() - minToTarget;
                } else {
                    Order privOrder = resource.getOrders().get(i-1);
                    minToTarget = (long)getMinutesBetweenTargets(privOrder, order, resource.getSpeed())+1;
                    minToDC = (long)getMinutesBetweenTargets(privOrder, dc, resource.getSpeed())+1;
                    minFromDCToTarget = (long)getMinutesBetweenTargets(dc, order, resource.getSpeed())+1;
                    order.getStartTimeWindowSec();
                    System.out.println("minToTarget: "+minToTarget+" minToDC:"+minToDC+" minFromDCToTarget:"+minFromDCToTarget);
                }
//                minToTargetArray[i] = minToTarget;
//                minToDCAndToTarget
            }
        }
    }

    protected float getMinutesBetweenTargets(Location startPoint, Location endPoint, long metersPerSecond) {
        float result = ((float)routingService.getDistance(startPoint.getLat(), startPoint.getLng(), endPoint.getLat(), endPoint.getLng() ) / metersPerSecond);
        return result * 60;
    }


}
