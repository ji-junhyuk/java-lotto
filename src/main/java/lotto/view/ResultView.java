package lotto.view;

import lotto.model.Rank;

import java.util.HashMap;

public class ResultView {

    public static void printLottoResult(HashMap<Rank, Integer> lottoResults) {


        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개일치 (5000원) - " + lottoResults.get(Rank.FIFTH));
        System.out.println("4개일치 (50,000원) - " + lottoResults.get(Rank.FIFTH));
        System.out.println("5개일치 (1,500,000원) - " + lottoResults.get(Rank.FIFTH));
        System.out.println("5개일치, 보너스 볼 일치 (30,000,000) - " + lottoResults.get(Rank.FIFTH));
        System.out.println("3개일치 (2,000,000,000원) - - " + lottoResults.get(Rank.FIFTH));
    }
}
