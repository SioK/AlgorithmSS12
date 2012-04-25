package sorter;

import java.util.List;

import utils.ToolBox;

import interfaces.ISorter;

public class QuickSort<T extends Comparable<T>> implements ISorter<T> {

	private List<T> comparables;

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
		T pivot = comparables.get(right);
		do {
			while (comparables.get(i).compareTo(pivot) <= 0 && i < right) {
				i++;
			}

			while (comparables.get(j).compareTo(pivot) >= 0 && j > left) {
				j--;
			}
			if (i < j) {
				ToolBox.swap(comparables, i, j);
			}
		} while (i < j);
		
		if(comparables.get(i).compareTo(pivot) > 0) {
			ToolBox.swap(comparables, i, right);
		}

		return i;
	}

	@Override
	public void sort(List<T> comparables) {
		// TODO Auto-generated method stub
		this.comparables = comparables;
		quicksort(0, comparables.size() - 1);
	}

}
