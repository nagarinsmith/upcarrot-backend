package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Model.Event;
import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService {

    @Autowired
    private EventRepository repository;

    @Override
    public BaseRepository getRepository() {
        return repository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return Event.class;
    }
}
