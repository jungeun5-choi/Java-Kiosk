import java.util.*;

public class Screen {

    private Order order;
    private Scanner sc;

    Screen(Order order) {
        this.order = order;

        sc = new Scanner(System.in);
    }

    // Viewer


    // 1-1. 메인 조회
    public int viewMainMenu(){

        // 새로운 List 생성
        List<MainMenu> mainMenus = order.getRepo().getMainMenuList();

        // 출력
        for(int i = 0; i < mainMenus.size(); i++) {

            System.out.printf("%d. %s\t | %s \n",
                    i+1, mainMenus.get(i).getName(), mainMenus.get(i).getExplain());
        }

        System.out.printf("선택: ");
        // (입력 값 - 1) 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }
    // 1-2. 상품 조회
    public ProductMenu viewProductMenu(String mainMenuName){

        System.out.printf("%s를 선택하셨습니다\n\n", mainMenuName);


        // 새로운 List 생성
        List<ProductMenu> productMenus = order.getRepo().getProductList(mainMenuName);

        // 출력
        for(int i = 0; i < productMenus.size(); i++) {

            System.out.printf("%d. %s\t | %.1f | \t %s \n",
                    i+1, productMenus.get(i).getName(),
                    productMenus.get(i).getPrice(), productMenus.get(i).getExplain());
        }

        System.out.printf("선택: ");
        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;

        // 선택한 상품을 출력해줌
        System.out.printf("%s\t | %.1f | \t %s \n"
                , productMenus.get(select).getName(), productMenus.get(select).getPrice(), productMenus.get(select).getExplain());

        return productMenus.get(select);
    }

    // 2-1. 장바구니 추가 확인 문구
    public int confirmAddingProductToCart() {

        System.out.printf("위 메뉴를 장바구니에 추가하시겠습니까?\n");
        System.out.printf("1. 확인 \t 2. 취소\n");

        System.out.printf("선택: ");

        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }

    // 2-1-1. 장바구니 추가 선택지 확인 문구
    public void cartSelectionConfirmed(int selectCart, ProductMenu productMenu) {
        if(selectCart == 0) { // 예 (장바구니에 추가함)

            System.out.printf("%s가 장바구니에 추가되었습니다.\n\n", productMenu.getName());

        } else { // 아니오 (장바구니에 추가하지 않음)

            System.out.printf("이전화면으로 돌아갑니다.\n\n");
        }

    }

    // 2-2. 장바구니 조회
    public void viewCart() {
        
        // 가독성용 임시 변수
        List<ProductMenu> tempList = order.getCart().getCurrentCartList();

        for(int i = 0; i < tempList.size(); i++) {

            System.out.printf("%s\t | %.1f | \t %s \n"
                    , tempList.get(i).getName(), tempList.get(i).getPrice(), tempList.get(i).getExplain());
        }
    }



    // 3. 대기번호 전달(호출?)
}
