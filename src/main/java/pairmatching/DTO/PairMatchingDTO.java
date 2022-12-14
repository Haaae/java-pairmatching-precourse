package pairmatching.DTO;

import java.util.List;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Mission;

public class PairMatchingDTO {

    private Course course;
    private Level level;
    private Mission mission;

    public PairMatchingDTO() {}

    public PairMatchingDTO setParMatchingDTO(Course course,
            Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
