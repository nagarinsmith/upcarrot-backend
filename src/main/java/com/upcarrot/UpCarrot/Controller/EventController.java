package com.upcarrot.UpCarrot.Controller;

import com.upcarrot.UpCarrot.Dto.EventDTO;
import com.upcarrot.UpCarrot.Dto.ExpenseBorrowedDto;
import com.upcarrot.UpCarrot.Model.Event;
import com.upcarrot.UpCarrot.Model.ExpenseBorrowed;
import com.upcarrot.UpCarrot.Model.Status;
import com.upcarrot.UpCarrot.Model.User;
import com.upcarrot.UpCarrot.Service.BaseService;
import com.upcarrot.UpCarrot.Service.EventService;
import com.upcarrot.UpCarrot.Service.ExpenseBorrowedService;
import com.upcarrot.UpCarrot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenseBorrowedService expenseBorrowedService;


    /*
    PUT /events/add_expense/:id => adaugare de expense in eventul cu :id dat
    //DELETE /event/:id -> delete the event with :id
    // DELETE /event/expense/ -> delete the event with :id
     */

    @GetMapping
    public ResponseEntity getAllUserEvents(Principal principal)
    {
        var user = userService.getUserByEmail(principal.getName());

        return new ResponseEntity<>(eventService.getByUser(user).stream().map(EventDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity createNewEvent(
            @RequestBody EventDTO dto
            ){

        List<User> users = dto.getListOfUsers()
                .stream()
                .map(userString -> userService.getUserByEmail(userString)).filter(Objects::nonNull).collect(Collectors.toList());
        Date date1 = Date.from(Instant.parse(dto.getDate()));
        Status status1 = dto.getStatus().equals("OPEN")?Status.open:dto.getStatus().equals("PENDING")?Status.pending:Status.closed;

        eventService.create(new Event(users,new ArrayList<>(),dto.getName(),date1,status1));

        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/add_expense/{id}")
    public ResponseEntity addExpense(
            @RequestBody ExpenseBorrowedDto dto,
            @PathVariable String id
            ){
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        ExpenseBorrowed expenseBorrowed = expenseBorrowedService.addExpense(user, dto.getDescription(),
                dto.getTotal(), dto.getCategory(),
                dto.getDate(), dto.getOtherParticipant(), dto.getStatus());
        Event event = eventService.getById(id);
        event.getListOfExpenses().add(expenseBorrowed);
        eventService.update(event);
        expenseBorrowedService.delete(expenseBorrowed.getId());
        return new ResponseEntity<>("",HttpStatus.OK);
    }
    @DeleteMapping("/{eventId}/expense/{expenseId}")
    public ResponseEntity deleteExpenseFromEvent(
            @PathVariable String eventId,
            @PathVariable String expenseId
    ){
        Event event = eventService.getById(eventId);
//        event.getListOfExpenses().removeIf(e->e.getId()==null);
        event.getListOfExpenses().removeIf(expense->expense.getId().equals(expenseId));
        eventService.update(event);
        return new ResponseEntity<>("",HttpStatus.OK);
    }

    @PutMapping("/close/{id}")
    public ResponseEntity closeEvent(@PathVariable String id)
    {
        Event event = eventService.getById(id);
        var users = event.getListOfUsers();
        var listOfExpenses = event.getListOfExpenses();
        var numberOfUsers = users.size();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date(Instant.now().toEpochMilli());
        var currentDate = dateFormat.format(date);
        for (ExpenseBorrowed exp: listOfExpenses
        ) {
            var total = exp.getTotal();
            var perUser = total / numberOfUsers;
            var userExp = exp.getUser();
            for (User user: users
            ) {
                expenseBorrowedService.addBorrowed(userExp, "", perUser, null, currentDate, user.getEmail(), null);
            }
        }
        event.setStatus(Status.closed);
        eventService.update(event);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
