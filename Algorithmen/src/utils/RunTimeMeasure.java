package utils;

import interfaces.IDataProvider;
import interfaces.ISorter;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class benchmarks the power of sort algos using generics. Under the hood
 * it uses the power of the Command Pattern see execute().
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T>
 */

public class RunTimeMeasure<T extends Comparable<T>> {

	private final List<ISorter<T>> sorters;
	private final int loops;
	private final IDataProvider<T> provider;

	public RunTimeMeasure(List<ISorter<T>> sorters, IDataProvider<T> provider,
			int loops) {
		this.sorters = sorters;
		this.provider = provider;
		this.loops = loops;
	}

	public void execute() {
		int mean = 0;
		System.out.println("Number of Arrays/Loops: " + loops);

		List<List<T>> l = new ArrayList<List<T>>();
		for (int i = 0; i <= loops; i++) {
			List<T> data = provider.getData();
			l.add(data);
		}

		for (ISorter<T> sortAlgorithm : sorters) {
			List<T> workingCopy = null;
			for (List<T> is : l) {
				workingCopy = new ArrayList<T>(is);
				double start = System.currentTimeMillis();
				sortAlgorithm.sort(workingCopy);
				double end = System.currentTimeMillis();
				mean += end - start;
			}
			System.out.println(workingCopy.toString());
			System.out.println("Duration of Sort from Algorithm "
					+ sortAlgorithm.getClass().getSimpleName() + " " + mean
					+ " millis");
		}
	}
}
