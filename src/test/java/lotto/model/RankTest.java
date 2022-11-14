package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class RankTest {
    @DisplayName("당첨 테스트")
    @ParameterizedTest(name = "{index} rank = {0}")
    @MethodSource("testEnum1")
    void WinningTest(Rank rank) {
        Assertions.assertThat(rank).isNotEqualTo(Rank.NONE);
    }

    static Stream<Arguments> testEnum1() {
        return Stream.of(
                Arguments.of(Rank.scoreRank(5, true)),
                Arguments.of(Rank.scoreRank(5, false)),
                Arguments.of(Rank.scoreRank(4, false)),
                Arguments.of(Rank.scoreRank(3, false))
        );
    }

    @DisplayName("꽝 테스트")
    @ParameterizedTest(name = "{index} rank = {0}")
    @MethodSource("testEnum2")
    void LosingTest(Rank rank) {
        Assertions.assertThat(rank).isEqualTo(Rank.NONE);
    }
    static Stream<Arguments> testEnum2() {
        return Stream.of(
                Arguments.of(Rank.scoreRank(2, false)),
                Arguments.of(Rank.scoreRank(1, false)),
                Arguments.of(Rank.scoreRank(0, false))
        );
    }
}