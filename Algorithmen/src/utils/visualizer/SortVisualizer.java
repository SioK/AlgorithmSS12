package utils.visualizer;

import interfaces.AbstractSorterCanvas;
import interfaces.IDataProvider;

import javax.swing.JFrame;

/**
 * 
 * This class is the concrete implementation of the {@link AbstractSorterCanvas}
 * and used to create and destroy a Canvas showing the bars.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 */

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
		frame.setTitle("Sort Visualizer of: " + canvas.getName()
				+ "  Number of Elements: " + provider.getSize());
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
