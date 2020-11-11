package com.company.graphs;

import java.nio.file.Path;
import java.util.*;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Vertex> vertexMap = new HashMap<>();


    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if(v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    public void addEdge(String from, String to, double cost) {
        Vertex vFrom = getVertex(from);
        Vertex vTo = getVertex(to);
        vFrom.adj.add(new Edge(vTo, cost));
    }

    private void clearAll() {
        for(Vertex v : vertexMap.values()) {
            v.reset();
        }
    }

    private void printPath(Vertex dest) {
        if(dest.prev != null) {
            printPath(dest.prev);
            System.out.println("to ");
        }
        System.out.println(dest.name);
    }

    public void printPath(String destName) {
        Vertex v = vertexMap.get(destName);
        if(v == null) {
            throw new NoSuchElementException();
        } else if (v.dist == INFINITY) {
            System.out.println(destName + " is unreachable.");
        } else {
            System.out.println( "(Cost is: " + v.dist + ") " );
            printPath(v);
            System.out.println();
        }
    }

    public void unweighted(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NoSuchElementException("Start vertex not found");
        }

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;

        while(!q.isEmpty()) {
            Vertex v = q.remove();

            for(Edge e : v.adj) {
                Vertex w = e.dest;

                if(w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }

    }

    public void dijkstra(String startName) {
        PriorityQueue<Path> pq = new PriorityQueue<>();

        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NullPointerException();
        }

        clearAll();
        pq.add(new Path(start, 0));
        start.dist = 0;

        int nodeSeen = 0;
        while(!pq.isEmpty() && nodeSeen < vertexMap.size()) {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if(v.scratch != 0) {
                continue;
            }
            v.scratch = 1;
            nodeSeen++;

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(cvw < 0) {
                    throw new GraphException("Graph has negative edges, not possible with Dijkstra");
                }

                if(w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }
    }

    // basic item stored in the priority que
    class Path implements Comparable<Path> {

        public Vertex dest;
        public double cost;

        public Path(Vertex dest, double cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path rhs) {
            double otherCost = rhs.cost;
            return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
        }
    }

    // works for graphs with negative costs (Dijkstra does not)
    public void negative(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NullPointerException();
        }

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;
        start.scratch++;

        while(!q.isEmpty()) {
            Vertex v = ((LinkedList<Vertex>) q).removeFirst();
            if(v.scratch++ > 2 * vertexMap.size()) {
                throw new GraphException("Negative cycle detected");
            }

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if(w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;

                    if(w.scratch++ % 2 == 0) {
                        q.add(w);
                    } else {
                        w.scratch--;
                    }
                }
            }
        }
    }

    public void acyclic(String startName) {

    }

    public static boolean processRequest(Scanner in, Graph g) {
        try {
            System.out.println("Enter start node: ");
            String startName = in.nextLine();

            System.out.println("Enter destination node: ");
            String destName = in.nextLine();

            System.out.println("Enter algorithm (u, d, n, a) : ");
            String alg = in.nextLine();

            switch(alg) {
                case "u":
                    g.unweighted(startName);
                case "d":
                    g.dijkstra(startName);
                case "n":
                    g.negative(startName);
                case "a":
                    g.acyclic(startName);
                default:
                    System.out.println("wrong input");
            }
            g.printPath(destName);
        } catch (NoSuchElementException e) {
            return false;
        } catch (GraphException e) {
            System.err.println(e);
        }
        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Scanner s = new Scanner("My scanner for Graph algorithms");
        processRequest(s, g);
    }

}

class GraphException extends RuntimeException {
    public GraphException(String name) {
        super(name);
    }
}
