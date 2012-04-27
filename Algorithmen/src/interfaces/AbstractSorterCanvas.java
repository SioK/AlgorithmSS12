package interfaces;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class AbstractSorterCanvas extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected List<Integer> comparables;

	private int time;

	public void swap(int indexOne, int indexTwo) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Thread Interuppted");
		}
		
		Graphics g =  this.getGraphics();
		Integer one = comparables.get(indexOne);
		Integer two = comparables.get(indexTwo);

		comparables.set(indexOne, two);
		comparables.set(indexTwo, one);

		g.setColor(Color.red);
		indexOne = indexOne*10;
		indexTwo = indexTwo*10;
		g.drawLine(indexOne, this.getHeight(), indexOne, this.getHeight() - one);
		g.drawLine(indexOne + 1, this.getWidth(), indexOne + 1, this.getHeight() - one);
		g.drawLine(indexOne + 2, this.getWidth(), indexOne + 2, this.getHeight() - one);

		g.drawLine(indexTwo, this.getHeight(), indexTwo, this.getHeight() - two);
		g.drawLine(indexTwo + 1, this.getWidth(), indexTwo + 1, this.getHeight() - two);
		g.drawLine(indexTwo + 2, this.getWidth(), indexTwo + 2, this.getHeight() - two);

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Thread Interuppted");
		}
		repaint();
	}

	public void paint(Graphics g) {
		int index = 0;
		for (Integer element : comparables) {

			g.setColor(new Color(255));
			g.drawLine(index, this.getHeight(), index, this.getHeight()- element);
			g.drawLine(index + 1, this.getWidth(), index + 1, this.getHeight()- element);
			g.drawLine(index + 2, this.getWidth(), index + 2, this.getHeight()- element);
			index += 10;
		}

	}

	public void setData(List<Integer> comparables) {
		this.comparables = comparables;
	}
	
	public void setVisualisationTime(int time) {
		this.time = time;
	}
	

	abstract public void sort();
	abstract public String getName();

}
