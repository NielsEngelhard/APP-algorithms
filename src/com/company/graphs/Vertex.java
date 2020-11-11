package com.company.graphs;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> adj;
    public double dist;
    public Vertex prev;
    public int scratch;

    public Vertex(String name) {
        this.name = name;
        adj = new LinkedList<Edge>();
        reset();
    }

    public void reset() {
        this.dist = Graph.INFINITY;
        this.prev = null;
       //pos = null;
        this.scratch = 0;

    }
}
