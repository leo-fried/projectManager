package com.leofriedman.projectmanager.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

/**
 * Lift Class
 */
@Entity
public class Lift {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate liftDate;

    @OneToMany(mappedBy = "lift", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Exercise> exercises; // List of exercises associated with the lift

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign Key to User
    private User user; // User associated with the lift

    /**
     * Default Constructor
     */
    public Lift() {}

    /**
     * Parameterized constructor
     * @param title lift title
     * @param description lift description
     */
    public Lift(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters and Setters

    /**
     * Gets the lift ID
     * @return the lift ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the lift title
     * @return the lift title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the lift title
     * @param title the lift title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the lift description
     * @return the lift description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the lift description
     * @param description the lift description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Gets the lift due date
     * @return the lift due date
     */
    public LocalDate getLiftDate() {
        return liftDate;
    }
    /**
     * Sets the lift due date
     * @param liftDate the lift due date to set
     */
    public void setLiftDate(LocalDate liftDate) {
        this.liftDate = liftDate;
    }
    /**
     * Gets the user associated with the lift
     * @return the user associated with the lift
     */
    public User getUser() {
        return user;
    }
    /**
     * Sets the user associated with the lift
     * @param user the user to associate with the lift
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Gets the exercises associated with the lift
     * @return the exercises associated with the lift
     */
    public List<Exercise> getExercises() {
        return exercises;
    }
    /**
     * Sets the exercises associated with the lift
     * @param exercises the exercises to associate with the lift
     */    public void setExercises(List<Exercise> exercises) 
     {
        this.exercises = exercises;
     }
}   
