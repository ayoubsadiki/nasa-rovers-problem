package com.nasa.rovers.service;

import com.nasa.rovers.model.SquadOfRobotic;

import java.io.IOException;
import java.nio.file.Path;

public interface IFileParseService {

    SquadOfRobotic parse(Path file) throws IOException;
}
