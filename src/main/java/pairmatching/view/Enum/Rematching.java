package pairmatching.view.Enum;

import java.util.Arrays;

public enum Rematching {

    YES("네"),
    NO("아니오");

    private final String name;

    Rematching(String name) {
        this.name = name;
    }

    public static Rematching from(String symbol) {
        return Arrays.stream(Rematching.values())
                .filter(Rematching -> Rematching.getName().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 다시 매칭 여부는 '네', '아니오'로 입력해주세요."));
    }

    public String getName() {
        return name;
    }
}
