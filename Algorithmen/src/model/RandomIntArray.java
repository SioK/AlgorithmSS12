package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.IDataProvider;

public class RandomIntArray implements IDataProvider<Integer>{
	
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

}
