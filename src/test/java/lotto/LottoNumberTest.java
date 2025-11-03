package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberAndFactoryTest {

    @Test
    void LottoNumber_범위_1_에서_45() {
        assertDoesNotThrow(() -> new LottoNumber(1));
        assertDoesNotThrow(() -> new LottoNumber(45));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
    }

    @Test
    void 숫자_6개_정렬되고_중복없어야() {
        List<Integer> made = LottoTicketFactory.sortedUniqueSix(List.of(8, 21, 23, 41, 42, 43));
        assertEquals(List.of(8,21,23,41,42,43), made);
    }

    @Test
    void 개수_6개_아니면_예외() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicketFactory.sortedUniqueSix(List.of(1,2,3,4,5)));
    }

    @Test
    void 중복이_있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicketFactory.sortedUniqueSix(List.of(1,1,3,4,5,6)));
    }

    @Test
    void 범위밖_숫자_있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicketFactory.sortedUniqueSix(List.of(0,2,3,4,5,6)));
    }
}
