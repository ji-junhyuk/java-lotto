package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLottoNumbersViewTest {

    @Test
    @DisplayName("로또 당첨번호는 숫자와 콤마이어야 한다.(case: ' ')")
    void InputWinningNumbersTest1() {
        String str = "1,2,3,4,5, 6";

        assertThatThrownBy(() -> InputLottoNumbersView.validateOnlyNumberAndComma(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨번호는 숫자와 콤마이어야 한다.(case: '@')")
    void InputWinningNumbersTest2() {
        String str = "1,2,3,4,5@6";

        assertThatThrownBy(() -> InputLottoNumbersView.validateOnlyNumberAndComma(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 보너스 번호는 숫자로만 이루어져야 한다.(case: @)")
    void InputWinningNumbersTest3() {
        assertThatThrownBy(() -> InputLottoNumbersView.validateOnlyNumber("1@"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨번호는 중복 없이 6개의 숫자이어야 한다.(case: 7개)")
    void InputWinningNumbersTest4() {
        assertThatThrownBy(() -> InputLottoNumbersView.validateLottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), false))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 당첨번호(보너스포함)는 중복 없이 7개의 숫자이어야 한다.(case: 중복숫자)")
    void InputWinningNumbersTest5() {
        assertThatThrownBy(() -> InputLottoNumbersView.validateLottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 6), true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨번호(보너스포함)는 중복 없이 7개의 숫자이어야 한다.(case: 8개)")
    void InputWinningNumbersTest6() {
        assertThatThrownBy(() -> InputLottoNumbersView.validateLottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8), true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
