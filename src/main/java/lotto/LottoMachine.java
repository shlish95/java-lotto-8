package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> issue(PurchaseAmount amount) {
        int count = amount.countTickets();
        List<Lotto> tickets = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            tickets.add(new Lotto(numbers));
        }

        return tickets;
    }
}
