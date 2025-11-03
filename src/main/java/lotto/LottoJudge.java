package lotto;

import java.util.List;

public class LottoJudge {

    private LottoJudge() {}

    public static Rank judge(Lotto ticket, WinningNumbers winning) {
        List<Integer> t = ticket.numbers();
        List<Integer> w = winning.main();

        int matchCount = 0;
        for (int n : t) {
            if (w.contains(n)) {
                matchCount++;
            }
        }

        boolean bonusMatched = t.contains(winning.bonus());
        return Rank.of(matchCount, bonusMatched);
    }
}
