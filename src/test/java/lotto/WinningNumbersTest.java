package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 파싱_정상() {
        WinningNumbers w = WinningNumbers.of("1,2,3,4,5,6", "7");
        assertEquals(6, w.main().size());
        assertEquals(7, w.bonus());
    }

    @Test
    void 메인번호_6개_중복없음_범위() {
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of("1,2,3,4,5", "7"));       // 개수
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of("1,2,3,4,5,5", "7"));     // 중복
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of("0,2,3,4,5,6", "7"));     // 범위
    }

    @Test
    void 보너스_범위내_그리고_메인과_중복불가() {
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of("1,2,3,4,5,6", "1"));
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of("1,2,3,4,5,6", "46"));
    }
}
