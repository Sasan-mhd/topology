package com.sasan.topology.infrastructure.controller;

import com.sasan.topology.core.Graph;
import com.sasan.topology.core.Path;
import com.sasan.topology.core.usecase.PersistGraphUsecase;
import com.sasan.topology.core.usecase.ShortPathUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ShortPathUsecase shortPathUsecase;

    @Autowired
    private PersistGraphUsecase persistGraphUsecase;

    @PostMapping("/Topology")
    public void topology(@RequestBody Graph graph) {
        persistGraphUsecase.save(graph);
    }

    @PostMapping("/calculate-path")
    public List<Integer> calculatePath(@RequestBody Path path) {

        return shortPathUsecase.find(path);
    }
}
