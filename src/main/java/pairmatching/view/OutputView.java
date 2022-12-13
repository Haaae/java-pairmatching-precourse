package pairmatching.view;

public class OutputView {

    private final static String MENU_HEADLINE = "기능을 선택하세요";
    private final static String MENU_PAIR_MATCHING = "1. 페어 매칭";
    private final static String MENU_LOOKUP = "2. 페어 조회";
    private final static String MENU_INITIALIZATION = "2. 페어 초기화";
    private final static String MENU_QUIT = "Q. 종료";

    public static void printMenu() {
        System.out.println(MENU_HEADLINE);
        System.out.println(MENU_PAIR_MATCHING);
        System.out.println(MENU_LOOKUP);
        System.out.println(MENU_INITIALIZATION);
        System.out.println(MENU_QUIT);
    }
}
