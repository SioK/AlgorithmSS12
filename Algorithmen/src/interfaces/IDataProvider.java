package interfaces;

import java.util.List;

/**
 * 
 * The interface IDataProvider gives basic methods to produce and provide data
 * for sorting.
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
