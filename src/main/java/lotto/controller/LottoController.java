package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoMachine;
import lotto.model.Player;
import lotto.view.PlayerInputView;

public class LottoController {

    public static void startGame() {
        Player player = new Player(PlayerInputView.getPurchaseAmount());
        PlayerInputView.printBuyLottoCount(player.getBuyLottoCount());
        player.buyLotto(LottoMachine.selectLottoNumbersAllLotto(player.getBuyLottoCount()));

 //       Presenter presenter = new Presenter(GetWinningnumbers());
 //       LottoMachine lottoMachine = new LottoMachine();
 //       lottoMachine.RankLottos();

    }
}
