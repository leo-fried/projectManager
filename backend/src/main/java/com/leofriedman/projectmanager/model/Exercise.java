package com.leofriedman.projectmanager.model;

import jakarta.persistence.*;

@Entity
public class Exercise{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // Unique identifier for the exercise

    private String name;          // Exercise name
    private int reps;             // List of repetitions for each set
    private float weight;         // Weight lifted (in kg or lbs)
    private String intensity;     // Intensity level (e.g., "RIR', "RPE", etc.)

    @ManyToOne
    @JoinColumn(name = "lift_id", nullable = false) // Foreign Key to Lift
    private Lift lift; // Lift associated with the exercise

    public Exercise() {}

    public Exercise(String name, int reps, float weight, String intensity) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.intensity = intensity;
    }

    public Long getId() {
        return id;
    }
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
