package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.model.BaseEntity;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


/**
 * Abstract class that offers basic crud functionality for one entity
 */
public abstract class BaseService<T extends BaseEntity> {
    public abstract BaseRepository<T> getRepository();

    public abstract Class<?> getBaseDtoClass();


    protected ModelMapper modelMapper;

    public BaseService() {
        this.modelMapper = new ModelMapper();
    }

    public Object mapToBasicDtoClass(T entity) {
        return modelMapper.map(entity, getBaseDtoClass());
    }

    public Object create(T entity) {
        return modelMapper.map(getRepository().save(entity), getBaseDtoClass());
    }

    public Object update(T entity) {
        return getRepository().findById((entity.getId()))
                .map(item -> modelMapper.map(getRepository().save(entity), getBaseDtoClass()))
                .orElse(null);
    }

    public <E> E getById(String id, Class<E> eClass) {
        return getRepository().findById(id).map((entity) -> modelMapper.map(entity, eClass)).orElse(null);
    }

    public <E> List<E> getAll(Class<E> eClass) {
        List<E> list = new ArrayList<>();
        getRepository().findAll().forEach((item) -> list.add(modelMapper.map(item, eClass)));
        return list;
    }

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(String id) {
        return getRepository().getById(id);
    }

    public void delete(String id) {
        getRepository().deleteById(id);
    }

}