package pairmatching.view.Enum;

import java.util.Arrays;

public enum Mission {

    RACE("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_BASKET("장바구니", Level.LEVEL3),
    PAYMENT("결제", Level.LEVEL3),
    SUBWAY_MAP("지하철 노선도", Level.LEVEL3),
    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL3),
    DISTRIBUTE("배포", Level.LEVEL3);

    private final String mission;
    private final Level level;

    Mission(String mission, Level level) {
        this.mission = mission;
        this.level = level;

    }

    public static boolean contains(String input) {
        return Arrays.stream(Mission.values()).
                anyMatch(mission -> input.equals(mission.mission));
    }

    public static Mission from(String mission) {
        return Arrays.stream(Mission.values())
                .filter(Mission -> Mission.getMission().equals(mission))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 미션이 없습니다."));
    }

    public String getMission() {
        return mission;
    }

    public Level getLevel() {
        return level;
    }

    public void in(Level level) {
        if (this.level != level) {
            throw new IllegalArgumentException("미션이 입력한 레벨에 포함되지 않습니다.");
        }
    }
}
