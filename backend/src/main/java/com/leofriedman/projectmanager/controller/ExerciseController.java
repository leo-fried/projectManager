package com.leofriedman.projectmanager.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

import com.leofriedman.projectmanager.dto.ExerciseEntry;
import com.leofriedman.projectmanager.model.Exercise;
import com.leofriedman.projectmanager.service.ExerciseService;

@RestController
@RequestMapping("api/exercises")
public class ExerciseController 
{
    private final ExerciseService service;
    public ExerciseController(ExerciseService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Exercise> getAllExercises(){
        return service.getAllExercises();
    }

    @GetMapping("/{id}")
    public Exercise getExercise(@PathVariable Long id)
    {
        return service.getExerciseById(id);
    }

    @PostMapping
    public Exercise createExercise(@Valid @RequestBody ExerciseEntry exerciseEntry)
    {
        
        return service.createExercise(exerciseEntry);
    }

    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise updatedExercise)
    {
        return service.updateExercise(id, updatedExercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id)
    {
        service.deleteExercise(id);
    }
}
