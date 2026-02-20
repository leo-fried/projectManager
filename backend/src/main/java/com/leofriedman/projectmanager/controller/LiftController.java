package com.leofriedman.projectmanager.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.leofriedman.projectmanager.dto.LiftEntry;
import com.leofriedman.projectmanager.model.Lift;
import com.leofriedman.projectmanager.model.User;
import com.leofriedman.projectmanager.service.LiftService;
import com.leofriedman.projectmanager.service.UserService;

@RestController
@RequestMapping("api/lifts")
public class LiftController 
{
    private final UserService userService;
    private final LiftService service;
    public LiftController(LiftService service, UserService userService)
    {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public List<Lift> getAllLifts(){
        return service.getAllLifts();
    }

    @GetMapping("/{id}")
    public Lift getLift(@PathVariable Long id)
    {
        return service.getLiftById(id);
    }

    @PostMapping
    public Lift createLift(@Valid @RequestBody LiftEntry liftEntry, @RequestHeader("X-User-ID") Long userId)
    {
        User user = userService.getUserById(userId); // Fetch the user based on the provided user ID
        return service.createLift(liftEntry, user);
    }

    @PutMapping("/{id}")
    public Lift updateLift(@PathVariable Long id, @RequestBody Lift lift)
    {
        return service.updateLift(id, lift);
    }

    @DeleteMapping("/{id}")
    public void deleteLift(@PathVariable Long id)
    {
        service.deleteLift(id);
    }
}
