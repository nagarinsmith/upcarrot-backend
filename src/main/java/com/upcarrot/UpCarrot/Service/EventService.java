package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Model.Event;
import com.upcarrot.UpCarrot.Model.User;
import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService extends BaseService<Event> {

    @Autowired
    private EventRepository repository;

    @Override
    public BaseRepository<Event> getRepository() {
        return repository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return Event.class;
    }

    public List<Event> getByUser(User user){
        return repository.findAll().stream().filter(event-> event.getListOfUsers().contains(user)).collect(Collectors.toList());
    }
}
