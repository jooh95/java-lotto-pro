package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.service.LottoAutoIssuedServiceImpl;
import lotto.service.LottoIssuedService;
import lotto.utils.ListUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashSet;
import java.util.List;

public class LottoController {
    private final static String LOTTO_NUMBER_TEXT_SPLIT_VALUE = ", ";

    public void play() {
        InputView.printInputPurchasePrice();
        String purchasePriceText = InputView.inputPurchasePrice();
        int purchaseCount = purchaseLotto(purchasePriceText);

        Lottos lottos = issueLottos(new LottoAutoIssuedServiceImpl(), purchaseCount);
        Lotto lastWeekLotto = lastWeekLotto();

        lottoResult(lottos, lastWeekLotto);
    }

    private int purchaseLotto(String purchasePriceText) {
        LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
        int purchaseCount = lottoPurchase.purchaseCount();
        ResultView.printPurchaseLottoCount(purchaseCount);

        return purchaseCount;
    }

    private Lottos issueLottos(LottoIssuedService lottoIssuedService, int purchaseCount) {
        Lottos lottos = new Lottos(lottoIssuedService, purchaseCount);
        ResultView.printIssuedLottoNumber(lottos);

        return lottos;
    }

    private Lotto lastWeekLotto() {
        InputView.printInputLastWeekWinningNumber();
        String lastWeekLottoNumberText = InputView.inputLastWeekWinningNumber();
        List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lastWeekLottoNumberText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);

        return new Lotto(new HashSet<>(lastWeekLottoNumbers));
    }

    private LottoResult lottoResult(Lottos lottos, Lotto lastWeekLotto) {
        LottoResult lottoResult = new LottoResult(lottos.lottoWinningResult(lastWeekLotto));
        ResultView.printLottoResult(lottoResult);

        return lottoResult;
    }
}
