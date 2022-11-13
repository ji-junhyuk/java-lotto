package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Player;
import lotto.view.InputView;

public class LottoController {

    public static void startGame() {
        Player player = new Player(InputView.getPurchaseAmount());
        InputView.printBuyLottoCount(player.getBuyLottoCount());
        player.buyLotto(LottoMachine.selectLottoNumbersAllLotto(player.getBuyLottoCount()));
        InputView.printBuyLottoNumbers(player.getLottos());

 //       Presenter presenter = new Presenter(GetWinningnumbers());
 //       LottoMachine lottoMachine = new LottoMachine();
 //       lottoMachine.RankLottos();

    }
}
