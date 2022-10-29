package domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {
    public static NumberGenerateStrategy DEFAULT = new RandomNumberGenerateStrategy();

    private RandomNumberGenerateStrategy() {
    }

    @Override
    public List<Integer> generate(List<Integer> integers, int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Collections.shuffle(integers);
            numbers.add(integers.get(0));
        }
        return numbers;
    }
}
