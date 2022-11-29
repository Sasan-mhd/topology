package com.sasan.topology.core;

import com.sasan.topology.core.Graph;

public interface GraphDb {

    public void save(Graph graph);
    public Graph get();
}
