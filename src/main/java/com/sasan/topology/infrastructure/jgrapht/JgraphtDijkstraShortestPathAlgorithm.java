package com.sasan.topology.infrastructure.jgrapht;

import com.sasan.topology.core.DijkstraShortestPathAlgorithm;
import com.sasan.topology.core.Graph;
import com.sasan.topology.core.Path;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JgraphtDijkstraShortestPathAlgorithm implements DijkstraShortestPathAlgorithm {

    @Override
    public List<Integer> calculate(Graph graph, Path path){

        List<Integer> shortestPathNodes = null;

        org.jgrapht.Graph<Integer, DefaultEdge> jGrapht =
                new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);

        graph.nodes().forEach(jGrapht::addVertex);
        graph.edges().forEach(edge -> jGrapht.addEdge(edge.source(), edge.destination()));


        DijkstraShortestPath<Integer, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(jGrapht);
        ShortestPathAlgorithm.SingleSourcePaths<Integer, DefaultEdge> paths = dijkstraAlg.getPaths(path.pathSource());

        var shortestPath = paths.getPath(path.pathDestination());
        if(shortestPath!=null){
            shortestPathNodes = shortestPath.getVertexList();
        }
        return shortestPathNodes;
    }
}
