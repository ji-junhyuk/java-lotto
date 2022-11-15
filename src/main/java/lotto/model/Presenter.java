package lotto.model;

import java.util.List;

public class Presenter {

    private List<Integer> lottoWinningNumbers;
    private Integer bonusNumber;


    public Presenter(List<Integer> lottoWinningNumbers, Integer bonusNumber) {
        validate(lottoWinningNumbers, bonusNumber);
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> lottoWinningNumbers, Integer bonusNumber) {
        if (lottoWinningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[Error]: 당첨 번호에 속한 보너스 번호를 선택할 수 없습니다.");
        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[Error]: 보너스 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
