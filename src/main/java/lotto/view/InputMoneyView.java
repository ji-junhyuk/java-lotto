package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class InputMoneyView {
    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String POSSIBLE_CHARACTER = "[0-9]+";
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
        lottos.forEach(InputMoneyView::PrintEachLottoNumbers);
    }

    private static void PrintEachLottoNumbers(Lotto lotto) {
        String combinedLottoNumbers = lotto.getNumbers()
                .stream()
                .map(lottoNumbers -> String.valueOf(lottoNumbers))
                .collect(Collectors.joining(", "));
        System.out.println("[" + combinedLottoNumbers + "]");
    }
}
