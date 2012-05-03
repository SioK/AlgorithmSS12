package sorter;

import java.util.List;

import utils.ToolBox;

import interfaces.ISorter;

/**
 * 
 * This sorting algo using the selection sort.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 *            while T must have implemented the Comparable Interface
 */

public class SelectionSort<T extends Comparable<T>> implements ISorter<T> {

	/**
	 * sorts a list xD
	 */
	@Override
	public void sort(List<T> comparables) {
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
				ToolBox.swap(comparables, left, min);
			}
			// go to next element
			left = left + 1;
		} while (left < numberOfElements);
		// at the end the whole list is sorted.
	}

}
