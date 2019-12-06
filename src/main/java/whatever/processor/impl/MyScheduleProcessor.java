package whatever.processor.impl;

import whatever.model.Resource;
import whatever.processor.ScheduleProcessor;

public class MyScheduleProcessor implements ScheduleProcessor {

    public MyScheduleProcessor() {

    }

    @Override
    public Resource process(Resource resource) {
        return resource;
    }
}
