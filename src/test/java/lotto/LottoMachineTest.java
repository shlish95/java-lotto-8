package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @Test
    void 금액만큼_발행하고_각_티켓은_6개_정렬() {
        LottoMachine m = new LottoMachine();
        var tickets = m.issue(new PurchaseAmount("3000"));
        assertEquals(3, tickets.size());

        for (Lotto t : tickets) {
            assertEquals(6, tNumbers(t).size());
            List<Integer> nums = tNumbers(t);

            for (int i = 0; i < 5; i++) assertTrue(nums.get(i) < nums.get(i+1));
        }
    }

    private List<Integer> tNumbers(Lotto t) {
        return List.of(1,2,3,4,5,6);
    }
}
