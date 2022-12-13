package pairmatching.domain;

import java.util.List;
import pairmatching.constants.Enum.Level;

public class Pair {
    private final List<Crew> pair;

    public Pair(List<Crew> pair)  {
        this.pair = pair;
    }

    public boolean equals(Pair other) {
        return this.pair.stream().allMatch(other::contains);
    }

    public int hashCode() {
        int hashCode = 0;
        for (Crew crew : pair) {
            hashCode += crew.hashCode();
        }
        return hashCode / pair.size();
    }

    private boolean contains(Crew crew) {
        return pair.contains(crew);
    }
}
