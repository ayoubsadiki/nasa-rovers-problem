package com.nasa.rovers.service;

import com.nasa.rovers.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class NavigationService implements INavigateService {

    @Override
    public void explore(SquadOfRobotic squadOfRobotic) throws IllegalArgumentException {
        Plateau plateau = squadOfRobotic.getPlateau();
        List<Rover> rovers = squadOfRobotic.getRovers();
        List<String> roversInstructions = squadOfRobotic.getRoversInstructions();

        for (int i = 0; i < rovers.size(); i++) {
            List<InstructionEnum> roverInstructions = roversInstructions.get(i)
                    .chars()
                    .mapToObj(e -> InstructionEnum.valueOf((Character.valueOf((char) e)).toString()))
                    .collect(Collectors.toList());

            this.explore(plateau, rovers.get(i), roverInstructions);
        }
    }

    private void explore(Plateau plateau, Rover rover, List<InstructionEnum> instructions) throws IllegalArgumentException {

        for (InstructionEnum instruction : instructions) {
            switch (instruction) {
                case M:
                    this.move(plateau, rover);
                    break;
                case L:
                    this.spinLeft(rover);
                    break;
                case R:
                    this.spinRight(rover);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    private void spinLeft(Rover rover) {
        switch (rover.getDirection()) {
            case N:
                rover.setDirection(DirectionEnum.W);
                break;
            case S:
                rover.setDirection(DirectionEnum.E);
                break;
            case E:
                rover.setDirection(DirectionEnum.N);
                break;
            case W:
                rover.setDirection(DirectionEnum.S);
        }
    }

    private void spinRight(Rover rover) {
        switch (rover.getDirection()) {
            case N:
                rover.setDirection(DirectionEnum.E);
                break;
            case S:
                rover.setDirection(DirectionEnum.W);
                break;
            case E:
                rover.setDirection(DirectionEnum.S);
                break;
            case W:
                rover.setDirection(DirectionEnum.N);
        }
    }

    private void move(Plateau plateau, Rover rover) throws IllegalArgumentException {
        String exceptionMessage = "Invalid instruction: M,  rover out of plateau";
        switch (rover.getDirection()) {
            case N:
                int yn = rover.getY() + 1;
                if (yn > plateau.getUpper()) {
                    throw new IllegalArgumentException(exceptionMessage);
                }
                rover.setY(yn);
                break;
            case S:
                int ys = rover.getY() - 1;
                if (ys < 0) {
                    throw new IllegalArgumentException(exceptionMessage);
                }
                rover.setY(ys);
                break;
            case E:
                int xe = rover.getX() + 1;
                if (xe > plateau.getRight()) {
                    throw new IllegalArgumentException(exceptionMessage);
                }
                rover.setX(xe);
                break;
            case W:
                int xw = rover.getX() - 1;
                if (xw < 0) {
                    throw new IllegalArgumentException(exceptionMessage);
                }
                rover.setX(xw);
        }
    }
}
