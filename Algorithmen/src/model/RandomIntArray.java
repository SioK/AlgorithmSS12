package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.IDataProvider;

/**
 * 
 * Provides an array of different int values. Its lenght as well as the pool from
 * which values will be used can be defined.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 */

public class RandomIntArray implements IDataProvider<Integer> {

	private int pool;
	private int size;

	public RandomIntArray(int size, int pool) {
		this.pool = pool;
		this.size = size;
	}

	@Override
	public List<Integer> getData() {
		ArrayList<Integer> arrListInteger = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			arrListInteger.add(new Integer(new Random().nextInt(pool)));
		}
		return arrListInteger;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int maxValueBound() {
		return pool;
	}

}
