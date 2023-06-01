import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<ProductMenu> currentProductList = new ArrayList<>();

    private float sumPrice = 0;


    /* 메서드 */
    public List<ProductMenu> getCurrentCartList() {
        return currentProductList;
    }
    public List<ProductMenu> addCurrentCartList(ProductMenu productMenu) {
        currentProductList.add(productMenu);
        return currentProductList;
    }
    public List<ProductMenu> clearCurrentCartList() {
        currentProductList.clear();
        return currentProductList;
    }

    public float getSumPrice() {
        return sumPrice;
    }
    public float setSumPrice(float price) {
        return sumPrice += price;
    }
    public float clearSumPrice() {
        sumPrice = 0;
        return sumPrice;
    }
}
