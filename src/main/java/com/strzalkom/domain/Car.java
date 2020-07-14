package com.strzalkom.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min=2, max=20,message = "Marka samochodu musi mieć:  3, a 20 znakow")
    private String name;

    @NotNull
    @Range(min=60, max=200, message = "Cena za dzień od 60 do 200 PLN")
    private int cost;


    private int level;

    @OneToOne
    private State state;

    public Car() {
        this.level = 1;
    }

    public Car(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.level = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return cost == car.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost);
    }

    public void setState(State state) {

        if(state !=null) {
            state.setStarted(true);
        }
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "Samochód o nazwie : " + name + "(" + cost + "). Jego aktualny stan: " + state;
    }
}
