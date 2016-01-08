package org.idey.algo.ds;

import org.idey.algo.visitor.ListVisitor;
import org.idey.algo.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Graph<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Graph.class);
    private Map<GraphNode<T>, Set<GraphNode<T>>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public int size(){
        return map.size();
    }

    public Graph<T> addNode(GraphNode<T> graphNode){
        if(graphNode==null){
            throw new NullPointerException("Invalid Graph Node");
        }
        if(map.containsKey(graphNode)){
            LOGGER.error("Node {} already exists ", graphNode.toString());
            throw new IllegalArgumentException("Node already exists in the graph");
        }
        map.put(graphNode, new LinkedHashSet<>());
        return this;
    }

    public Graph<T> addNeighbour(GraphNode<T> objectGraphNode, GraphNode<T> neighbourGraphNode){
        if(objectGraphNode==null || neighbourGraphNode==null){
            throw new NullPointerException("Invalid graph nodes");
        }
        //Both of the node added to the graph
        if(map.containsKey(objectGraphNode) && map.containsKey(neighbourGraphNode)){
            map.get(objectGraphNode).add(neighbourGraphNode);
            map.get(neighbourGraphNode).add(objectGraphNode);
        }else{
            LOGGER.error("Either of these nodes {},{} do not added to the graph prior", objectGraphNode.toString(), neighbourGraphNode.toString());
            throw new IllegalArgumentException(String.format("Either of these nodes %s,%s do not added to the graph prior", objectGraphNode.toString(), neighbourGraphNode.toString()));
        }
        return this;
    }

    private void markAllNodesUnvisited(){
        for(GraphNode<T> graphNode:map.keySet()){
            graphNode.setUnVisited();
        }
    }

    public List<T> getAllNeighbours(T object){
        return getAllNeighboursTillCertainDepth(object,1);
    }


    public List<T> getAllNeighboursTillCertainDepth(T object, int depth){
        if(object==null){
            throw new NullPointerException("Invalid object passed");
        }
        if(depth<=0){
            throw new IllegalArgumentException("Invalid Depth, it should be greater than 0");
        }
        GraphNode<T> node = new GraphNode<>(object);

        if(!map.containsKey(node)){
            LOGGER.error("Supplied Node {} does not exists", node);
            throw new IllegalArgumentException("Supplied node does not exists");
        }



        //mark all node unvisited
        markAllNodesUnvisited();
        Visitor<T> visitor = new ListVisitor<>();
        addNeighbour(node, map.get(node), visitor, 1, depth);
        return ((ListVisitor<T>)visitor).getList();
    }

    private void addNeighbour(GraphNode<T> root, Set<GraphNode<T>> nodeSet, Visitor<T> visitor, int currentDepth, int maxDepth){
        if(nodeSet!=null && !nodeSet.isEmpty()){
            if(currentDepth<=maxDepth){
                for(GraphNode<T> n:nodeSet){
                    if(!root.equals(n) && n.getStatus()== GraphNode.VisitStatus.UNVISITED){
                        n.setVisited();
                        visitor.visit(n.getObject());
                    }
                    addNeighbour(root,map.get(n),visitor,currentDepth+1,maxDepth);
                }
            }
        }
    }

}
