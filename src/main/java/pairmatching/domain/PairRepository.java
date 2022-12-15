package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Mission;

public class PairRepository {

    private final int COURSE_NUMBER = 2;
    private final int ZERO = 0;
    private final int MAXIMUM_COUNT_NUMBER = 3;

    private final Map<PairTag, Matching> repository
            = new HashMap<>(Mission.values().length * COURSE_NUMBER);
    private final MatchingMaker matchingMaker = new MatchingMaker();
    private final Matching emptyMatching = new Matching(new ArrayList<Pair>());

    public PairRepository() {
        resetAll();
    }

    public void reset(final PairTag pairTag) {
        repository.replace(pairTag, emptyMatching);
    }

    public void resetAll() {
        for (Mission mission : Mission.values()) {
            Arrays.stream(Course.values())
                    .forEach(course -> repository.put(
                            new PairTag(course, mission.getLevel(), mission), emptyMatching));
        }
    }

    public boolean isAlreadyPaired(PairTag pairTag) {
        return !repository.get(pairTag).equals(emptyMatching);
    }

    public Matching getMatching(PairTag pairTag) {
        return repository.get(pairTag);
    }

    public void pairMatching(final PairTag pairTag) {
        final Matching matching = tryPairMatching(pairTag);
        repository.replace(pairTag, matching);
    }

    private Matching tryPairMatching(final PairTag pairTag) {
        int tryCount = ZERO;
        Matching matching;
        do {
            matching = matchingMaker.pairMatching(pairTag.getCrews());
            tryCount++;

            if (!isDuplicated(pairTag, matching)) {
                return matching;
            }
        } while (tryCount <= MAXIMUM_COUNT_NUMBER);
        throw new IllegalStateException("[ERROR] 매칭에 실패하였습니다.");
    }

    private boolean isDuplicated(final PairTag pairTag, final Matching newMatching) {
        return repository.keySet().stream()
                .filter(pairTag::isSameCourseAndLevel)
                .filter((pairTag::isDifferentMission))
                .anyMatch(matchingKey -> repository.get(matchingKey).isDuplicate(newMatching));
    }
}
