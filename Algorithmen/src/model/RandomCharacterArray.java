package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.IDataProvider;

public class RandomCharacterArray implements IDataProvider<Character>{
	
	private int size;
	private int pool;
	
	public RandomCharacterArray(int size, int pool) {
		this.size = size;
		this.pool = pool;
	}

	@Override
	public List<Character> getData() {
		ArrayList<Character> arrListCharacter = new ArrayList<Character>();
		for (int i = 0; i < size; i++) {
			Character character = (char) (new Random().nextInt(pool)+65);
			arrListCharacter.add(character);
		}
		return arrListCharacter;
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
