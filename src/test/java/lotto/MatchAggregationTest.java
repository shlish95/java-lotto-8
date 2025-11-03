package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchAggregationTest {

    @Test
    void 여러장_집계해서_Result에_누적한다() {
        WinningNumbers w = WinningNumbers.of("1,2,3,4,5,6","7");
        Result result = new Result();

        List<Lotto> tickets = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 1등
                new Lotto(List.of(1,2,3,4,5,7)), // 2등
                new Lotto(List.of(1,2,3,10,11,12)) // 5등
        );

        for (Lotto t : tickets) result.add(LottoJudge.judge(t, w));

        assertEquals(1, result.count(Rank.FIRST));
        assertEquals(1, result.count(Rank.SECOND));
        assertEquals(1, result.count(Rank.FIFTH));
        assertEquals(3, result.snapshot().values().stream().mapToInt(i->i).sum());
    }
}
