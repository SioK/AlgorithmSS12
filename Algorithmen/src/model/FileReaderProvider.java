package model;

import interfaces.IDataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(zeile);
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

}
