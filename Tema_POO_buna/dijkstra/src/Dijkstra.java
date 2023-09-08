import java.util.PriorityQueue;

public class Dijkstra {

    /**
     * Dijkstra Algorithm
     * Calculate shortest paths from source vertex to the rest of vertices
     * @param sourceVertex start point
     */
    public void calculateShortestPath(Vertex sourceVertex) {
        sourceVertex.setDist(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();
            for (Street street : actualVertex.getList()) {
                Vertex v = street.getEndVertex();

                if (!v.isVisited()) {
                    int newDistance = actualVertex.getDist() + street.getCost();
                    if (newDistance < v.getDist()) {
                        priorityQueue.remove(v);
                        v.setDist(newDistance);
                        v.setCheapestNeighbor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }
}
