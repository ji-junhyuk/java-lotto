package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5, true),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NONE(1);

    int correspondCount;
    boolean isBonus;

    Rank(int correspondCount, boolean isBonus) {
        this.correspondCount = correspondCount;
        this.isBonus = isBonus;
    }

    Rank(int correspondCount) {
        this(correspondCount, false);
    }

    public static Rank scoreRank(long correspondCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.correspondCount == correspondCount)
                .filter(rank -> rank.isBonus == bonus)
                .findAny()
                .orElse(NONE);
    }
}
