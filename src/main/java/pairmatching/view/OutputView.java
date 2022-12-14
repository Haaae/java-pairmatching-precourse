package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Menu;
import pairmatching.view.Enum.Rematching;

public class OutputView {

    private final static String MENU_HEADLINE = "기능을 선택하세요";
    private final static String REMATCHING_ADVICE = "기능을 선택하세요";
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


    public static void printRematching() {
        System.out.println(REMATCHING_ADVICE);
        System.out.println(Arrays.stream(Rematching.values())
                .map(Object::toString)
                    .collect(
                        Collectors.joining(MENU_DELIMITER)));
    }

    public static void printMenu() {
        System.out.println(MENU_HEADLINE);

        for (Menu menu : Menu.values()) {
            System.out.println(menu.getSymbol()
                    + DAT
                    + SPACE
                    + menu.getPhrases());
        }
    }

    public static void printPairMatchingInformation() {
        printPairMatchingBar();
        printPairMatchingCourse();
        printPairMatchingMission();
        printPairMatchingBar();
        printPairMatchingAdvice();
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
                                        .map(Object::toString)
                                            .collect(Collectors.joining(MENU_DELIMITER)));
        }
    }

    private static void printPairMatchingAdvice() {
        System.out.println(PAIR_MATCHING_ADVICE);
        System.out.println(PAIR_MATCHING_EXAMPLE);
    }

}
