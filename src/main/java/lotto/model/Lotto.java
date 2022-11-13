package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ONE_TO_FOURTY_FIVE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1과 45사이의 숫자이어야 합니다.";
    private static final String NUMBERS_ARE_SIX_ERROR_MESSAGE = "[ERROR] 로또 번호 갯수는 6개이어야 합니다.";
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateOneToFoutyFive(numbers);
    }

    private void validateOneToFoutyFive(List<Integer> numbers) {
        for (int idx = 0; idx < 6; ++idx) {
            if (numbers.get(idx) < 1 || numbers.get(idx) > 45) {
                throw new IllegalArgumentException(ONE_TO_FOURTY_FIVE_ERROR_MESSAGE);
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_ARE_SIX_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
