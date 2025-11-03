package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {

    @Test
    void 천원_단위면_장수_계산된다() {
        PurchaseAmount amount = new PurchaseAmount("8000");
        assertEquals(8, amount.countTickets());
        assertEquals(8000L, amount.value());
    }

    @Test
    void 빈값_공백_null_이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(""));
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount("   "));
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount(null));
    }

    @Test
    void 숫자가_아니면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount("8a00"));
    }

    @Test
    void 음수_영_이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount("0"));
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount("-1000"));
    }

    @Test
    void 천원단위_아니면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new PurchaseAmount("1500"));
    }
}
