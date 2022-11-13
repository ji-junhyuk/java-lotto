package lotto.model;

import java.util.List;

public class Player {
    private final int money;
    private int buyLottoCount;
    private final String POSSIBLE_CHARACTERS = "[0-9]+";
    private List<Lotto> lottos;

    public void Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public Player(int money) {
        this.money = money;
    }

    public void buyLotto() {
        this.buyLottoCount= this.money / 1000;
    }

    public int getBuyLottoCount() {
        return buyLottoCount;
    }
}
