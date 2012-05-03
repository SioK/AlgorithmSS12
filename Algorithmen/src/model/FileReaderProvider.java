package model;

import interfaces.IDataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is made to load the prepared files..
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 *
 */

public class FileReaderProvider implements IDataProvider<Integer> {

	private final ArrayList<Integer> valuesList = new ArrayList<Integer>();

	public FileReaderProvider(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String zeile = "";
			while (true) {
				zeile = br.readLine();
				if (zeile == null) {
					break;
				}
				this.valuesList.add(Integer.valueOf(zeile));
			}
			br.close();
			fr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "FileReaderProvider [valuesList=" + valuesList + "]";
	}

	@Override
	public List<Integer> getData() {
		return valuesList;
	}

	@Override
	public int getSize() {
		return valuesList.size();
	}

	@Override
	public int maxValueBound() {
		return 0;
	}
}