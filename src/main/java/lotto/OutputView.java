package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASED_FORMAT = "%d개를 구매했습니다.%n";
    private static final String STATS_TITLE = "당첨 통계";
    private static final String STATS_DIVIDER = "---";

    private OutputView() {}

    public static void printTickets(List<Lotto> tickets) {
        System.out.printf(PURCHASED_FORMAT, tickets.size());

        for (Lotto t : tickets) {
            System.out.println(formatTicket(t.numbers()));
        }
    }

    public static void printStatistics(Result result, long spent) {
        System.out.println(STATS_TITLE);
        System.out.println(STATS_DIVIDER);

        Map<Rank, Integer> m = result.snapshot();
        System.out.printf("3개 일치 (5,000원) - %d개%n", m.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", m.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", m.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", m.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", m.get(Rank.FIRST));

        ProfitRate rate = ProfitRate.of(result.totalPrize(), spent);
        System.out.printf("총 수익률은 %s입니다.%n", rate.format());
    }

    private static String formatTicket(List<Integer> numbers) {
        return numbers.toString();
    }
}
