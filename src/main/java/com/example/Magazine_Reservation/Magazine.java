package com.example.Magazine_Reservation;

public class Magazine {
    private Long id;
    private String title;
    private String description;
    private boolean available;

    // Constructeur, Getters et Setters
    public Magazine(Long id, String title, String description, boolean available) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}