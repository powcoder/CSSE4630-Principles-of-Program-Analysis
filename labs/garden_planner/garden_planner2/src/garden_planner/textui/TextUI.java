https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package garden_planner.textui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A simple text user interface for a garden planner tool.
 *
 * This analyses one garden design and prints the costs.
 *
 * @author Mark Utting
 */
public class TextUI {
	private GardenPlanner planner;

    /**
     * Create a new garden planner with a simple text user interface.
     */
	public TextUI() {
		planner = new GardenPlanner();
	}

	/**
	 * Prints a summary of the garden beds, plus total materials requirements and cost.
	 */
	public void printGarden() {
		planner.recalculateTotals();
		System.out.println(planner.GARDEN_PLANNER_VERSION);
		System.out.println("Garden design is:");
		for (RectBed bed : planner.getBeds()) {
			System.out.println("    " + bed);
		}
		System.out.printf("Total garden area is: %8.2f m2.\n", planner.getTotalGardenArea());
		System.out.printf("Total wall length is: %8.2f m.\n", planner.getTotalWallLength());
		System.out.printf("Total soil required:  %8.2f m3.\n", planner.getTotalGardenArea() * planner.SOIL_DEPTH);
		System.out.printf("Total garden cost is: $%7.2f.\n", planner.getTotalCost());
	}

	/**
	 * Calculates costs for a given garden layout.
	 * This can take up to three optional command line arguments.
	 *
	 * @param args [soilPricePerCubicMetre wallPricePerMetre  [designFile.txt]]
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
        TextUI ui = new TextUI();
        if (args.length >= 2) {
			ui.planner.setSoilPrice(Double.parseDouble(args[0]));
			ui.planner.setWallPrice(Double.parseDouble(args[1]));
        }

		// set up the garden design
		if (args.length == 3) {
			ui.planner.readBeds(new Scanner(new File(args[2])));
		} else {
			ui.planner.createBasicDesign();
		}

		ui.printGarden();
	}

}
