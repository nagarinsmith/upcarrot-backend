package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.Repository.TestRepository;
import com.upcarrot.UpCarrot.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService extends BaseService {

    @Autowired
    private TestRepository testRepository;



    @Override
    public BaseRepository getRepository() {
        return testRepository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return Test.class;
    }
}
