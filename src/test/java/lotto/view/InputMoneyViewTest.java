package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputMoneyViewTest {

    @Test
    @DisplayName("구입금액이 1000원 단위이어야 한다.")
    void InputMoneyTest1() {
        String money = "0";

        assertThatThrownBy(() -> InputMoneyView.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("구입금액 모두 숫자이어야 한다.")
    void InputMoneyTest2() {
        String money = "10 00";

        assertThatThrownBy(() -> InputMoneyView.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
