package pairmatching.DTO;

import pairmatching.constants.Enum.Menu;

/**
 * Menu 입력값을 Controller 쪽으로 전달할 때 사용하는 DTO
 */
public class MenuDTO {

    private static final String EXCEPTION_MENU_INPUT = "[ERROR] 메뉴는 '1', '2', '3', 'Q' 중 하나를 선택해주세요.";

    private Menu menuInput;

    public MenuDTO() {}

    public void setMenuInput(String menuInput) {
        validate(menuInput);
        this.menuInput = Menu.valueOf(menuInput);
    }

    public Menu getMenuInput() {
        return menuInput;
    }

    private void validate(String menuInput) {
        if (!Menu.contains(menuInput)) {
            throw new IllegalArgumentException(EXCEPTION_MENU_INPUT);
        }
    }

}
