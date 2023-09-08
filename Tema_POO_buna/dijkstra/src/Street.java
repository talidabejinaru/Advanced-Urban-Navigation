public class Street {

    /**
     * Cost to drive on the street
     */
    private int cost;

    /**
     * Vehicles dimensions limitation
     */
    private final int limit;

    /**
     * Extra street cost added by traffic/accident/so on
     */
    private int extraCost;

    /**
     * Vertex Start of the street
     */
    private final Vertex startVertex;

    /**
     * Vertex end of the street
     */
    private final Vertex endVertex;

    /**
     * Street constructor
     * @param cost street cost
     * @param limit vehicles dimensions limitation
     * @param startVertex start
     * @param endVertex end
     */
    public Street(int cost, int limit, Vertex startVertex, Vertex endVertex) {
        this.cost = cost;
        this.limit = limit;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    /**
     * Get street costs
     * @return int
     */
    public int getCost() {
        return cost;
    }

    /**
     * Get Vertex at the end of the street
     * @return Vertex
     */
    public Vertex getEndVertex() {
        return endVertex;
    }

    /**
     * Get Vertex at the beginning of the street
     * @return Vertex
     */
    public Vertex getStartVertex() {
        return startVertex;
    }

    /**
     * Add extra costs for the street
     * @param cost restriction cost
     */
    public void addRestriction(int cost) {
        this.extraCost += cost;
    }

    /**
     * Get extra costs of the street
     * @return extra costs
     */
    public int getExtraCost() {
        return this.extraCost;
    }

    /**
     * Get vehicles dimensions limitation
     * @return vehicles dimensions limitation
     */
    public int getLimit() {
        return this.limit;
    }

    /**
     * Update street cost
     * @param cost
     */
    public void updateCost(int cost) {
        this.cost = cost;
    }

}