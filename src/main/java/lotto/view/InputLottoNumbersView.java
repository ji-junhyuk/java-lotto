package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputLottoNumbersView {

    private static final String POSSIBLE_LOTTO_WINNING_NUMBERS = "[0-9,]+";
    private static final String ASK_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static void GetWinningNumbers() {
        String line;

        System.out.println(ASK_LOTTO_WINNING_NUMBERS_MESSAGE);
        line = Console.readLine();
        validateOnlyNumberAndComma(line);
        List<Integer> lottoWinningNumbers = Arrays.stream(line.split(","))
                .map(element-> Integer.parseInt(element))
                .collect(Collectors.toList());
        validateLottoWinningNumbers(lottoWinningNumbers);
    }

    private static void validateLottoWinningNumbers(List<Integer> lottoWinningNumbers) {
        validateWinningNumberSize(lottoWinningNumbers);
        validateWinningNumberRange(lottoWinningNumbers);
    }

    private static void validateWinningNumberRange(List<Integer> lottoWinningNumbers) {
        for (int idx = 0; idx < 6; ++idx) {
            if (lottoWinningNumbers.get(idx) < 1 || lottoWinningNumbers.get(idx) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨번호는 1~45사이의 숫자이어야 합니다.");
            }
        }
    }

    private static void validateWinningNumberSize(List<Integer> lottoWinningNumbers) {
        Set<Integer> integerSet = new HashSet<>();
        for (int idx = 0; idx < lottoWinningNumbers.size(); ++idx) {
            integerSet.add(lottoWinningNumbers.get(idx));
        }
        if (integerSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨번호는 중복없이 6개의 숫자이어야 합니다.");
        }
    }

    private static void validateOnlyNumberAndComma(String line) {
        if (!line.matches(POSSIBLE_LOTTO_WINNING_NUMBERS)) {
            throw new IllegalArgumentException("[ERROR] 숫자와 콤마 외의 문자가 올 수 없습니다.");
        }
    }
}
