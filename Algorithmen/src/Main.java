import interfaces.IDataProvider;
import interfaces.ISorter;

import java.util.List;
import java.util.ArrayList;

import sorter.MergeSort;
import sorter.QuickSort;
import sorter.SelectionSort;
import utils.RunTimeMeasure;
import utils.visualizer.SortVisualizer;
import visualsorter.QuickSortCanvas;
import visualsorter.SelectionSortCanvas;

import model.FileReaderProvider;
import model.RandomCharacterArray;
import model.RandomIntArray;

public class Main {

  public static void main(String[] args) {

    // Runtime Measure Integer
    List<ISorter<Integer>> intSorter = new ArrayList<ISorter<Integer>>();
    // intSorter.add(new SelectionSort<Integer>());
    // intSorter.add(new QuickSort<Integer>());
    intSorter.add(new MergeSort<Integer>());

    IDataProvider<Integer> intProvider = new RandomIntArray(100, 200);
    RunTimeMeasure<Integer> intRM = new RunTimeMeasure<Integer>(intSorter, intProvider, 1);

    intRM.execute();

    // Runtime Measure Character
    List<ISorter<Character>> charSorter = new ArrayList<ISorter<Character>>();
    charSorter.add(new SelectionSort<Character>());
    charSorter.add(new QuickSort<Character>());

    IDataProvider<Character> charProvider = new RandomCharacterArray(30, 25);
    RunTimeMeasure<Character> charRM = new RunTimeMeasure<Character>(charSorter, charProvider, 30);
    charRM.execute();

    // Runtime Measure File(Integer)

    IDataProvider<Integer> fileProvider = new FileReaderProvider(
        "/home/semo/git/AlgorithmSS12/Algorithmen/src/assets/Rand100_2");
    RunTimeMeasure<Integer> fileRM = new RunTimeMeasure<Integer>(intSorter, fileProvider, 1);
    fileRM.execute();

    // Visualizer

    QuickSortCanvas canvasQuick = new QuickSortCanvas();
    SelectionSortCanvas canvasSelection = new SelectionSortCanvas();

    SortVisualizer visual = new SortVisualizer();
    visual.create(intProvider, canvasSelection, 500);
    visual.show(true);
  }
}
