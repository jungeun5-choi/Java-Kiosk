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

        // ### 참고 ### selectMain = (입력값 - 1) 이다.
        int selectMain  = 0;
        int mainSize = order.getRepo().getMainMenuList().size();

        while (true) {
            // ### 메인메뉴 진입
            selectMain = screen.viewMainMenu();

            // 입력값이 등록된 메인메뉴 개수보다 적거나 같음
            //  = 메인메뉴를 선택했다! 는 뜻
            // ### PRODUCT MENU ####
            if (selectMain < mainSize) {

                // ### 1. 상품 메뉴 호출 후,
                String mainMenuName = order.getRepo().getMainMenuName(selectMain); // 메인메뉴 이름
                // 장바구니에 넣을 상품 반환
                ProductMenu product = screen.viewProductMenu(mainMenuName);

                if (product != null) {

                    // ### 2. 장바구니 상품 추가 확인 메세지 출력
                    int selectCart = screen.confirmAddingProductToCart();
                    // ### 3. 장바구니 추가 선택지 확인 문구 출력
                    screen.cartSelectionConfirmed(selectCart, product);

                    // ### 4. 장바구니에 물건 추가 (추가한다고 했을 때만)
                    if (selectCart == 0) {
                        order.addProductToCart(product);
                    }
                }

            // ### ORDER ####
            } else if (selectMain == mainSize) {
                // 입력값 == 메인사이즈
                //  = Order를 선택했다! 는 뜻

                // 장바구니에 뭐가 들어있을 때만
                if(order.getCart().getCurrentCartList().size() > 0)
                {
                    // ### 장바구니 조회
                    int selectCart = screen.viewCart();

                    // ### 1. 주문 선택 시
                    if (selectCart == 0) {

                        // ### 2. 카트 비우기
                        order.clearCart();
                        // ### 3. 대기번호 발급
                        // 대기번호 증가
                        int wn = order.increaseWaitingNumber();
                        screen.viewWaitingNumber(wn);

                        // ### 4. 3초 대기
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                // 장바구니에 아무것도 없을 때
                } else {
                    screen.viewCartIsEmpty();
                }

            // ### CANCEL ####
            } else if (selectMain == mainSize + 1){
                // 입력값 == 메인사이즈 + 1
                //  = Cancel를 선택했다! 는 뜻

                // ### Q. 취소하시겠습니까?
                int selectCancel = screen.viewCancel();

                // ### A. 예
                if(selectCancel == 0) {
                    order.clearCart();
                }
            } else { // 범위 바깥
                screen.viewWarning();
            }
        }
    }
}
