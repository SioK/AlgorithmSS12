package sorter;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISorter;

/**
 * 
 * This sorting algo using the merge sort.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 *            while T must have implemented the Comparable Interface
 */

public class MergeSort<T extends Comparable<T>> implements ISorter<T> {

	private List<T> comparables;
	private ArrayList<T> tmpList;

	/**
	 * 
	 * @param start
	 *            begin of the list to sort
	 * @param end
	 *            last element of the list to sort
	 */

	public void mergesort(int start, int end) {
		if (start < end) {
			// get middle of the list
			int middle = (start + end) / 2;
			// recursive call of the first segment of the list
			mergesort(start, middle);
			// recursive call of the second segment of the list
			mergesort(middle + 1, end);
			// merge sorted elements of both halfs
			merge(start, middle, end);
		}
	}

	/**
	 * 
	 * Merges the recursively divided subsegments of the lists
	 * 
	 * @param start
	 *            of the segment
	 * @param middle
	 *            of the segment
	 * @param end
	 *            of the last element
	 */

	private void merge(int start, int middle, int end) {
		int i = 0;
		int k = start;
		int t = start;
		// copies the first half of the segment into an temporary list.
		while (k <= middle) {
			tmpList.add(i++, comparables.get(k++));
		}
		i = 0;

		// tmpList contains the half of the first list, while k represents the
		// middle of the whole comparables list.
		// runs through both lists at the same time
		while (t < k && k <= end) {
			// if element of first list is lower or equal than element at the
			// same index of the other list...
			if (tmpList.get(i).compareTo(comparables.get(k)) <= 0) {
				// comparables at index t is replaced by element tmpList at
				// index i. after execution of this command both indicees are
				// incremented to leave replaced element in the next loop.
				comparables.set(t++, tmpList.get(i++));
			} else {
				// comparables at index t is replaced by element tmpList at
				// index k of the second list, by means it simply merges,
				// because order is already achieved.
				comparables.set(t++, comparables.get(k++));
			}
		}

		// will be used, if the list length is %2 != 0
		// copy the remaining values or nothing
		while (t < k) {
			comparables.set(t++, tmpList.get(i++));
		}
	}

	/**
	 * is called to sort a List<T>
	 */
	@Override
	public void sort(List<T> comparables) {
		this.comparables = comparables;
		this.tmpList = new ArrayList<T>();
		mergesort(0, comparables.size() - 1);
	}

}
