package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Player;
import lotto.view.InputLottoNumbersView;
import lotto.view.InputMoneyView;

public class LottoController {

    public static void startGame() {
        Player player = new Player(InputMoneyView.getPurchaseAmount());
        InputMoneyView.printBuyLottoCount(player.getBuyLottoCount());
        player.buyLotto(LottoMachine.selectLottoNumbersAllLotto(player.getBuyLottoCount()));
        InputMoneyView.printBuyLottoNumbers(player.getLottos());
        InputLottoNumbersView.GetWinningNumbers();

 //       Presenter presenter = new Presenter(GetWinningnumbers());
 //       LottoMachine lottoMachine = new LottoMachine();
 //       lottoMachine.RankLottos();

    }
}
