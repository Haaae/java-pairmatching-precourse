package pairmatching.view.Enum;

import java.util.Arrays;
import java.util.function.Consumer;
import pairmatching.controller.PairMatchingController;
import pairmatching.view.ExceptionHandler;

public enum Rematching {

    YES("네", PairMatchingController::rematch),
    NO("아니오", PairMatchingController::match);

    private final String name;
    private final Consumer<PairMatchingController> consumer;


    Rematching(String name, Consumer<PairMatchingController> consumer) {
        this.name = name;
        this.consumer = consumer;
    }

    public static Rematching from(String symbol) {
        return Arrays.stream(Rematching.values())
                .filter(Rematching -> Rematching.getName().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 재매칭 여부는 '네', '아니오'로 입력해주세요."));
    }

    public void process(PairMatchingController controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public String getName() {
        return name;
    }
}