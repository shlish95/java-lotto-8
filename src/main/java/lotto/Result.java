package lotto;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> counts = new EnumMap<>(Rank.class);

    public Result() {
        for (Rank r : Rank.values()) {
            counts.put(r, 0);
        }
    }

    public void add(Rank r) {
        counts.put(r, counts.get(r) + 1);
    }

    public int count(Rank r) {
        return counts.get(r);
    }

    public long totalPrize() {
        long sum = 0;
        for (Rank r : Rank.values()) {
            sum += (long) counts.get(r) * r.prize();
        }

        return sum;
    }

    public Map<Rank, Integer> snapshot() {
        return new EnumMap<>(Rank.class);
    }
}
