package com.upcarrot.UpCarrot.Service;

import com.mongodb.lang.Nullable;
import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Model.ExpenseCategory;
import com.upcarrot.UpCarrot.Model.Status;
import com.upcarrot.UpCarrot.Repository.BaseRepository;
import com.upcarrot.UpCarrot.Repository.ExpenseBorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ExpenseBorrowed> getExpensesForUser(String user){
        var expenses = repository.findAll();
        return expenses.stream()
                .filter(expenseBorrowed -> expenseBorrowed.getUser()
                        .equals(user)).collect(Collectors.toList());
    }

    public ExpenseBorrowed addExpense(String user, @Nullable String description, Double total, ExpenseCategory category, String date, @Nullable String otherParticipant, Status status)
    {
        Date gDate = Date.from(Instant.parse(date));
        return repository.insert(
                new ExpenseBorrowed(user, description, total, category, gDate, otherParticipant, status));
    }

    public void addBorrowed(String user, @Nullable String description, Double total, ExpenseCategory category, String date, @Nullable String otherParticipant, Status status) {
        addExpense(user, description, total, ExpenseCategory.BORROWED, date, otherParticipant, Status.PENDING);
        addExpense(otherParticipant, description, total, ExpenseCategory.OWED, date, user, Status.OPEN);
    }

    public void closeBorrowed(String id) {
        ExpenseBorrowed expenseBorrowed = repository.getById(id);
        ExpenseBorrowed expenseBorrowed1 =
                repository.getFirstByUserAndDateAndTotal
                        (expenseBorrowed.getOtherParticipant(), expenseBorrowed.getDate(), expenseBorrowed.getTotal());
        expenseBorrowed.setStatus(Status.CLOSED);
        expenseBorrowed1.setStatus(Status.CLOSED);
        repository.save(expenseBorrowed);
        repository.save(expenseBorrowed1);
    }

}
