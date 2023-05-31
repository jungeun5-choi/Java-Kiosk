import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<ProductMenu> currentProductList = new ArrayList<>();

    private int sumPrice = 0;


    /* 메서드 */

    // 장바구니에 상품 추가
    public void addProductToCart(ProductMenu productMenu) {

        // 물건 추가
        currentProductList.add(productMenu);

        // 가격 합산
        sumPrice += productMenu.getPrice();
    }

    // 장바구니에 비우기
    public void clearCart() {

        // 장바구니 비우기
        currentProductList.clear();
        // 가격 초기화
        sumPrice = 0;
    }


    // 장바구니 정보 받아오기
    public List<ProductMenu> getCart() {
        return currentProductList;
    }
    public int getSumPrice() {
        return sumPrice;
    }
}
