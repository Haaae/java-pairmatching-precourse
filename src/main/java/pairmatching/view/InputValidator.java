package pairmatching.view;

import java.util.List;

public class InputValidator {

    private static final int PAIR_MATCHING_INPUT_SIZE = 3;

    public static void pairMatchingInputSizeValidate(
            List<String> pairMatchingInput) {
        if (pairMatchingInput.size() != PAIR_MATCHING_INPUT_SIZE) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다.");
        }
    }
}
