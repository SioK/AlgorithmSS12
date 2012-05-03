package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

/**
 * Shows the sorting in a JFrame via displaying the height of all array
 * elements.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 */

public abstract class AbstractSorterCanvas extends JComponent {

	private static final long serialVersionUID = 1L;

	protected List<Integer> comparables;

	private int time;

	/**
	 * Swaps two bars while sorting using Threads.
	 * 
	 * @param indexOne
	 * @param indexTwo
	 */
	public void swap(int indexOne, int indexTwo) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Thread Interupted");
		}

		Graphics g = this.getGraphics();
		Integer one = comparables.get(indexOne);
		Integer two = comparables.get(indexTwo);

		comparables.set(indexOne, two);
		comparables.set(indexTwo, one);

		g.setColor(Color.red);
		indexOne = indexOne * 10;
		indexTwo = indexTwo * 10;

		drawElement(indexOne, one, Color.red, g);
		drawElement(indexTwo, two, Color.red, g);

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Thread Interupted");
		}
		repaint();
	}

	/**
	 * Fills the JComponent with black color and calls drawElement() to set the
	 * bars in it.
	 */

	@Override
	public void paintComponent(Graphics g) {
		int index = 0;
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (Integer element : comparables) {
			drawElement(index, element, Color.blue, g);
			index += 10;
		}

	}

	/**
	 * Draws a bars, its height defined by the int value.
	 * 
	 * @param int index
	 * @param int value
	 * @param Color
	 *            c
	 * @param Graphics
	 *            g
	 */
	public void drawElement(int index, int value, Color c, Graphics g) {
		g.setColor(c);
		g.drawLine(index, this.getHeight(), index, this.getHeight() - value);
		g.drawLine(index + 1, this.getWidth(), index + 1, this.getHeight()
				- value);
		g.drawLine(index + 2, this.getWidth(), index + 2, this.getHeight()
				- value);
	}

	public void setData(List<Integer> comparables) {
		this.comparables = comparables;
	}

	public void setVisualisationTime(int time) {
		this.time = time;
	}

	abstract public void sort();

	@Override
	abstract public String getName();

}
