package com.leofriedman.projectmanager.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LiftEntry {
    // Name of lift
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be less than 100 characters")
    private String title;

    // lift Description (Optional)
    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @NotNull(message = "Lift date is required")
    private LocalDate liftDate;

    private Long userId; // ID of the user associated with the lift

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getLiftDate() {
        return liftDate;
    }
    public void setLiftDate(LocalDate liftDate) {
        this.liftDate = liftDate;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
