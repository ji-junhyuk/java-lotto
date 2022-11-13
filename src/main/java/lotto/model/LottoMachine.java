package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
//    private static final List<Integer> lottoNumbers;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;


    public static void selectLottoNumbersAllLotto(int buyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLottoCount; ++i)
            lottos.add(getLottoNumbers());
    }

    private static Lotto getLottoNumbers() {
        List<Integer> lottoNumbers;
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, 6);
        return new Lotto(lottoNumbers.stream().sorted().collect(toList()));
    }
}
