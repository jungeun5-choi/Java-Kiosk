public class Order {

    /* 필드 */
    private MenuRepository menuRepository; // 메인, 상품
    private Cart cart; // 장바구니
    private WaitingNumber waitingNumber; // 대기번호

    private float price = 0;


    /* 생성자 */
    Order() {
         // 생성하면서 초기화
        this.menuRepository = new MenuRepository();
        this.cart = new Cart();
        this.waitingNumber = new WaitingNumber();

        this.price = 0;
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
    public int increaseWaitingNumber() {
        // 1만큼 증가
        return waitingNumber.increaseCurrentNumber();
    }

}
