package interfaces;

import java.util.List;

/**
 * 
 * This interface is to made to synchronize all sorter algos. Later it's
 * possible to call it from the main program. It will help to sort everything as
 * long as Comparable T is implemented.
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
