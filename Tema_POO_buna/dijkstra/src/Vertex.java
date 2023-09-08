import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    /**
     * Flag to check if Vertex was already visited by Dijkstra algorithm
     */
    private boolean visited;

    /**
     * Name of the vertex
     */
    private String name;

    /**
     * List of streets connected to the Vertex
     */
    private List<Street> List;

    /**
     * Distance to the Vertex
     */
    private int dist = Integer.MAX_VALUE;

    /**
     * Cheapest neighbor of the vertex that is used to build the path
     */
    private Vertex cheapestNeighbor;

    /**
     * Vertex constructor
     * @param name vertex name
     */
    public Vertex(String name) {
        this.name = name;
        this.List = new ArrayList();
    }

    /**
     * Get list of streets connected to the vertex
     * @return list of streets
     */
    public List<Street> getList() {
        return List;
    }

    /**
     * Add new street connected to the vertex
     * @param street street connected to the vertex
     */
    public void addStreet(Street street) {
        this.List.add(street);
    }

    /**
     * Check if vertex is already visited by Dijkstra algorithm
     * @return true or false
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Change visited flag
     * @param visited flag value
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Get cheapest neighbor of the Vertex
     * @return cheapest neighbor
     */
    public Vertex getCheapestNeighbor() {
        return cheapestNeighbor;
    }

    /**
     * Set cheapest neighbor of the vertex
     * @param cheapestNeighbor cheapest neighbor
     */
    public void setCheapestNeighbor(Vertex cheapestNeighbor) {
        this.cheapestNeighbor = cheapestNeighbor;
    }

    /**
     * Get distance to the vertex
     * @return distance
     */
    public int getDist() {
        return dist;
    }

    /**
     * Set distance to the vertex
     * @param dist distance
     */
    public void setDist(int dist) {
        this.dist = dist;
    }

    /**
     * Reset Vertex values
     */
    public void reset() {
        this.List = new ArrayList();
        this.dist = Integer.MAX_VALUE;
        this.cheapestNeighbor = null;
        this.visited = false;
    }

    /**
     * Return Name if called as a string
     * @return vertex name
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Override compareTo method from Comparable
     * Method to compare distances between 2 vertices
     * @param otherVertex vertex to compare
     * @return -1 if this is smaller, 0 if equal, 1 if greater
     */
    @Override
    public int compareTo(Vertex otherVertex) {
        return Integer.compare(this.dist, otherVertex.getDist());
    }
}