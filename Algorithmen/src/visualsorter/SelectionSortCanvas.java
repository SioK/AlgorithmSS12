package visualsorter;

import interfaces.AbstractSorterCanvas;

/**
 * 
 * This class shows the way how Selectionsort works in the canvas.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 */

public class SelectionSortCanvas extends AbstractSorterCanvas {

	private static final long serialVersionUID = 1L;

	@Override
	public void sort() {
		// defines the required length for the following iteration
		int numberOfElements = comparables.size();
		int left = 0;
		do {
			// left element
			int min = left;

			// loop over list and always have the next one (from the right) to
			// compare...
			for (int i = left + 1; i < numberOfElements; i++) {
				// if current is lesser or equal to the next one... keep order.
				// find the smallest min value. if found keep it by setting i to
				// min. min will be the index at where the natural order has
				// been violated the last time.
				if (comparables.get(i).compareTo(comparables.get(min)) <= 0) {
					min = i;
				}
			}

			// does swapping, at the index where the order has been violated the
			// last time.
			if (min != left) {
				// called the swap method Tool
				swap(left, min);
			}

			// go to next element
			left = left + 1;
		} while (left < numberOfElements);
		//at the end the whole list is sorted.
	}

	@Override
	public String getName() {

		return "SelectionSort";
	}

}
