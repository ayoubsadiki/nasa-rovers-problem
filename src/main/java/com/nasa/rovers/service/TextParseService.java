package com.nasa.rovers.service;

import com.nasa.rovers.model.DirectionEnum;
import com.nasa.rovers.model.Plateau;
import com.nasa.rovers.model.Rover;
import com.nasa.rovers.model.SquadOfRobotic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextParseService implements IFileParseService {

    @Override
    public SquadOfRobotic parse(Path file) throws IOException {
        List<String> allLines = Files.readAllLines(file, Charset.defaultCharset());
        if (allLines.isEmpty()) {
            throw new IllegalArgumentException("Input file is empty");
        }
        if (allLines.size() < 3 || allLines.size() % 2 != 1) {
            throw new IllegalArgumentException("the input file must contain coordinates of the plateau and rover's positions");
        }
        SquadOfRobotic squadOfRobotic = new SquadOfRobotic();
        String[] upperRightPlateau = allLines.get(0).split("\\s+");
        if (upperRightPlateau.length != 2) {
            throw new IllegalArgumentException("the plateau's coordinates consist of two number");
        }
        int upperPlateau = Integer.parseInt(upperRightPlateau[0]);
        int rightPlateau = Integer.parseInt(upperRightPlateau[1]);
        Plateau plateau = new Plateau(upperPlateau, rightPlateau);
        squadOfRobotic.setPlateau(plateau);

        for (int i = 1; i < allLines.size(); i += 2) {
            String[] roverCoordinates = allLines.get(i).split("\\s+");
            if (roverCoordinates.length != 3) {
                throw new IllegalArgumentException("the rover's postion consist of two number and one lettre");
            }
            int roverX = Integer.parseInt(roverCoordinates[0]);
            int roverY = Integer.parseInt(roverCoordinates[1]);
            DirectionEnum roverDirection = DirectionEnum.valueOf(roverCoordinates[2]);
            Rover rover = new Rover(roverX, roverY, roverDirection);
            squadOfRobotic.getRovers().add(rover);

            String roverInstructions = allLines.get(i + 1);
            squadOfRobotic.getRoversInstructions().add(roverInstructions);
        }

        return squadOfRobotic;
    }
}
