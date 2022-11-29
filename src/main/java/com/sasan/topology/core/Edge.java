package com.sasan.topology.core;

import java.io.Serializable;
import java.util.List;

public record Edge(Integer source, Integer destination) implements Serializable {}

