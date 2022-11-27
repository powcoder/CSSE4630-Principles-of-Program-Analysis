https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package garden_planner.model;

/**
 * Represents a rectangular shape garden.
 *
 * @author Mark Utting
 */
public class RectBed {
	private double left = 0.0;
	private double top = 0.0;
	private double width = 1.0;
	private double height = 1.0;

	public RectBed() {
	}

	/**
	 * Position of left edge of this shape.
	 *
	 * @return left edge, in metres
	 */
	public double getLeft() {
		return left;
	}

	public void setLeft(double left) {
		this.left = left;
	}

	/**
	 * Position of top edge of this shape.
	 *
	 * @return top edge, in metres
	 */
	public double getTop() {
		return top;
	}

	public void setTop(double top) {
		this.top = top;
	}

	/**
	 * Total width of this shape.
	 *
	 * @return width in metres.
	 */
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Total height of this shape.
	 *
	 * @return height in metres.
	 */
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Get the area of this shape.
	 *
	 * @return the total internal area of the shape.
	 */
	public double getArea() {
		return width * height;
	}

	/**
	 * Get the perimeter of this shape.
	 *
	 * @return the total length of the edges of the shape.
	 */
	public double getPerimeter() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return String.format("Rectangle %.2f %.2f %.2f %.2f", left, top, width, height);
	}
}

