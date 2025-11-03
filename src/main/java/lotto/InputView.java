package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String raw = Console.readLine();

                return new PurchaseAmount(raw);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요");
                String main = Console.readLine();

                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonus = Console.readLine();

                return WinningNumbers.of(main, bonus);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
