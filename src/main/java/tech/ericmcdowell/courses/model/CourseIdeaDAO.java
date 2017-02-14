package tech.ericmcdowell.courses.model;

import java.util.List;

/**
 * Created by 220623 on 2/14/2017.
 */
public interface CourseIdeaDAO {
  boolean add(CourseIdea idea);

  List<CourseIdea> findAll();
}
