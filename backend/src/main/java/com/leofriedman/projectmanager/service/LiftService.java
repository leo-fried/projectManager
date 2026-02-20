package com.leofriedman.projectmanager.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.leofriedman.projectmanager.dto.LiftEntry;
import com.leofriedman.projectmanager.model.*;
import com.leofriedman.projectmanager.repository.LiftRepository;

@Service
public class LiftService {

    private final LiftRepository repository;
    
    public LiftService(LiftRepository repository)
    {
        this.repository = repository;
    }

    public List<Lift> getAllLifts()
    {
        return repository.findAll();
    }
    public Lift getLiftById(Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("lift with ID: " + id + " not found"));
    }
    public Lift createLift(LiftEntry liftEntry, User user)
    {
        Lift lift = new Lift();
        lift.setTitle(liftEntry.getTitle());
        lift.setDescription(liftEntry.getDescription());
        lift.setLiftDate(liftEntry.getLiftDate());
        lift.setUser(user);
        return repository.save(lift);
    }
    public Lift updateLift(Long id, Lift updatedlift)
    {
        Lift lift = getLiftById(id);
        lift.setTitle(updatedlift.getTitle());
        lift.setDescription(updatedlift.getDescription());
        lift.setLiftDate(updatedlift.getLiftDate());
        lift.setExercises(updatedlift.getExercises());
        return repository.save(lift);
    }
    public void deleteLift(Long id)
    {
        repository.deleteById(id);
    }
}
