package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerInputViewTest {

    @Test
    @DisplayName("구입금액이 1000원 단위이어야 한다.")
    void createInputMoneyTest1() {
        String money = "0";

        assertThatThrownBy(() -> InputView.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("구입금액 모두 숫자이어야 한다.")
    void createInputMoneyTest2() {
        String money = "10 00";

        assertThatThrownBy(() -> InputView.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
