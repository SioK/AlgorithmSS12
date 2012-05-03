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

public class SelectionSortCanvas extends AbstractSorterCanvas{

	private static final long serialVersionUID = 1L;

	@Override
	public void sort() {
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
				swap(left, min);
			}
			left = left + 1;
		} while (left < numberOfElements);
		
	}

	@Override
	public String getName() {

		return "SelectionSort";
	}

}
