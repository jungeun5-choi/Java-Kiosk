public class WaitingNumber {

    int currentNumber = 0;

    WaitingNumber() {
        this.currentNumber = 0;
    }

    public void increaseWaitingNumber() {

        // 1만큼 증가
        currentNumber += 1;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
