package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Player;
import lotto.view.PlayerInputView;

public class LottoController {

    public static void startGame() {
        Player player = new Player(PlayerInputView.getPurchaseAmount());
//        player.buylottos();
//        Presenter presenter = new Presenter(GetWinningnumbers());
 //       LottoMachine lottoMachine = new LottoMachine();
 //       lottoMachine.RankLottos();

    }
}
