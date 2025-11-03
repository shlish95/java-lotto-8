package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RankResultProfitTest {

    @Test
    void 랭크_매핑() {
        assertEquals(Rank.FIRST, Rank.of(6, false));
        assertEquals(Rank.SECOND, Rank.of(5, true));
        assertEquals(Rank.THIRD, Rank.of(5, false));
        assertEquals(Rank.FOURTH, Rank.of(4, false));
        assertEquals(Rank.FIFTH, Rank.of(3, false));
        assertEquals(Rank.NONE, Rank.of(2, false));
    }

    @Test
    void 집계와_수익률() {
        Result r = new Result();
        r.add(Rank.FIFTH);
        r.add(Rank.FIRST);
        assertEquals(1, r.count(Rank.FIFTH));
        assertEquals(1, r.count(Rank.FIRST));
        long prize = r.totalPrize();
        assertTrue(prize > 0);

        ProfitRate rate = ProfitRate.of(prize, 8_000);
        assertNotNull(rate.format());
    }
}
