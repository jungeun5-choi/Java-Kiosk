public class Main {

    public static void main(String[] args) {

        // 메인에서 객체 생성 후 생성자로 전달
        Order order = new Order();
        Screen screen = new Screen(order);
        Kiosk kiosk = new Kiosk(order, screen);

        // 키오스크 진입
        kiosk.startKiosk();
    }
}

