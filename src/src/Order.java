import java.util.*;

public class Order {

    /* 필드 */
    MenuRepository menuRepository = new MenuRepository(); // 메인, 상품
    Cart cart = new Cart(); // 장바구니
    WaitingNumber waitingNumber = new WaitingNumber(); // 대기번호


    /* 메서드 */

    // 1-1. 메인 조회
    void viewMainMenu(){

        // 새로운 List 생성
        List<MainMenu> mainMenus = new ArrayList<>();
        // repo에서 호출
        mainMenus = menuRepository.getMainMenuList();

        // 출력
        for(int i = 0; i < mainMenus.size(); i++) {

            System.out.printf("메뉴 이름: %s, 메뉴 설명: %s\n"
                    , mainMenus.get(i).getName(), mainMenus.get(i).getExplain());
        }
    }
    // 1-2. 상품 조회
    void viewProductMenu(){

        // 새로운 List 생성
        List<ProductMenu> productMenus = new ArrayList<>();
        // repo에서 호출
        productMenus = menuRepository.getProductList("");

        // 출력

    }

    // 2. 장바구니 조회

    // 3. 대기번호 전달(호출?)
}
