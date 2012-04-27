package interfaces;

import java.util.List;

public interface ISorter<T extends Comparable<T>> {
	public void sort(List<T> comparables);
}
