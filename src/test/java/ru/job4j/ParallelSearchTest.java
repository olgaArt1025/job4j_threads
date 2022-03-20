package ru.job4j;

import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParallelSearchTest {

    @Test
    public void whenIndexIs6() {
        Integer[] numbers = new Integer[]{1, 5, 8, 7, 47, 71, 70, 6, 9, 10, 4, 2, 13, 65};
        assertThat(ParallelSearch.search(numbers, 10), is(9));
    }

    @Test
    public void whenIndexIs4() {
        String[] words = new String[] {"a", "b", "c", "d", "e"};
        assertThat(ParallelSearch.search(words, "c"), is(2));
    }

    @Test
    public void whenIndexIsNotFound() {
        String[] words = new String[] {"a", "b", "c", "d", "e"};
        assertThat(ParallelSearch.search(words, "w"), is(-1));
    }

    @Test
    public void whenIndexIsTheLastElementOfTheArray() {
        String[] words = new String[] {"a", "b", "c", "d", "e"};
        assertThat(ParallelSearch.search(words, "e"), is(4));
    }
}
