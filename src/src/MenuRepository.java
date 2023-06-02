import java.util.*;

public class MenuRepository {

    /* 필드 */

    // 1. 메인메뉴
    private List<MainMenu> mainMenuList = new ArrayList<>();

    // 2. 상품메뉴
    // private List<ProductMenu> productMenuList = new ArrayList<>();
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


        List<ProductMenu> productMenuList = new ArrayList<>();

        /* Burgers */
        productMenuList.add(new ProductMenu("ShackBurger", 6.9f, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("SmokeShack", 8.9f, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("Shroom Burger", 9.4f, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        productMenuList.add(new ProductMenu("Cheeseburger", 6.9f, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        productMenuList.add(new ProductMenu("Hamburger", 5.4f, "비프패티를 기반으로 야채가 들어간 기본버거"));

        productMenuMap.put(mainMenuList.get(0).getName(), productMenuList);
        productMenuList = new ArrayList<>();

        /* Frozen Custard */
        productMenuList.add(new ProductMenu("Cookie&Cream Shake", 7.5f, "바삭한 화이트 쿠키 크럼블이 매력적인 쉐이크"));
        productMenuList.add(new ProductMenu("Green Tea Shake", 7.5f, "진한 녹차 맛에 바삭한 크럼블이 더해진 시즌 한정 쉐이크"));
        productMenuList.add(new ProductMenu("Classic Shake", 6.5f, "바닐라, 초콜릿, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피"));
        productMenuList.add(new ProductMenu("Floats", 6.5f, "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료"));
        productMenuList.add(new ProductMenu("Cup & Cones", 5.4f, "매장에서 매일 신선하게 제조하는 부드럽고 쫀득한 바닐라, 초콜릿 커스터드"));

        productMenuMap.put(mainMenuList.get(1).getName(), productMenuList);
        productMenuList = new ArrayList<>();

        /* Drinks */
        productMenuList.add(new ProductMenu("Blueberry Lemonade", 4.8f, "상큼한 레몬에이드와 달콤한 블루베리가 만나 탄생한 시즈널 레몬에이드"));
        productMenuList.add(new ProductMenu("Fresh Brewed Iced Tea", 3.5f, "홍차를 직접 우려내어 달지 않고 향긋한 아이스티"));
        productMenuList.add(new ProductMenu("Fifty Fifty", 3.8f, "I gave a second chance to Cupid 널 믿은 내가 정말 stupid"));
        productMenuList.add(new ProductMenu("Hot Tea", 3.4f, "보성 유기농 찻잎을 우려낸 블렌딩 티"));
        productMenuList.add(new ProductMenu("Fountain Soda", 2.9f, "버거와 함께하면 좋은 탄산음료"));
        productMenuList.add(new ProductMenu("Coffee", 3.4f, "쉑 블렌드 원드를 사용한 밸런스 좋은 드립 커피"));
        productMenuList.add(new ProductMenu("Abita Root Beer", 4.4f, "청량감 있는 독특한 미국식 무알콜 탄산음료"));

        productMenuMap.put(mainMenuList.get(2).getName(), productMenuList);
        productMenuList = new ArrayList<>();

        /* Beer */
        productMenuList.add(new ProductMenu("Shack Meister Ale", 6.8f, "시원한 솔향과 고소한 풍미의 몰트향이 버거와 잘 어울리는 에일"));
        productMenuList.add(new ProductMenu("Slow IPA", 6.8f, "홉을 천천히 맥주에 스며들게 하여 끝맛이 깔끔한 IPA"));
        productMenuList.add(new ProductMenu("Gorillager", 6.8f, "가볍고 부드러우면서 드라이한 대중적인 스타일의 라거"));
        productMenuList.add(new ProductMenu("Korea Pale Ale", 6.8f, "한국 스타일에 맞추어 설계한 트로피컬하고 마시기 쉬운 페일 에일"));
        productMenuList.add(new ProductMenu("Yuja Pure Ale", 6.8f, "고흥 유자를 사용하여 가벼우면서도 복합적인 풍미를 가진 에일"));

        productMenuMap.put(mainMenuList.get(3).getName(), productMenuList);
        productMenuList = new ArrayList<>();

    }

}

