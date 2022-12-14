package pairmatching.DTO;

import pairmatching.view.Enum.Menu;

/**
 * Menu 입력값을 Controller 쪽으로 전달할 때 사용하는 DTO
 */
public class MenuDTO {

    private Menu menu;

    public MenuDTO() {}

    public MenuDTO setMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public Menu getMenu() {
        return menu;
    }

}
