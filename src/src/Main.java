public class Main {

    public static void main(String[] args) {

        // 장바구니 출력 테스트
        Order order = new Order();
        Screen screen = new Screen();

        order.addProductToCart(order.getRepo().getProduct("Burgers", 0));
        order.addProductToCart(order.getRepo().getProduct("Burgers", 1));
        order.addProductToCart(order.getRepo().getProduct("Burgers", 2));

        screen.viewCart(order);
    }
}

