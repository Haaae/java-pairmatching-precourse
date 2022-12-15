package pairmatching.view.Enum;

import java.util.Arrays;
import java.util.function.Consumer;
import pairmatching.controller.PairMatchingController;
import pairmatching.view.ExceptionHandler;

public enum Menu {
    PAIR_MATCHING("1", "페어 매칭", PairMatchingController::pairMatch),
    LOOKUP("2", "페어 조회", PairMatchingController::lookUpPairMatching),
    INITIALIZATION("3", "페어 초기화", PairMatchingController::resetPairMatching),
    QUIT("Q", "종료", PairMatchingController -> {});

    private final String symbol;
    private final String phrases;
    private final Consumer<PairMatchingController> consumer;

    Menu(String symbol, String phrases, Consumer<PairMatchingController> consumer) {
        this.symbol = symbol;
        this.phrases = phrases;
        this.consumer = consumer;
    }

    public void process(PairMatchingController controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public static Menu from(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(EnumName -> EnumName.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다."));
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPhrases() {
        return phrases;
    }

    public boolean isQuit() {
        return this == QUIT;
    }
}
