package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.model.BaseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * If we need  a simple crud controller we will extend this
 *
 * @param <T>
 */
public abstract class BaseController<T extends BaseEntity> {
    public abstract BaseService<T> getService();


    @GetMapping("/{id}")
    public Response getById(@PathVariable String id) {
        T entity = getService().getById(id);
        return new Response(getService().mapToBasicDtoClass(entity));
    }

    @GetMapping
    public Response getAll() {
        return new Response(getService().getAll());
    }

    @PostMapping
    public Response create(@RequestBody T entity) {
        return new Response(getService().create(entity));
    }

    @PutMapping("/{id}")
    public Response update(@RequestBody T entity) {
        return new Response(getService().update(entity));
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable String id) {
        getService().delete(id);
        return new Response(null);
    }

}