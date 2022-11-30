package com.sasan.topology.core;


public interface GraphDb {

    public void save(Graph graph);
    public Graph get();
}
