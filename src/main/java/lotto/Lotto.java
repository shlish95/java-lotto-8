package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    private static final String ERR_PREFIX = "[ERROR] ";
    private static final String ERR_SIZE = ERR_PREFIX + "로또 번호는 6개여야 합니다.";
    private static final String ERR_DUP = ERR_PREFIX + "로또 번호는 중복될 수 없습니다.";

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERR_SIZE);
        }

        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != 6) {
            throw new IllegalArgumentException(ERR_DUP);
        }
    }

    // TODO: 추가 기능 구현
}
