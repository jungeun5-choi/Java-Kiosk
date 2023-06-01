/// Controller
public class Kiosk {

    /* 필드 */
    private Order order;
    private Screen screen;

    Kiosk(Order order, Screen screen) {
        this.order = order;
        this.screen = screen;
    }


    /* 메서드 */

    // 키오스크 진입점, 외부에서 호출할 때 사용
    public void startKiosk() {

        //System.out.printf("start Kiosk 진입완료\n");
        processKiosk(); // 키오스크 실행
    }

    // 실제로 돌아가는 키오스크
    private void processKiosk() {
        //System.out.printf("process Kiosk 진입완료\n");

        // ### 메인메뉴 진입
        // ### 참고 ### selectMain = (입력값 - 1) 이다.
        int selectMain = screen.viewMainMenu();

        while (true) {
            switch (selectMain) {
                // ### 메인 메뉴 선택 시
                case 0:
                case 1:
                case 2:
                case 3:
                {
                    // ### 상품 메뉴 호출 후,
                    String mainMenuName = order.getRepo().getMainMenuName(selectMain); // 메인메뉴 이름
                    ProductMenu product = screen.viewProductMenu(mainMenuName);
                    // 반환 값 전달
                    // ### 장바구니 상품 추가 확인 메세지 출력
                    int selectCart = screen.confirmAddingProductToCart();
                    // ### 장바구니 추가 선택지 확인 문구 출력
                    screen.cartSelectionConfirmed(selectCart, product);
                    if(selectCart == 0) {
                        // ### 장바구니에 물건 추가
                        order.addProductToCart(product);
                        selectMain = screen.viewMainMenu();
                    }

                    break;
                }
                case 4: // Order
                    break;
                case 5: // Cancel
                    break;
            }
        }


    }
}
