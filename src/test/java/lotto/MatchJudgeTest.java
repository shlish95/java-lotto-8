package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchJudgeTest {

    @Test
    void 여섯개_일치면_1등() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumbers w = WinningNumbers.of("1,2,3,4,5,6", "7");
        assertEquals(Rank.FIRST, LottoJudge.judge(lotto, w));
    }

    @Test
    void 다섯개_일치_보너스_일치면_2등() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        WinningNumbers w = WinningNumbers.of("1,2,3,4,5,6", "7");
        assertEquals(Rank.SECOND, LottoJudge.judge(lotto, w));
    }

    @Test
    void 다섯개_일치_보너스_불일치면_3등() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        WinningNumbers w = WinningNumbers.of("1,2,3,4,5,6", "7");
        assertEquals(Rank.THIRD, LottoJudge.judge(lotto, w));
    }

    @Test
    void 네개_일치면_4등_세개면_5등_그외_NONE() {
        assertEquals(Rank.FOURTH,
                LottoJudge.judge(new Lotto(List.of(1,2,3,4,10,11)),
                        WinningNumbers.of("1,2,3,4,5,6","7")));
        assertEquals(Rank.FIFTH,
                LottoJudge.judge(new Lotto(List.of(1,2,3,10,11,12)),
                        WinningNumbers.of("1,2,3,4,5,6","7")));
        assertEquals(Rank.NONE,
                LottoJudge.judge(new Lotto(List.of(1,9,10,11,12,13)),
                        WinningNumbers.of("1,2,3,4,5,6","7")));
    }
}
