package com.upcarrot.UpCarrot.Service;

import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.Repository.ExpenseBorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseBorrowedService extends BaseService {

    @Autowired
    private ExpenseBorrowedRepository repository;

    @Override
    public BaseRepository getRepository() {
        return repository;
    }

    @Override
    public Class<?> getBaseDtoClass() {
        return ExpenseBorrowed.class;
    }
}
