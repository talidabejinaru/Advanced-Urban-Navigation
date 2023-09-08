import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder extends Dijkstra {

    /**
     * Get shortest path to target Vertex
     * @param targetVertex end point of path
     * @return list of vertices
     */
    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getCheapestNeighbor()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

}