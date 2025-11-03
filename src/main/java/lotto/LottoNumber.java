package lotto;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final String ERR = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";

    private final int value;

    public LottoNumber(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(ERR);
        }
        this.value = value;
    }

    public int value() {
        return value;
    }
}
