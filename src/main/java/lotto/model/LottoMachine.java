package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private final HashMap<Rank, Integer> lottoResults = new HashMap<>();

    public HashMap<Rank, Integer> getLottoResults() {
        return lottoResults;
    }

    public List<Lotto> selectLottoNumbersAllLotto(int buyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyLottoCount; ++i)
            lottos.add(getLottoNumbers());
        return lottos;
    }

    private Lotto getLottoNumbers() {
        List<Integer> lottoNumbers;
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, 6);
        return new Lotto(lottoNumbers.stream().sorted().collect(toList()));
    }

    public void compareWinningNumbers(List<Lotto> lottos, List<Integer> lottoWinningNumbers, Integer bonusNumber) {
        int count = 0;
        initRank();
        for (Lotto lotto : lottos) {
            count = getRank(lottoWinningNumbers, lotto);
            Rank rank = Rank.scoreRank(count, lotto.getNumbers().contains(bonusNumber));
            lottoResults.put(rank, lottoResults.getOrDefault(rank, 0) + 1);
        }
    }

    private void initRank() {
        for (Rank rank : Rank.values())
            lottoResults.put(rank, 0);
    }

    private static int getRank(List<Integer> lottoWinningNumbers, Lotto lotto) {
        int count = 0;
        for (int idx = 0; idx < lotto.getNumbers().size(); ++idx) {
            if (lottoWinningNumbers.contains(lotto.getNumbers().get(idx))) {
                ++count;
            }
        }
        return count;
    }
}
