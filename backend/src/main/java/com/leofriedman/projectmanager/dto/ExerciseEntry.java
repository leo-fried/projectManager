package com.leofriedman.projectmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class ExerciseEntry {

    @NotBlank(message = "Exercise name is required")
    private String name;          // Exercise name

    @NotBlank(message = "reps are required")
    private int reps;             // List of repetitions for each set

    @NotBlank(message = "weight is required")
    private float weight;         // Weight lifted (in kg or lbs)

    private String intensity;     // Intensity level (e.g., "light", "moderate", "heavy")

    public String getName() {
        return name;
    }   
    public void setName(String name) {
        this.name = name;
    }
    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String getIntensity() {
        return intensity;
    }
    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
