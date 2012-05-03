package interfaces;

import java.util.List;

/**
 * 
 * This interface is to made to synchronize the way it possible to 
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 */

public interface ISorter<T extends Comparable<T>> {
	public void sort(List<T> comparables);
}
