package com.upcarrot.UpCarrot.Repository;

import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExpenseBorrowedRepository extends BaseRepository<ExpenseBorrowed> {

    ExpenseBorrowed getFirstByUserAndDateAndTotal(String user, Date date, Double total);
}
