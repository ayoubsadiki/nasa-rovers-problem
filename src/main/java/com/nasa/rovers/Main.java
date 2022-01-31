package com.nasa.rovers;

import com.nasa.rovers.model.SquadOfRobotic;
import com.nasa.rovers.service.IFileParseService;
import com.nasa.rovers.service.INavigateService;
import com.nasa.rovers.service.NavigationService;
import com.nasa.rovers.service.TextParseService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static IFileParseService fileParseService = new TextParseService();
    static INavigateService navigateService = new NavigationService();

    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            String filename = args[0];
            Path file = Paths.get(filename);
            SquadOfRobotic squadOfRobotic = fileParseService.parse(file);
            navigateService.explore(squadOfRobotic);
            System.out.println(squadOfRobotic.toString());
        } else {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }
}
