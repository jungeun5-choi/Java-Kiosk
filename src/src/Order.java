public class Order {

    /* 필드 */
    MenuRepository menuRepository; // 메인, 상품
    Cart cart = new Cart(); // 장바구니
    WaitingNumber waitingNumber = new WaitingNumber(); // 대기번호

    float price = 0;


    /* 생성자 */
    Order() {
        menuRepository = new MenuRepository();
    }
    Order(float price) {
        this.price = price;
    }


    /* 메서드 */

    // 장바구니에 상품 추가
    public void addProductToCart(ProductMenu productMenu) {

        // 물건 추가
        cart.addCurrentCartList(productMenu);

        // 가격 합산
        price = cart.setSumPrice(productMenu.getPrice());
    }

    // 장바구니에 비우기
    public void clearCart() {

        // 장바구니 비우기
        cart.clearCurrentCartList();
        // 가격 초기화
        price = cart.clearSumPrice();
    }


    /* getter */
    public MenuRepository getRepo() { return menuRepository; }
    public Cart getCart() { return cart; }
    public WaitingNumber getWaitingNumber() { return  waitingNumber; }

}
