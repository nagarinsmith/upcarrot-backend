package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Model.Event;
import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController extends BaseController<Event> {

    @Autowired
    private EventService eventService;

    @Override
    public BaseService<Event> getService() {
        return eventService;
    }
}
