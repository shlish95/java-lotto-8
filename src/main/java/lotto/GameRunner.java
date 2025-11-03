package lotto;

import java.util.List;

public class GameRunner {

    public void run() {
        PurchaseAmount amount = InputView.readPurchaseAmount();

        LottoMachine machine = new LottoMachine();
        List<Lotto> ticket = machine.issue(amount);
        System.out.println();
        OutputView.printTickets(ticket);

        WinningNumbers winning = InputView.readWinningNumbers();
        System.out.println();

        Result result = new Result();
        for (Lotto t : ticket) {
            Rank rank = LottoJudge.judge(t, winning);
            result.add(rank);
        }

        OutputView.printStatistics(result, amount.value());
    }
}
