package lotto.domain;

import java.util.List;

import static lotto.domain.WinningRule.checkWinning;
import static lotto.utils.Constant.ONE_LOTTO_AMOUNT;

public class WinningHistory {
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private int fifthCount;
    private int winningAmount;
    private final double yield;

    public WinningHistory(List<LottoTicketResult> results) {
        analysis(results);
        double yield = (double) winningAmount / (ONE_LOTTO_AMOUNT * results.size()) * 100;
        this.yield = (double) Math.round(yield * 10) / 10;
    }

    private void analysis(List<LottoTicketResult> results) {
        for (LottoTicketResult result : results) {
            WinningRule winningRule = checkWinning(result);
            countWinning(winningRule);
            winningAmount += winningRule.winningAmount();
        }
    }

    private void countWinning(WinningRule winningRule) {
        if (winningRule == WinningRule.FIRST)
            firstCount++;
        if (winningRule == WinningRule.SECOND)
            secondCount++;
        if (winningRule == WinningRule.THIRD)
            thirdCount++;
        if (winningRule == WinningRule.FOURTH)
            fourthCount++;
        if (winningRule == WinningRule.FIFTH)
            fifthCount++;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public double getYield() {
        return yield;
    }
}
