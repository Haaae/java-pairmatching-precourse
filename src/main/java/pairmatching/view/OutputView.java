package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.domain.Matching;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Menu;
import pairmatching.view.Enum.Mission;
import pairmatching.view.Enum.Rematching;

public class OutputView {

    private final static String MENU_HEADLINE = "기능을 선택하세요";
    private final static String REMATCHING_ADVICE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private final static String MATCHING_NOTICE = "페어 매칭 결과입니다.";
    private final static String RESET_NOTICE = "초기화 되었습니다.";
    private final static String BAR = "#############################################";
    private final static String PAIR_MATCHING_COURSE = "과정:";
    private final static String PAIR_MATCHING_MISSION = "미션:";
    private final static String PAIR_MATCHING_ADVICE = "과정, 레벨, 미션을 선택하세요.";
    private final static String PAIR_MATCHING_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String MENU_DELIMITER = " | ";
    private static final String TAB = "\b";
    private static final String HYPHEN = "-";
    private static final String COLON = ":";
    private final static String DAT = ".";
    private final static String SPACE = " ";
    private static final String MATCHING_DELIMITER = SPACE + COLON + SPACE;


    public static void printMatching(Matching matching) {
        System.out.println();
        System.out.println(MATCHING_NOTICE);
        matching.getMatchingStream()
                .forEach(pair -> System.out.println(
                        pair.joinToString(MATCHING_DELIMITER)));
    }

    public static void printResetNotice() {
        System.out.println();
        System.out.println(RESET_NOTICE);
    }

    public static void printNoMatchingRecord() {
        System.out.println();
        System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }

    public static void printRematching() {
        System.out.println(REMATCHING_ADVICE);
        System.out.println(Arrays.stream(Rematching.values())
                .map(Rematching::getName)
                    .collect(
                        Collectors.joining(MENU_DELIMITER)));
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(MENU_HEADLINE);

        for (Menu menu : Menu.values()) {
            System.out.println(menu.getSymbol()
                    + DAT
                    + SPACE
                    + menu.getPhrases());
        }
    }

    public static void printPairMatchingInformation() {
        System.out.println();
        printPairMatchingBar();
        printPairMatchingCourse();
        printPairMatchingMission();
        printPairMatchingBar();
    }

    public static void printPairMatchingAdvice() {
        System.out.println(PAIR_MATCHING_ADVICE);
        System.out.println(PAIR_MATCHING_EXAMPLE);
    }

    private static void printPairMatchingCourse() {
        System.out.println(PAIR_MATCHING_COURSE
                + Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(MENU_DELIMITER)));
    }

    private static void printPairMatchingBar() {
        System.out.println(BAR);
    }

    private static void printPairMatchingMission() {
        System.out.println(PAIR_MATCHING_MISSION);
        for (Level level : Level.values()) {
            System.out.println(TAB + HYPHEN + SPACE + level.getName() + COLON + SPACE
                                + level.getMissionNames()
                                    .stream()
                                        .map(Mission::getMission)
                                            .collect(Collectors.joining(MENU_DELIMITER)));
        }
    }
}
