package interfaces;

import java.util.List;

/**
 * 
 * The interface IDataProvider is made for a later use in a graphical User
 * Interface. For example to run it in a JFileChoose or straight from the
 * command line.
 * 
 * @author François Dubois <siokdub@gmail.com>
 * @author Sebastian Morkisch <semox78@gmail.com>
 * 
 * @param <T> 
 */

public interface IDataProvider<T> {

	List<T> getData();

	int getSize();

	int maxValueBound();

}
