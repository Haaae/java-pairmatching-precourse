package pairmatching.view.Enum;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.CrewMemberReader;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(Course.values())
                .filter(Course -> Course.getName().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 코스가 없습니다."));
    }

    public String getName() {
        return name;
    }

    public List<Crew> getCrews() {
        return CrewMemberReader.getInstance().readCrews(this);
    }
}