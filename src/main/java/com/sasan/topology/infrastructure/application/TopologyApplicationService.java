package com.sasan.topology.infrastructure.application;

import com.sasan.topology.core.DijkstraShortestPathAlgorithm;
import com.sasan.topology.core.Graph;
import com.sasan.topology.core.GraphDb;
import com.sasan.topology.core.Path;
import com.sasan.topology.core.usecase.PersistGraphUsecase;
import com.sasan.topology.core.usecase.ShortPathUsecase;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopologyApplicationService implements PersistGraphUsecase, ShortPathUsecase {

    @Autowired
    private GraphDb graphDb;

    @Autowired
    DijkstraShortestPathAlgorithm shortestPathAlgorithm;
    @Override
    public void save(Graph graph) {
        graphDb.save(graph);
    }

    @Override
    public List<Integer> find(Path path) {

        List<Integer> shortestPathNodes = null;
        Graph graph = graphDb.get();

        if(graph != null){
            shortestPathNodes = shortestPathAlgorithm.calculate(graph, path);
        }
        return shortestPathNodes;

    }



}

