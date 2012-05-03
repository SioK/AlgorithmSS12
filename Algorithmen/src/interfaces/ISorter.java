package interfaces;

import java.util.List;

/**
 * 
 * This interface is to made to standardize the access for all sorter algos. It
 * will help to sort everything as long as Comparable T is implemented in
 * different contents.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 *            A generic List.
 */

public interface ISorter<T extends Comparable<T>> {
	public void sort(List<T> comparables);
}
