import java.util.*;

public class Screen {

    private Order order = new Order();


    // Viewer


    // 1-1. 메인 조회
    void viewMainMenu(){

        // 새로운 List 생성
        List<MainMenu> mainMenus = new ArrayList<>();
        // repo에서 호출
        //mainMenus = menuRepository.getMainMenuList();

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
        //productMenus = menuRepository.getProductList("");

        // 출력

    }

    // 2. 장바구니 조회
    void viewCart(Order order) {
        
        // 가독성용 임시 변수
        List<ProductMenu> tempList = order.getCart().getCurrentCartList();

        for(int i = 0; i < tempList.size(); i++) {

            System.out.printf("메뉴 이름: %s\t메뉴 가격: %.1f\t메뉴 설명: %s\n"
                    ,tempList.get(i).getName(), tempList.get(i).getPrice(), tempList.get(i).getExplain());
        }
    }

    // 3. 대기번호 전달(호출?)
}
