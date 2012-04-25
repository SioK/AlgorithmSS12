package model;

import interfaces.IDataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReaderProvider implements IDataProvider<Integer> {

	private static ArrayList<Integer> values = new ArrayList<Integer>();

	public FileReaderProvider(String dat) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dat);
		} catch (Exception e) {
			System.out.println("'dat' konnte nicht geoeffnet werden");

		}
		try {
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String einZeile;
			einZeile = br.readLine();
			int anz = new Integer(einZeile);

			for (int i = 0; i < anz; i++) {
				einZeile = br.readLine();

				if (einZeile == null)
					break; // Ende der Datei erreicht
				System.out.println(einZeile);
				int j = new Integer(einZeile);
				values.set(i, j);
			}
		} catch (Exception e) {
			System.out.println("Einlesen nicht erfolgreich");
		}

	}

	@Override
	public List<Integer> getData() {
		return values;
	}
}
