package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000L, "3개 일치 (5,000원)"),
    NONE(0, false, 0L, "");

    private final int match;
    private final boolean bonusRequired;
    private final long prize;
    private final String label;

    Rank(int match, boolean bonusRequired, long prize, String label) {
        this.match = match;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.label = label;
    }

    public long prize() {
        return prize;
    }

    public String label() {
        return label;
    }

    public static Rank of(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatched) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;

        return NONE;
    }
}
