package com.sasan.topology.core;

import java.io.Serializable;

public record Path(Integer pathSource, Integer pathDestination) implements Serializable {
}
