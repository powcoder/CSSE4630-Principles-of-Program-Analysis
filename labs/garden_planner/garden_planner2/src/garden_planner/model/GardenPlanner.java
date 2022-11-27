https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package garden_planner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A planning tool for costing gardens.
 *
 * This garden planner is useful for costing various layouts of garden beds,
 * made up of different shapes such as rectangular beds, circular beds, etc.
 *
 * This program can calculate the total wood required for the edges of the beds,
 * and the total soil required to fill the beds, plus the cost of those two things.
 */
public class GardenPlanner {
    public static final String GARDEN_PLANNER_VERSION = "Garden Planner v0.2";
    public static final double SOIL_DEPTH = 0.2;  // metres

    private double soilPrice;
    private double wallPrice;

    /** The collection of all the garden beds in the current design. */
    private ArrayList<RectBed> beds;
    private double totalWallLength;
    private double totalGardenArea;

    /**
     * Creates a new garden planner, with the given soil and wall prices.
     *
     * @param soilPerCubicMetre Price of garden soil, per cubic metre.
     * @param wallPerMetre Price of the wall of a garden bed, per metre.
     */
    public GardenPlanner(double soilPerCubicMetre, double wallPerMetre) {
        this.soilPrice = soilPerCubicMetre;
        this.wallPrice = wallPerMetre;
        this.beds = null;  // see createBasicDesign() or readBeds().
    }

    public GardenPlanner() {
        // Example prices are roughly based on http://centenarylandscaping.com.au.
        // 1 cubic metre of Ultima Organic Garden Soil: $81.00.
        // 200x75mm CCA Hardwood Sleeper, 3.0m long: $51.00
        this(81.0, 51.00 / 3.0);
    }

    /**
     * Resets the garden design to a basic three rectangle design.
     */
    public void createBasicDesign() {
        this.beds = new ArrayList<>();
        // use our default layout: two rectangles with a larger square in the middle
        RectBed r1 = new RectBed();
        RectBed r2 = new RectBed();
        RectBed r3 = new RectBed();

        r1.setWidth(1.0);
        r2.setWidth(2.0);
        r3.setWidth(1.0);

        r1.setHeight(2.0);
        r2.setHeight(2.0);
        r3.setHeight(2.0);

        r1.setLeft(1.0);
        r2.setLeft(3.0);
        r3.setLeft(6.0);

        r1.setTop(1.0);
        r2.setTop(1.0);
        r3.setTop(1.0);

        beds.add(r1);
        beds.add(r2);
        beds.add(r3);
    }

    /**
     * Gets the list of garden beds in the current design.
     *
     * WARNING: passing out the whole list allows clients to add/remove beds.
     * This is poor encapsulation, but is okay in this context where the client
     * programs are known and we want to give them a lot of flexibility.
     *
     * @return a list of garden beds.
     */
    public List<RectBed> getBeds() {
        return this.beds;
    }

    /**
     * Get the total length of all walls.
     *
     * @return the total length (in metres) of all the garden bed walls.
     */
    public double getTotalWallLength() {
        return totalWallLength;
    }

    /**
     * Get the total area of all garden beds.
     *
     * @return the total area (in square metres) of all the garden beds.
     */
    public double getTotalGardenArea() {
        return totalGardenArea;
    }

    /**
     *
     * @return price of garden soil in dollars per cubic metre.
     */
    public double getSoilPrice() {
        return soilPrice;
    }

    /**
     * Set the soil price.
     * @param soilPrice in dollars per cubic metre.
     */
    public void setSoilPrice(double soilPrice) {
        this.soilPrice = soilPrice;
    }

    /**
     *
     * @return price of garden bed wall, per metre.
     */
    public double getWallPrice() {
        return wallPrice;
    }

    /**
     * Set the price of garden bed walls.
     *
     * @param wallPrice in dollars per metre.
     */
    public void setWallPrice(double wallPrice) {
        this.wallPrice = wallPrice;
    }

    /**
     * Reads a garden design file (a text file).
     *
     * This replaces the current garden layout with the shapes in the design file.
     *
     * @param in the input stream to read the design from - typically a file.
     */
    public void readBeds(Scanner in) {
        this.beds = new ArrayList<>();
        while (in.hasNext()) {
            String line = in.nextLine().trim();
            String[] words = line.split(" +");
            // System.out.println(Arrays.toString(words));  // just for debugging
            if (line.startsWith("#") || line.length() == 0) {
                // we skip comment lines and empty lines.
            } else if (words.length == 5 && words[0].toLowerCase().equals("rectangle")) {
                RectBed rect = new RectBed();
                rect.setLeft(Double.parseDouble(words[1]));
                rect.setTop(Double.parseDouble(words[2]));
                rect.setWidth(Double.parseDouble(words[3]));
                rect.setHeight(Double.parseDouble(words[4]));
                this.beds.add(rect);
            } else {
                throw new IllegalArgumentException("ERROR: illegal garden bed: " + line);
            }
        }
    }

    /**
     * Recalculates the total wall and soil requirements for the current garden layout.
     *
     * This should be called every time a garden bed changes shape or size, or is added or removed.
     */
    public void recalculateTotals() {
        totalWallLength = 0.0;
        totalGardenArea = 0.0;
        for (RectBed bed : this.beds) {
            totalGardenArea += bed.getArea();
            totalWallLength += bed.getPerimeter();
        }
    }

    /**
     * Get the total materials cost of the whole garden.
     *
     * @return cost of the walls plus soil.
     */
    public double getTotalCost() {
        final double wallCost = totalWallLength * this.wallPrice;
        final double soilVolume = totalGardenArea * this.SOIL_DEPTH;
        final double soilCost = soilVolume * this.soilPrice;
        // just for debugging:
        // System.out.printf("Total wall length is %.2f m, cost $%.2f.\n", totalWallLength, wallCost);
        // System.out.printf("Total garden area is %.2f m2 (%.2f m3 of soil), cost $%.2f.\n", totalGardenArea, soilVolume, soilCost);
        // System.out.printf("Total cost is: $%.2f\n", (wallCost + soilCost));
        return wallCost + soilCost;
    }
}
