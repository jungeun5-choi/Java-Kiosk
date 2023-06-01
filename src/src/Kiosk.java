import java.util.*;

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
        while(true){

            
        }
    }

}
