package sorter;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISorter;

public class MergeSort<T extends Comparable<T>> implements ISorter<T> {

	private List<T> comparables;
	private ArrayList<T> tmpList;

	public void mergesort(int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergesort(start, middle);
			mergesort(middle + 1, end);
			merge(start, middle, end);
		}
	}

	private void merge(int start, int middle, int end) {
		int i = 0;
		int k = start;
		int t = start;
		while (k <= middle) {
			tmpList.set(i++, comparables.get(k++));
		}
		i = 0;
		while (t < k && k <= end) {
			if (tmpList.get(i).compareTo(comparables.get(k)) <= 0) {
				comparables.set(t++, tmpList.get(i++));
			} else {
				comparables.set(t++, comparables.get(k++));

			}
		}

		// copy the remaining values or nothing
		while (t < k) {
			comparables.set(t++, tmpList.get(i++));
		}
	}

	@Override
	public void sort(List<T> comparables) {
		this.comparables = comparables;
		this.tmpList = new ArrayList<T>();
		mergesort(0, comparables.size());
	}

}
