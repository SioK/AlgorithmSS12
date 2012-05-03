package utils;

import java.util.List;
import java.util.Random;

/**
 * 
 * Simple helper class to work with values inside a datastructure. 
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 *
 */

public final class ToolBox {

	public static int[] generateRandArray(int pool, int size) {
		Random r = new Random();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(pool);
		}
		return array;
	}

	public static <T> void swap(List<T> comparables, int indexOne, int indexTwo) {
		T one = comparables.get(indexOne);
		T two = comparables.get(indexTwo);
		comparables.set(indexOne, two);
		comparables.set(indexTwo, one);
	}

	public static void printArray(int[] array, int subsequence) {
		System.out.print("{");
		for (int i = 0; i <= subsequence; i++) {
			System.out.print(i + ", ");
		}
		System.out.print("}\n");
	}

}
