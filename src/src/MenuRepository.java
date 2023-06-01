import java.util.*;

public class MenuRepository {

    /* 필드 */

    // 1. 메인메뉴
    private List<MainMenu> mainMenuList = new ArrayList<>();

    // 2. 상품메뉴
    private List<ProductMenu> productMenuList = new ArrayList<>();
    private Map<String, List<ProductMenu>> productMenuMap = new HashMap<>();


    /* 생성자 */
    MenuRepository() {

        saveInformation();
    }



    /* 메서드 */
    public List<MainMenu> getMainMenuList() {
        return mainMenuList;
    }
    public String getMainMenuName(int index) {
        return mainMenuList.get(index).name;
    }
    public String getMainMenuExplain(int index) {
        return mainMenuList.get(index).explain;
    }

    public List<ProductMenu> getProductList(String mainMenuName) {

        // key 값에 맞는 List 반환
        return productMenuMap.get(mainMenuName);        
    }
    public ProductMenu getProduct(String mainMenuName, int index) {

        return productMenuMap.get(mainMenuName).get(index);
    }



    /* 정보 저장 */
    private void saveInformation() {

        mainMenuList.add(new MainMenu("Burgers", "앵거스 비프 통살을 다져만든 버거"));
        mainMenuList.add(new MainMenu("Forzen Custard", "매장에서 신선하게 만드는 아이스크림"));
        mainMenuList.add(new MainMenu("Drinks", "매장에서 직접 만드는 음료"));
        mainMenuList.add(new MainMenu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        productMenuList.add(new ProductMenu("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("Shroom Burger", 9.4f, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        productMenuList.add(new ProductMenu("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        productMenuMap.put(mainMenuList.get(0).getName(), productMenuList);
    }

}

