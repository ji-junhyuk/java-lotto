package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Player;

public class PlayerInputView {
    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String POSSIBLE_CHARACTER = "[0-9]+";
    private static String line;

    public static int getPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        line = Console.readLine();
        return validate(line);
    }

    private static int validate(String line) {
        validateOnlyNumber(line);
        validateOneThousandUnit(line);
        return Integer.parseInt(line);
    }

    private static void validateOneThousandUnit(String line) {
        int purchaseAmount = Integer.parseInt(line);

        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 천원 단위이어야 합니다.");
    }

    private static void validateOnlyNumber(String line) {
        if (!line.matches(POSSIBLE_CHARACTER))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야만 합니다.");
    }
}
