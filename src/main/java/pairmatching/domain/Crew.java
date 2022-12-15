package pairmatching.domain;

import pairmatching.view.Enum.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name)  {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Crew other) {
        return this.name.equals(other.name) && this.course.equals(other.course);
    }

    public int hashCode() {
        return name.hashCode() + course.getDeclaringClass().hashCode();
    }
}