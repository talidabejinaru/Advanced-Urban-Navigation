import java.util.*;

public class Main {

    /**
     * Available vehicles
     */
    private static final HashMap<String, Vehicle> vehicles = new HashMap<>();

    /**
     * Graph vertices
     */
    private static final HashMap<String, Vertex> vertices = new HashMap<>();

    /**
     * Streets between vertices
     */
    private static final HashMap<String, Street> streets = new HashMap<>();

    /**
     * Main function
     * @param arg arguments
     */
    public static void main(String[] arg)
    {
        String src = "6 5 \n" +
                "P0 P1 1 3 \n" +
                "P0 P2 2 1 \n" +
                "P1 P2 2 3 \n" +
                "P1 P3 1 2 \n" +
                "P3 P4 3 2 \n" +
                "P4 P3 1 3 \n" +
                "accident P0 P1 10 \n" +
                "drive a P0 P4 \n" +
                "drive b P0 P2 \n" +
                "trafic P1 P3 5 \n" +
                "blocaj P0 P1 10 \n" +
                "drive c P0 P4";

        initVehicles();
        readFile(src);
    }


    /**
     * Initialize the list of available vehicles
     */
    private static void initVehicles(){
        vehicles.put("b", new Vehicle("Moped", 1, 1));
        vehicles.put("m", new Vehicle("Moped", 1, 2));
        vehicles.put("a", new Vehicle("Autovehicul", 2, 4));
        vehicles.put("c", new Vehicle("Autoutilitar", 3, 6));
    }

    /**
     * Read input file
     * @param input file
     */
    private static void readFile(String input) {
        Scanner scanner = new Scanner(input);
        String[] line;
        line = scanner.nextLine().split(" ");

        int streetsNumber = Integer.parseInt(line[0]);
        int nodesNumber = Integer.parseInt(line[1]);

        for (int i = 0; i < nodesNumber; i++) {
            vertices.put("P" + i, new Vertex("P" + i));
        }

        while (streetsNumber > 0) {
            line = scanner.nextLine().split(" ");
            addStreet(line[0], line[1], line[2], line[3]);
            streetsNumber--;
        }

        while(scanner.hasNextLine()) {
            line = scanner.nextLine().split(" ");

            if (line[0].equals("drive")) {
                drive(vehicles.get(line[1]), line[2], line[3]);
            } else {
                addRestriction(line[0], line[1], line[2], Integer.parseInt(line[3]));
            }
        }
    }

    /**
     * Reset streets before calculating the shortest path
     */
    private static void resetStreets() {
        for (String vertexName : vertices.keySet()) {
            vertices.get(vertexName).reset();
        }

        for (String streetName : streets.keySet()) {
            streets.get(streetName).getEndVertex().reset();
            streets.get(streetName).getStartVertex().reset();
        }
    }

    /**
     * Drive specific vehicle from start to end vertex
     * @param vehicle Vehicle to drive
     * @param start Start point
     * @param end End point
     */
    private static void drive (Vehicle vehicle, String start, String end) {
        resetStreets();

        for (String streetName : streets.keySet()) {
            Street street = streets.get(streetName);

            if (street.getLimit() >= vehicle.getDimensions()) {
                int streetCost = street.getCost() * vehicle.getCost() + street.getExtraCost();
                street.updateCost(streetCost);

                Vertex vertex = vertices.get(streetName.split(" ")[0]);
                vertex.addStreet(street);
            }
        }

        Vertex startVertex = vertices.get(start);
        Vertex endVertex = vertices.get(end);

        vehicle.drive(startVertex, endVertex);
    }

    /**
     * Add street between vertices
     * @param start Vertex start
     * @param end Vertex end
     * @param cost Cost of the street
     * @param size Limit of vehicle dimensions
     */
    private static void addStreet(String start, String end, String cost, String size) {
        Vertex vertexStart = vertices.get(start);
        Vertex vertexEnd = vertices.get(end);
        streets.put(start + " " + end, new Street(Integer.parseInt(cost), Integer.parseInt(size), vertexStart, vertexEnd));
    }

    /**
     * Add restriction to the street
     * @param type restriction type
     * @param start Vertex
     * @param end Vertex
     * @param cost Cost of the restriction
     */
    private static void addRestriction(String type, String start, String end, int cost) {
        streets.get(start + " " + end).addRestriction(cost);
    }
}