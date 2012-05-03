package sorter;

import java.util.Random;
import java.util.List;

import interfaces.ISorter;

/**
 * This class achieves more or less a very efficient way to sort something at
 * once or in the worst case in an infinite loop.
 * 
 * @author Sebastian Morkisch <semox78@gmail.com>
 * @author François Dubois <siokdub@gmail.com>
 * 
 * @param <T> while T must have implemented the Comparable Interface
 */

public class BogoSort<T extends Comparable<T>> implements ISorter<T> {

	private static final Random generator = new Random();
	private List<T> comparables;

	@Override
	public void sort(List<T> comparables) {
		 this.comparables = comparables;
		while (!isSorted(comparables)) {
			for (int i = 0; i < comparables.size(); i++) {
				int randPos = generator.nextInt(comparables.size() - 1);
				T temp = comparables.get(i);
				this.comparables.add(i, comparables.get(randPos));
				this.comparables.add(randPos, temp);
			}
		}
	}

	private boolean isSorted(List<T> comparables) {
		for (int i = 0; i <= this.comparables.size() -1; i++) {
			if (this.comparables.get(i).compareTo(comparables.get(i +1 )) < 0) {
				return false;
			}
		}
		return true;
	}
}