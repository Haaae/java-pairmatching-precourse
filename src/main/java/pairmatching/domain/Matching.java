package pairmatching.domain;

import java.util.List;
import java.util.stream.Stream;

public class Matching {

    private final List<Pair> pairs;

    public Matching(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public boolean isDuplicate(Matching matching) {
        return matching.pairs.stream().anyMatch(this.pairs::contains);
    }

    public boolean isEmpty() {
        return pairs.isEmpty();
    }

    public Stream<Pair> getMatchingStream() {
        return pairs.stream();
    }
}
