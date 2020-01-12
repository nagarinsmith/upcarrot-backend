package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.Service.ExpenseBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense-borrowed")
public class ExpenseBorrowedController extends BaseController<ExpenseBorrowed> {

    @Autowired
    private ExpenseBorrowedService ExpenseBorrowedService;

    @Override
    public BaseService<ExpenseBorrowed> getService() {
        return ExpenseBorrowedService;
    }
}
