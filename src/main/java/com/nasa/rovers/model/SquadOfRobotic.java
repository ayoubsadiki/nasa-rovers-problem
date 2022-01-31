package com.nasa.rovers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SquadOfRobotic {

    private Plateau plateau;
    private List<Rover> rovers = new ArrayList<>();
    private List<String> roversInstructions = new ArrayList<>();

    public SquadOfRobotic() {
    }

    public SquadOfRobotic(Plateau plateau, List<Rover> rovers, List<String> roversInstructions) {
        this.plateau = plateau;
        this.rovers = rovers;
        this.roversInstructions = roversInstructions;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public List<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public List<String> getRoversInstructions() {
        return roversInstructions;
    }

    public void setRoversInstructions(List<String> roversInstructions) {
        this.roversInstructions = roversInstructions;
    }

    @Override
    public String toString() {
        return rovers.stream().map(Rover::toString).collect(Collectors.joining("\n"));
    }
}
