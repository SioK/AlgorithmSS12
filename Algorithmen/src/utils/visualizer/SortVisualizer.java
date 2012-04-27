package utils.visualizer;

import java.awt.Color;

import interfaces.AbstractSorterCanvas;
import interfaces.IDataProvider;

import javax.swing.JFrame;


public class SortVisualizer {
	JFrame frame = null;
	AbstractSorterCanvas canvas;

	public void create(IDataProvider<Integer> provider,
			AbstractSorterCanvas canvas, int updateTime) {
		
		int maxValue = provider.maxValueBound();
		int numberOfelements = provider.getSize();
		
		this.canvas = canvas;
		canvas.setData(provider.getData());
		canvas.setVisualisationTime(updateTime);
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(numberOfelements * 10, maxValue + 100);
		frame.setTitle("Sort Visualizer of: "
				+ canvas.getName() + "  Number of Elements: "+ provider.getSize() );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);
		
	
		
	}

	public void show(boolean b) {
		if (frame != null && canvas != null) {
			canvas.setVisible(b);
			frame.setVisible(b);
			canvas.sort();
		}
	}

}
