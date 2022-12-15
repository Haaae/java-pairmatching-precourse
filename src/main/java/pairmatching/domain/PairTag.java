package pairmatching.domain;

import java.util.List;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Mission;

public class PairTag {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairTag(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public List<Crew> getCrews() {
        return course.getCrews();
    }

    public boolean isSameCourseAndLevel(PairTag pairTag) {
        return this.level.equals(pairTag.level)
                && this.course.equals(pairTag.course);
    }

    public boolean isDifferentMission(PairTag pairTag) {
        return !this.mission.equals(pairTag.mission);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof PairTag) {
            PairTag pairTag = (PairTag) o;
            return course.equals(pairTag.course)
                    && level.equals(pairTag.level)
                    && mission.equals(pairTag.mission);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return course.hashCode() + level.hashCode() + mission.hashCode();
    }
}
