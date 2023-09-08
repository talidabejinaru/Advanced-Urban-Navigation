import java.util.List;

public class Vehicle {

    /**
     * Vehicle type
     */
    public String type;

    /**
     * Vehicle dimensions
     */
    private final int dimensions;

    /**
     * Vehicle cost
     */
    private final int cost;

    /**
     * Vehicle constructor
     * @param type type of the vehicle
     * @param dimensions dimensions of the vehicle
     * @param cost cost to drive the vehicle
     */
    public Vehicle(String type, int dimensions, int cost) {
        this.type = type;
        this.dimensions = dimensions;
        this.cost = cost;
    }

    /**
     * Get vehicle dimensions
     * @return dimensions
     */
    public int getDimensions() {
        return this.dimensions;
    }

    /**
     * Get costs to drive the vehicle
     * @return cost of driving
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Drive vehicle from start to end point
     * @param start drive from point
     * @param end drive to point
     */
    public void drive(Vertex start, Vertex end) {

        PathFinder shortestPath = new PathFinder();
        shortestPath.calculateShortestPath(start);

        int cost = end.getDist();
        List<Vertex> path = shortestPath.getShortestPathTo(end);

        if (path.size() > 1) {
            String vertices = path.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");

            System.out.println( vertices + " " + cost);
        } else {
            // print null if there is no connection
            System.out.println(start + " " + end + " null");
        }
    }
}
