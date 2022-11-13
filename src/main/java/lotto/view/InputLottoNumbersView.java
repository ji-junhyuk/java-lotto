package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputLottoNumbersView {

    private static final String POSSIBLE_LOTTO_WINNING_NUMBERS = "[0-9,]+";
    private static final String POSSIBLE_BONUS_NUMBER = "[0-9]+";
    private static final String ASK_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 로또 당첨번호는 1~45사이의 숫자이어야 합니다.";
    private static final String DUPLICATE_AND_NOT_MATCH_SIZE_ERROR_MESSAGE = "[ERROR] 로또 당첨번호는 중복없는 숫자이어야 합니다.";
    private static final String ONLY_NUMBER_COMMA_ERROR_MESSAGE = "[ERROR] 로또 당첨번호는 숫자와 콤마로 이루어져야 합니다.";

    private static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 보너스번호는 숫자로 이루어져야 합니다.";
    private static final String ASK_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void GetWinningNumbers() {
        String line;

        System.out.println(ASK_LOTTO_WINNING_NUMBERS_MESSAGE);
        line = Console.readLine();
        validateOnlyNumberAndComma(line);
        List<Integer> lottoWinningNumbers = Arrays.stream(line.split(","))
                .map(element-> Integer.parseInt(element))
                .collect(Collectors.toList());
        validateLottoWinningNumbers(lottoWinningNumbers, false);
        GetBonusNumber(lottoWinningNumbers);
    }

    private static void GetBonusNumber(List<Integer> lottoWinningNumbers) {
        String line;

        System.out.println(ASK_LOTTO_BONUS_NUMBER_MESSAGE);
        line = Console.readLine();
        validateOnlyNumber(line);
        lottoWinningNumbers.add(Integer.parseInt(line));
        validateLottoWinningNumbers(lottoWinningNumbers, true);
    }

    public static void validateOnlyNumber(String line) {
        if (!line.matches(POSSIBLE_BONUS_NUMBER))
            throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
    }

    public static void validateLottoWinningNumbers(List<Integer> lottoWinningNumbers, boolean bonus_number) {
        int size = 6;

        if (bonus_number == true)
            size += 1;
        validateWinningNumberSize(lottoWinningNumbers, size);
        validateWinningNumberRange(lottoWinningNumbers, size);
    }

    private static void validateWinningNumberRange(List<Integer> lottoWinningNumbers, int size) {
        for (int idx = 0; idx < size; ++idx) {
            if (lottoWinningNumbers.get(idx) < 1 || lottoWinningNumbers.get(idx) > 45) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private static void validateWinningNumberSize(List<Integer> lottoWinningNumbers, int size) {
        Set<Integer> integerSet = new HashSet<>();
        for (int idx = 0; idx < lottoWinningNumbers.size(); ++idx) {
            integerSet.add(lottoWinningNumbers.get(idx));
        }
        if (integerSet.size() != size) {
            throw new IllegalArgumentException(DUPLICATE_AND_NOT_MATCH_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateOnlyNumberAndComma(String line) {
        if (!line.matches(POSSIBLE_LOTTO_WINNING_NUMBERS)) {
            throw new IllegalArgumentException(ONLY_NUMBER_COMMA_ERROR_MESSAGE);
        }
    }
}
