package com.strzalkom.domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class State {

    private int id;

    private String description;

    private int reward = 100;

    protected int lenghtInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public State(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {

        if (started) {
            this.startDate = LocalDateTime.now();
        }

        this.started = started;
    }

    public boolean isCompleted() {

        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime stateEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);

            boolean isAfter = now.isAfter(stateEndDate);

            if (isAfter) {
                this.completed = true;
            }

            return isAfter;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReward() {
        return reward;
    }
}
