package sorter;

import java.util.List;

import utils.ToolBox;

import interfaces.ISorter;

/**
 * 
 * This sorting algo using the quick sort.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 *            while T must have implemented the Comparable Interface
 */

public class QuickSort<T extends Comparable<T>> implements ISorter<T> {

	private List<T> comparables;

	/**
	 * 
	 * Splits recursively into two subproblems
	 * 
	 * @param left
	 *            start of any list segment
	 * @param right
	 *            end of any list segment
	 */
	public void quicksort(int left, int right) {
		if (left < right) {
			// index at which a whole problem is splitted.
			int divideAt = divide(left, right);
			// left sort
			quicksort(left, divideAt - 1);
			// right sort
			quicksort(divideAt + 1, right);
		}
	}

	/**
	 * 
	 * @param left
	 *            start of any List (subproblem)
	 * @param right
	 *            end of any List (subproblem)
	 * @return int of pivot element
	 */
	public int divide(int left, int right) {
		int i = left;
		int j = right - 1;
		T pivot = comparables.get(right);

		do {
			// travels right until a value is greater than the pivot element
			while (comparables.get(i).compareTo(pivot) <= 0 && i < right) {
				i++;
			}

			// travels left until a value is lesser than the pivot element
			while (comparables.get(j).compareTo(pivot) >= 0 && j > left) {
				j--;
			}
			// swaps both found values not fitting into the order defined
			// by the pivot element
			if (i < j) {
				ToolBox.swap(comparables, i, j);
			}
		} while (i < j);
		
		// is called after completion of the while loop to swap pivot (here at
		// the right end) with the element where i and j met.
		if (comparables.get(i).compareTo(pivot) > 0) {
			ToolBox.swap(comparables, i, right);
		}
		// returns the index of the pivot element in the first call, every
		// further call it will return the index greater than the pivot element.
		return i;
	}

	/**
	 * call to sort a unsorted List<T>
	 */
	@Override
	public void sort(List<T> comparables) {
		this.comparables = comparables;
		quicksort(0, comparables.size() - 1);
	}

}
