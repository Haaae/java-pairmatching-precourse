package pairmatching.view.Enum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static boolean contains(String input) {
        return Arrays.stream(Level.values()).anyMatch(level -> input.equals(level.name));
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissionNames() {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.getLevel().equals(this))
                .collect(Collectors.toList());
    }

    public static Level from(String level) {
        return Arrays.stream(Level.values())
                .filter(Level -> Level.getName().equals(level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 일치하는 레벨이 없습니다."));
    }
}
