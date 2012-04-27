package visualsorter;

import interfaces.AbstractSorterCanvas;

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
