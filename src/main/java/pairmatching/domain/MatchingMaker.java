package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingMaker {

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int DUO = 2;
    private final int TRIO = 3;

    public MatchingMaker() {

    }

    public Matching pairMatching(final List<Crew> crews) {
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        shuffledCrews.stream()
                .filter(crew -> isEvenIndex(crew, shuffledCrews))
                        .filter(crew -> isNotLastIndex(crew, shuffledCrews))
                                .forEach(crew -> pairs.add(
                                        new Pair(pairMatch(shuffledCrews,
                                                shuffledCrews.indexOf(crew)))));
        return new Matching(Collections.unmodifiableList(pairs));
    }

    private boolean isTrio(List<Crew> shuffledCrews, int index) {
        return shuffledCrews.size() - index == TRIO;
    }

    private boolean isEvenIndex(Crew crew, final List<Crew> crews) {
        return crews.indexOf(crew) % DUO == ZERO;
    }

    private boolean isNotLastIndex(Crew crew, final List<Crew> crews) {
        return crews.indexOf(crew) != crews.size() - ONE;
    }

    private List<Crew> pairMatch(List<Crew> shuffledCrews, int index) {
        int memberNumber = DUO;
        if (isTrio(shuffledCrews, index)) {
            memberNumber = TRIO;
        }
        List<Crew> matchedCrews = new ArrayList<>();
        for (int i = ZERO; i < memberNumber; i++) {
            matchedCrews.add(shuffledCrews.get(index + i));
        }
        return matchedCrews;
    }
}
