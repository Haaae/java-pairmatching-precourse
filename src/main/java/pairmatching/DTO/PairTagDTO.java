package pairmatching.DTO;

import pairmatching.domain.PairTag;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Mission;

public class PairTagDTO {

    private PairTag pairTag;

    public PairTagDTO() {}

    public PairTagDTO setParMatchingDTO(Course course,
            Level level, Mission mission) {
        pairTag = new PairTag(course, level, mission);
        return this;
    }

    public PairTag getPairTag() {
        return pairTag;
    }
}
