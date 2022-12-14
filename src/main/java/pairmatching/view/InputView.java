package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.DTO.MenuDTO;
import pairmatching.DTO.PairMatchingDTO;
import pairmatching.DTO.RematchingDTO;
import pairmatching.view.Enum.Course;
import pairmatching.view.Enum.Level;
import pairmatching.view.Enum.Menu;
import pairmatching.view.Enum.Mission;
import pairmatching.view.Enum.Rematching;

public class InputView {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final static MenuDTO menuDTO = new MenuDTO();
    private final static PairMatchingDTO pairMatchingDTO = new PairMatchingDTO();
    private final static RematchingDTO rematchingDTO = new RematchingDTO();

    public static MenuDTO readMenu() {
        OutputView.printMenu();
        return convertToMenuDTO(Console.readLine().trim());
    }

    public static PairMatchingDTO readPairMatching() {
        OutputView.printPairMatchingInformation();
        return convertToPairMatchingDTO(Console.readLine().trim());
    }

    public static RematchingDTO readRematching() {
        OutputView.printRematching();
        return convertToRematchingDTO(Console.readLine().trim());
    }

    private static PairMatchingDTO convertToPairMatchingDTO(String input) {
        List<String> pairMatchingInput = List.of(input.split(","));
        InputValidator.pairMatchingInputSizeValidate(pairMatchingInput);
        Course course = Course.from(pairMatchingInput.get(COURSE_INDEX));
        Level level = Level.from(pairMatchingInput.get(LEVEL_INDEX));
        Mission mission = Mission.from(pairMatchingInput.get(MISSION_INDEX));
        mission.in(level);
        return pairMatchingDTO.setParMatchingDTO(course, level, mission);
    }

    private static RematchingDTO convertToRematchingDTO(String rematchingInput) {
        return rematchingDTO.setRematchingDTO(
                Rematching.from(rematchingInput));
    }

    private static MenuDTO convertToMenuDTO(String menuInput) {
        return menuDTO.setMenu(Menu.from(menuInput));
    }
}