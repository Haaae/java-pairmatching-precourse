package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constants.Enum.Course;
import pairmatching.constants.Enum.Level;

public class MatchingMaker {

    private final int duo = 2;
    private final int trio = 3;

    public Matching pairMatching(final List<Crew> crews, Level level, Course course) {
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        for (Crew crew : shuffledCrews) {
            if (isEvenIndex(crew, shuffledCrews)) {
                continue;
            }
            int index = shuffledCrews.indexOf(crew);
            if (isTrio(shuffledCrews, index)) {
                pairs.add(new Pair(pairMatch(shuffledCrews,index,trio)));
                continue;
            }
            pairs.add(new Pair(pairMatch(shuffledCrews,index,duo)));
        }
        return new Matching(Collections.unmodifiableList(pairs), level, course);
    }

    private boolean isTrio(List<Crew> shuffledCrews, int index) {
        return shuffledCrews.size() - index == trio;
    }

    private boolean isEvenIndex(Crew crew, final List<Crew> crews) {
        return crews.indexOf(crew) % 2 == 0;
    }

    private List<Crew> pairMatch(List<Crew> shuffledCrews, int index, int memberNumber) {
        List<Crew> matchedCrews = new ArrayList<>();
        for (int i = 0; i < memberNumber; i++) {
            matchedCrews.add(shuffledCrews.get(index + i));
        }
        return matchedCrews;
    }
}
