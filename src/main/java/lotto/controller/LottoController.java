package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Player;
import lotto.model.Presenter;
import lotto.view.InputLottoNumbersView;
import lotto.view.InputMoneyView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();
    public void startGame() {
        Player player = new Player(InputMoneyView.getPurchaseAmount());
        InputMoneyView.printBuyLottoCount(player.getBuyLottoCount());
        player.buyLotto(lottoMachine.selectLottoNumbersAllLotto(player.getBuyLottoCount()));
        InputMoneyView.printBuyLottoNumbers(player.getLottos());
        Presenter presenter = new Presenter(InputLottoNumbersView.GetWinningNumbers(), InputLottoNumbersView.GetBonusNumber());

        lottoMachine.compareWinningNumbers(player.getLottos(), presenter.getLottoWinningNumbers(), presenter.getBonusNumber());
        System.out.println(lottoMachine.getLottoResults());
      //  LottoResultView.printLottoResult();
    }
}
