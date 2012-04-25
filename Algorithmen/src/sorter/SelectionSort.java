package sorter;

import java.util.List;

import utils.ToolBox;

import interfaces.ISorter;

/**
 * 
 * @author Francois Dubois Matrikelnummer 769161 represents the selection
 *         algorithm
 */
public class SelectionSort<T extends Comparable<T>> implements ISorter<T> {


	/**
	 * selection sort algorithm
	 */

	@Override
	public void sort(List<T> comparables) {
		// defines the required length for the following iteration
		int numberOfElements = comparables.size();
		int left = 0;
		do {
			int min = left;
			for (int i = left + 1; i < numberOfElements; i++) {
					if(comparables.get(i).compareTo(comparables.get(min)) <= 0) {
						min = i;
					}
			}
			if (min != left) {
				// called the swap method Tool
				ToolBox.swap(comparables, left, min);
			}
			left = left + 1;
		} while (left < numberOfElements);

	}

}
