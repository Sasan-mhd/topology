package com.sasan.topology.core;

import java.io.Serializable;
import java.util.List;

public record Graph(List<Integer> nodes, List<Edge> edges) implements Serializable {
}
