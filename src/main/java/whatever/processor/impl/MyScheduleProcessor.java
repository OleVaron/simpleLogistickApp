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
    long loungeTimeStart;
    long loungeTimeEnd;

    public MyScheduleProcessor(DistributionCenter distributionCenter) {
        dc = distributionCenter;
    }

    @Override
    public void process() {
        System.out.println("-------------------Start planning-------------------");
        for (Resource resource: dc.getFleet() ) {
//            long[] minToTargetArray = new long[resource.getOrders().size()];
//            long[] minToDCAndToTargetArray = new long[resource.getOrders().size()];
            long plannedStartTime = 0;
            long timeAfterOrderComplete = 0;
            int i = -1;
            int groupOrdersIndex = 0;
            ArrayList<ArrayList<Order>> groupOfOrders = new ArrayList<>();


            for (Order order: resource.getOrders()) {
                i++;

                long timeToTarget= 0;
                long timeToDC= 0;
                long timeFromDCToTarget= 0;


                if (i == 0) {
                    groupOfOrders.add(new ArrayList<>());
                    groupOfOrders.get(groupOrdersIndex).add(order);
//                    bunchOfOrders.get(groupOrdersIndex).add(order);
                    timeToTarget = (long)getTimeBetweenTargets(dc, order, resource.getSpeed());
                    timeToTarget+= order.getLoadTime();
//                    timeToTarget+= order.getUnloadTime();
                    plannedStartTime = order.getStartTimeWindow() - timeToTarget;
                    timeAfterOrderComplete = order.getStartTimeWindow() + order.getUnloadTime();
                    System.out.println("Order 1 depart from DC"+new Date(plannedStartTime));
                    System.out.println("Order 1 start time    "+new Date(order.getStartTimeWindow()));
                    System.out.println("Order 1 compleate     "+new Date(timeAfterOrderComplete));
                } else {
                    Order privOrder = resource.getOrders().get(i-1);
                    timeToTarget = (long)getTimeBetweenTargets(privOrder, order, resource.getSpeed());
                    timeToDC = (long)getTimeBetweenTargets(privOrder, dc, resource.getSpeed());
                    timeFromDCToTarget = (long)getTimeBetweenTargets(dc, order, resource.getSpeed());
                    if (inTime(timeAfterOrderComplete + timeToTarget, order)) {
//                        if () {
//
//                        }
                    }
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

    protected boolean inTime(long timePoint, Order order) {
        if ((order.getStartTimeWindow() < timePoint) && (order.getEndTimeWindow() > timePoint)) {
            return true;
        }
        return false;
    }

//    protected boolean canAddLoadTime(long startTime, ) {
//
//    }


    void print(long sec) {
        System.out.println(new Date(sec));
    }



}
