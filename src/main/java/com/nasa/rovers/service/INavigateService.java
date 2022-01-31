package com.nasa.rovers.service;

import com.nasa.rovers.model.SquadOfRobotic;

public interface INavigateService {
    void explore(SquadOfRobotic squadOfRobotic) throws IllegalArgumentException;
}
