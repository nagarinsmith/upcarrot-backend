package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Dto.ExpenseBorrowedDto;
import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Model.ExpenseCategory;
import com.upcarrot.UpCarrot.Model.Status;
import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.Service.ExpenseBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;
@RestController
@RequestMapping("/expense-borrowed")
public class ExpenseBorrowedController extends BaseController<ExpenseBorrowed> {

    @Autowired
    private ExpenseBorrowedService ExpenseBorrowedService;

    @Override
    public BaseService<ExpenseBorrowed> getService() {
        return ExpenseBorrowedService;
    }

    @GetMapping("/expenses")
    public List<ExpenseBorrowed> getExpensesForUser() {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return ExpenseBorrowedService.getExpensesForUser(user);
    }
    @PostMapping("/expenses")
    public ResponseEntity addExpense(@RequestBody ExpenseBorrowedDto expenseBorrowedDto) {

        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        ExpenseBorrowedService.addExpense(user, expenseBorrowedDto.getDescription(),
                expenseBorrowedDto.getTotal(), expenseBorrowedDto.getCategory(),
                expenseBorrowedDto.getDate(), expenseBorrowedDto.getOtherParticipant(), expenseBorrowedDto.getStatus());
        return new ResponseEntity<>("Successfully add expense!", HttpStatus.OK);
    }
    @PostMapping("/borrowed")
    public ResponseEntity addBorrowed(@RequestBody ExpenseBorrowedDto expenseBorrowedDto) {
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        ExpenseBorrowedService.addBorrowed(user, expenseBorrowedDto.getDescription(),
                expenseBorrowedDto.getTotal(), expenseBorrowedDto.getCategory(),
                expenseBorrowedDto.getDate(), expenseBorrowedDto.getOtherParticipant(), expenseBorrowedDto.getStatus());
        return new ResponseEntity<>("Successfully add borrowed!", HttpStatus.OK);
    }
    @PutMapping("/borrowed/close/{id}")
    public ResponseEntity closeBorrowed(@PathVariable String id)
    {
        ExpenseBorrowedService.closeBorrowed(id);
        return new ResponseEntity<>("Successfully closed borrowed!", HttpStatus.OK);
    }

}
