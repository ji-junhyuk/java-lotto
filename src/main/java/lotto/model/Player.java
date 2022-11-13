package lotto.model;

import java.util.List;

public class Player {
    private final int money;
    private int buyLottoCount;
    private List<Lotto> lottos;

    public Player(int money) {
        this.money = money;
        this.buyLottoCount = this.money / 1000;
    }

    public void buyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getBuyLottoCount() {
        return buyLottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
