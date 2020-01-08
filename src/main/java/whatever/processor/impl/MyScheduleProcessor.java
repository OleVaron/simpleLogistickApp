package whatever.processor.impl;

import whatever.model.DistributionCenter;
import whatever.model.Order;
import whatever.model.Resource;
import whatever.processor.ScheduleProcessor;
import whatever.service.RoutingService;
import whatever.service.impl.SimpleRoutingService;

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
            for (Order order: resource.getOrders()) {
                i++;
                order.getStartTimeWindow();
                long minToTarget;
                long minToDCAndToTarget;
                Long departTime;
                System.out.println("getStartTimeWindow() "+new Date(order.getStartTimeWindow()));
                if (i == 0) {
                    minToTarget = ((resource.getSpeed() / routingService.getDistance(dc.getLat(), dc.getLng(), order.getLat(), order.getLng()) * 60));
                    minToTarget+= order.getLoadTime();
                    minToTarget+= order.getUnloadTime();

                    departTime = order.getStartTimeWindow() - minToTarget;
                } else {
                    Order privOrder = resource.getOrders().get(i-1);
                    minToTarget = ((resource.getSpeed() / routingService.getDistance(privOrder.getLat(), privOrder.getLng(), order.getLat(), order.getLng()) * 60));
                }


//                minToTargetArray[i] = minToTarget;
//
//                minToDCAndToTarget


            }
        }
    }


}
