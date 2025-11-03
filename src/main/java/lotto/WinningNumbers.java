package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String ERR_PREFIX = "[ERROR] ";
    private static final String ERR_MAIN_FORMAT = ERR_PREFIX + "당첨 번호는 쉼표(,)로 구분된 6개 숫자여야 합니다.";
    private static final String ERR_BONUS_RANGE = ERR_PREFIX + "보너스 번호는 1부터 45 사이여야 합니다.";
    private static final String ERR_BONUS_DUP = ERR_PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final List<Integer> main;
    private final int bonus;

    private WinningNumbers(List<Integer> main, int bonus) {
        this.main = main;
        this.bonus = bonus;
    }

    public static WinningNumbers of(String mainCsv, String bonusInput) {
        List<Integer> parsed = parseCsv(mainCsv);
        List<Integer> sorted = LottoTicketFactory.sortedUniqueSix(parsed);
        int bonus = parseBonus(bonusInput);

        if (sorted.contains(bonus)) {
            throw new IllegalArgumentException(ERR_BONUS_DUP);
        }

        return new WinningNumbers(sorted, bonus);
    }

    private static int parseBonus(String s) {
        try {
            int v = Integer.parseInt(s.trim());
            new LottoNumber(v);

            return v;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERR_BONUS_RANGE);
        }
    }

    private static List<Integer> parseCsv(String csv) {
        try {
            return Arrays.stream(csv.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ERR_MAIN_FORMAT);
        }
    }

    public List<Integer> main() {
        return List.copyOf(main);
    }

    public int bonus() {
        return bonus;
    }
}
