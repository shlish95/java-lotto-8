package lotto;

public final class LottoJudge {

    private LottoJudge() {}

    public static Rank judge(Lotto ticket, WinningNumbers winning) {
        int match = ticket.countMatchesWith(winning.main());
        boolean bonus = (match == 5) && ticket.contains(winning.bonus());
        return Rank.of(match, bonus);
    }
}
