package visualsorter;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.AbstractSorterCanvas;

public class QuickSortCanvas extends AbstractSorterCanvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void sort() {
		quicksort(0, comparables.size() - 1);
		
	}
	
	public void quicksort(int left, int right) {
		if (left < right) {
			int divide = divide(left, right);
			quicksort(left, divide - 1);
			quicksort(divide + 1, right);
		}
	}

	public int divide(int left, int right) {
		int i = left;
		int j = right - 1;
		Integer pivot = comparables.get(right);
		drawListBounds(left, right);
		do {
			while (comparables.get(i).compareTo(pivot) <= 0 && i < right) {
				i++;
			}

			while (comparables.get(j).compareTo(pivot) >= 0 && j > left) {
				j--;
			}
			if (i < j) {
				swap(i, j);
			}
		} while (i < j);
		
		if(comparables.get(i).compareTo(pivot) > 0) {
			swap(i, right);
		}

		return i;
	}
	
	@Override
	public String getName() {

		return "QuickSort";
	}
	
	private void drawListBounds(int left, int right) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Thread Interuppted");
		}
		
		Integer leftvalue = comparables.get(left);
		Integer rightvalue = comparables.get(right);
		
		left = left*10;
		right = right*10;

		Graphics g = this.getGraphics();
		g.setColor(Color.yellow);
		g.drawLine(left, this.getHeight(), left, this.getHeight() - leftvalue);
		g.drawLine(left + 1, this.getWidth(), left + 1, this.getHeight() - leftvalue);
		g.drawLine(left + 2, this.getWidth(), left + 2, this.getHeight() - leftvalue);
		
		g.drawLine(right, this.getHeight(), right, this.getHeight() - rightvalue);
		g.drawLine(right + 1, this.getWidth(), right + 1, this.getHeight() - rightvalue);
		g.drawLine(right + 2, this.getWidth(), right + 2, this.getHeight() - rightvalue);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("Thread Interuppted");
		}
		
		repaint();
		
	}

}
