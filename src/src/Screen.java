import java.util.*;

/// Viewer
public class Screen {

    private Order order;
    private Scanner sc;

    Screen(Order order) {
        this.order = order;

        sc = new Scanner(System.in);
    }


    // 1-1. 메인 조회
    public int viewMainMenu(){

        /* 상단메뉴 [ SHAKESHACK MENU ] */

        System.out.printf("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n");
        System.out.printf("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n\n");

        System.out.printf("[ SHAKESHACK MENU ]\n");

        // 임시 List 생성
        List<MainMenu> mainMenus = order.getRepo().getMainMenuList();

        // 출력
        int i = 0;
        for(; i < mainMenus.size(); i++) {

            System.out.printf("%d. %-15s | %s \n",
                    i+1, mainMenus.get(i).getName(), mainMenus.get(i).getExplain());
        }
        System.out.printf("\n"); // 한줄띄우기

        /* 하단메뉴 [ ORDER MENU ] */
        System.out.printf("[ ORDER MENU ]\n");
        System.out.printf("%d. Order\t| 장바구니를 확인 후 주문합니다. \n", i+=1);
        System.out.printf("%d. Cancel\t| 진행중인 주문을 취소합니다. \n", i+=1);
        System.out.printf("\n"); // 한줄띄우기

        /* 선택 */
        System.out.printf("선택: ");
        // (입력 값 - 1) 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }
    // 1-2. 상품 조회
    public ProductMenu viewProductMenu(String mainMenuName){

        System.out.printf("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"\n");
        System.out.printf("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n\n");

        System.out.printf("[%s MENU] \n", mainMenuName);

        // 임시 List 생성
        List<ProductMenu> productMenus = order.getRepo().getProductList(mainMenuName);

        // 출력
        for(int i = 0; i < productMenus.size(); i++) {

            System.out.printf("%d. %-15s | %.1f | %s \n",
                    i+1, productMenus.get(i).getName(),
                    productMenus.get(i).getPrice(), productMenus.get(i).getExplain());
        }
        System.out.printf("\n"); // 한줄띄우기

        System.out.printf("선택: ");
        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;

        // 선택한 상품을 출력해줌
        System.out.printf("%-15s | %.1f | %s \n",
                productMenus.get(select).getName(), productMenus.get(select).getPrice(),
                productMenus.get(select).getExplain());

        return productMenus.get(select);
    }

    // 2-1. 장바구니 추가 확인 문구
    public int confirmAddingProductToCart() {

        System.out.printf("위 메뉴를 장바구니에 추가하시겠습니까?\n");
        System.out.printf("1. 확인 \t 2. 취소\n\n");

        System.out.printf("선택: ");

        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }

    // 2-1-1. 장바구니 추가 선택지 확인 문구
    public void cartSelectionConfirmed(int selectCart, ProductMenu productMenu) {

        if(selectCart == 0) { // 예 (장바구니에 추가함)

            System.out.printf("%s 가 장바구니에 추가되었습니다.\n\n", productMenu.getName());

        } else { // 아니오 (장바구니에 추가하지 않음)

            System.out.printf("이전화면으로 돌아갑니다.\n\n");
        }

    }

    // 3. 장바구니 조회
    public int viewCart() {

        // 가격 총합을 저장할 변수
        float sum = 0;

        System.out.printf("아래와 같이 주문 하시겠습니까?\n\n");

        /* 현재 장바구니 목록 [ Orders ]*/
        System.out.printf("[ Orders ]\n");

        // 임시 List 생성
        List<ProductMenu> cartList = order.getCart().getCurrentCartList();
        for(int i = 0; i < cartList.size(); i++) {

            System.out.printf("%-15s | %.1f | %s \n",
                    cartList.get(i).getName(), cartList.get(i).getPrice(), cartList.get(i).getExplain());

            // 가격 총합 계산
            sum += cartList.get(i).getPrice();
        }
        System.out.printf("\n"); // 한줄띄우기

        /* 현재 가격 [ Total ]*/
        System.out.printf("[ Total ]\n");
        System.out.printf("W %.2f\n\n", sum);
        System.out.printf("1. 주문 \t 2. 메뉴판\n\n");

        /* 선택 */
        System.out.printf("선택: ");

        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }

    // 3-1. 장바구니 초기화

    // 4. 대기번호 전달(호출?)
    public void viewWaitingNumber(int waitingNumber) {

        System.out.printf("주문이 완료되었습니다!\n\n");

        // 현재 대기번호 출력
        System.out.printf("대기번호는 [ %d ] 번 입니다.\n", waitingNumber);
        System.out.printf("(3초 후 메뉴판으로 돌아갑니다...)\n\n");
    }

    // 5. 취소
    public int viewCancel() {

        System.out.printf("주문을 취소하시겠습니까?\n");
        System.out.printf("1. 예 \t 2. 아니오\n\n");

        /* 선택 */
        System.out.printf("선택: ");

        // (입력 값 - 1)에 해당하는 상품 반환, index는 0부터 시작이므로.
        int select = sc.nextInt() - 1;
        return select;
    }
}
