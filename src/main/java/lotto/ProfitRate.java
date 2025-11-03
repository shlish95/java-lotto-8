package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private final BigDecimal percent;

    private ProfitRate(BigDecimal decimal) {
        this.percent = decimal;
    }

    public static ProfitRate of(long totalPrize, long spent) {
        if (spent <= 0) {
            return new ProfitRate(BigDecimal.ZERO);
        }

        BigDecimal v = BigDecimal.valueOf(totalPrize)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(spent), 10, RoundingMode.HALF_UP)
                .setScale(1, RoundingMode.HALF_UP);

        return new ProfitRate(v);
    }

    public String format() {
        return percent.stripTrailingZeros().toPlainString();
    }
}
