package com.sasan.topology.core.usecase;

import com.sasan.topology.core.Path;

import java.util.List;

public interface ShortPathUsecase {
    public List<Integer> find(Path path);
}
