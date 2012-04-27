package interfaces;

import java.util.List;

public interface IDataProvider<T> {

  List<T> getData();
  int getSize();
  int maxValueBound();

}
