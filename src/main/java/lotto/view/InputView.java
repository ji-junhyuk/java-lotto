package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Player;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String POSSIBLE_CHARACTER = "[0-9]+";
    private static final String POSSIBLE_LOTTO_WINNING_NUMBERS = "[0-9,]+";
    private static final String ONE_THOUSAND_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 최소 천원 단위이어야 합니다.";
    private static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자이어야만 합니다.";

    public static int getPurchaseAmount() {
        String line;

        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        line = Console.readLine();
        return validateInputMoney(line);
    }

    public static int validateInputMoney(String line) {
        validateOnlyNumber(line);
        validateOneThousandUnit(line);
        return Integer.parseInt(line);
    }

    private static void validateOneThousandUnit(String line) {
        int purchaseAmount = Integer.parseInt(line);

        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException(ONE_THOUSAND_UNIT_ERROR_MESSAGE);
    }

    private static void validateOnlyNumber(String line) {
        if (!line.matches(POSSIBLE_CHARACTER))
            throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
    }

    public static void printBuyLottoCount(int buyLottoCount) {
        System.out.println(buyLottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public static void printBuyLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(InputView::PrintEachLottoNumbers);
    }

    private static void PrintEachLottoNumbers(Lotto lotto) {
        String combinedLottoNumbers = lotto.getNumbers()
                .stream()
                .map(lottoNumbers -> String.valueOf(lottoNumbers))
                .collect(Collectors.joining(", "));
        System.out.println("[" + combinedLottoNumbers + "]");
    }

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
