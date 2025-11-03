package lotto;

public final class PurchaseAmount {
    private static final long UNIT = 1_000L;
    private static final String ERR_PREFIX = "[ERROR] ";
    private static final String ERR_EMPTY = ERR_PREFIX + "구입 금액을 입력해 주세요.";
    private static final String ERR_NUMBER = ERR_PREFIX + "구입 금액은 숫자여야 합니다.";
    private static final String ERR_POSITIVE = ERR_PREFIX + "구입 금액은 1,000원 이상이어야 합니다.";
    private static final String ERR_UNIT = ERR_PREFIX + "구입 금액은 1,000원 단위여야 합니다.";

    private final long value;

    public PurchaseAmount(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERR_EMPTY);
        }

        final long parsed;
        try {
            parsed = Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_NUMBER);
        }

        if (parsed <= 0) {
            throw new IllegalArgumentException(ERR_POSITIVE);
        }
        if (parsed % UNIT != 0) {
            throw new IllegalArgumentException(ERR_UNIT);
        }

        this.value = parsed;
    }

    public long value() {
        return value;
    }

    public int countTickets() {
        return (int)(value / UNIT);
    }
}
