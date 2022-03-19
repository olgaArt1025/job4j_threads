package ru.job4j;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParallelSearchTest {

    @Test
    public void whenIndexIs6() {
        Integer[] numbers = new Integer[]{1, 5, 8, 7, 47, 71, 70, 6, 9, 10, 4, 2, 13, 65};
        ParallelSearch<Integer> parallelSearch = new ParallelSearch<>(numbers, 6, 0, numbers.length);
        assertThat(parallelSearch.search(numbers, 10), is(9));
    }

    @Test
    public void whenIndexIs4() {
        String[] words = new String[] {"a", "b", "c", "d", "e"};
        ParallelSearch<String> parallelSearch = new ParallelSearch<>(words, "c", 0, words.length);
        assertThat(parallelSearch.search(words, "c"), is(2));
    }
}
