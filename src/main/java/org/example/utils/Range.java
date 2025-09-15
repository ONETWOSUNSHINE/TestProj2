package org.example.utils;

import java.util.Random;

public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        if (min <= 0 || max <= 0) {
            throw new IllegalArgumentException("Damage range must be positive");
        }
        if (min > max) {
            throw new IllegalArgumentException("Min damage cannot be greater than max damage");
        }
        this.min = min;
        this.max = max;
    }

    public int getRandom(Random rng) {
        return rng.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        return min + "-" + max;
    }
}
