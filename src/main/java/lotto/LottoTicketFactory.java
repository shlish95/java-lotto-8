package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketFactory {
    private static final String ERR_PREFIX = "[ERROR] ";
    private static final String ERR_SIZE = ERR_PREFIX + "로또 번호는 6개여야 합니다.";
    private static final String ERR_DUP = ERR_PREFIX + "로또 번호는 중복될 수 없습니다.";

    private LottoTicketFactory() {}

    public static List<Integer> sortedUniqueSix(List<Integer> src) {
        if (src == null || src.size() != 6) {
            throw new IllegalArgumentException(ERR_SIZE);
        }
        if (new HashSet<>(src).size() != 6) {
            throw new IllegalArgumentException(ERR_DUP);
        }

        for (int n : src) {
            new LottoNumber(n);
        }

        List<Integer> copy = new ArrayList<>(src);
        Collections.sort(copy);
        return copy;
    }
}
