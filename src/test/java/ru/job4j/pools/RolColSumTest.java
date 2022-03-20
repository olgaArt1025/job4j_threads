package ru.job4j.pools;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static ru.job4j.pools.RolColSum.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RolColSumTest {

    @Test
    public void whenAsyncSum() throws ExecutionException, InterruptedException {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Sums[] expected = {new Sums(6, 12), new Sums(15, 15),
                new Sums(24, 18)};
        assertThat(RolColSum.asyncSum(array), is(expected));
    }

    @Test
    public void whenSum() {
        int[][] array = {{1, 5, 3}, {4, 12, 6}, {85, 8, 54}};
        Sums[] expected = {new Sums(9, 90), new Sums(22, 25),
                new Sums(147, 63)};
        assertThat(RolColSum.sum(array), is(expected));
    }
}