package org.vaadin.example;

import java.util.List;

public class Starship {

    private String name;
    private String model;
    private String costInCredits;
    private String crew;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String starshipClass;
    private List<String> pilots;
    private List<String> films;

    public Starship(String name, String model, String costInCredits, String crew, String cargoCapacity, String consumables, String hyperdriveRating, String starshipClass, List<String> pilots, List<String> films) {
        this.name = name;
        this.model = model;
        this.costInCredits = costInCredits;
        this.crew = crew;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.hyperdriveRating = hyperdriveRating;
        this.starshipClass = starshipClass;
        this.pilots = pilots;
        this.films = films;
    }

    // Getters y Setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getCostInCredits() { return costInCredits; }
    public void setCostInCredits(String costInCredits) { this.costInCredits = costInCredits; }

    public String getCrew() { return crew; }
    public void setCrew(String crew) { this.crew = crew; }

    public String getCargoCapacity() { return cargoCapacity; }
    public void setCargoCapacity(String cargoCapacity) { this.cargoCapacity = cargoCapacity; }

    public String getConsumables() { return consumables; }
    public void setConsumables(String consumables) { this.consumables = consumables; }

    public String getHyperdriveRating() { return hyperdriveRating; }
    public void setHyperdriveRating(String hyperdriveRating) { this.hyperdriveRating = hyperdriveRating; }

    public String getStarshipClass() { return starshipClass; }
    public void setStarshipClass(String starshipClass) { this.starshipClass = starshipClass; }

    public List<String> getPilots() { return pilots; }
    public void setPilots(List<String> pilots) { this.pilots = pilots; }

    public List<String> getFilms() { return films; }
    public void setFilms(List<String> films) { this.films = films; }
}
