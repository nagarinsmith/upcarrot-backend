package com.upcarrot.UpCarrot.Repository;

import com.upcarrot.UpCarrot.model.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends
        MongoRepository<T, String> {

     T getById(String id);


}
