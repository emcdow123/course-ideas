package tech.ericmcdowell.courses.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 220623 on 2/14/2017.
 */
public class SimpleCourseIdeaDAO implements CourseIdeaDAO {
  private List<CourseIdea> ideas;

  public SimpleCourseIdeaDAO() {
    this.ideas = new ArrayList<>();
  }

  @Override
  public boolean add(CourseIdea idea) {
    return ideas.add(idea);
  }

  @Override
  public List<CourseIdea> findAll() {
    return new ArrayList<>(ideas);
  }
}
