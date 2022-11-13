package lotto.model;

import lotto.view.PlayerInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개이어야 한다.(case: 7개)")
    void lottoNumberTest1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 6개이어야 한다.(case: 5개)")
    void lottoNumberTest2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1~45사이의 숫자이어야 한다.(case: 숫자 0)")
    void lottoNumberTest3() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 1~45사이의 숫자이어야 한다.(case: 숫자 46)")
    void lottoNumberTest4() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
