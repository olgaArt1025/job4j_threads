package ru.job4j.cache;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CacheTest {

    @Test
    public void whenAdd3Then2() {
        Cache cache = new Cache();
        Base base1 = new Base(1, 0);
        Base base2 = new Base(2, 0);
        Base base3 = new Base(1, 5);
        cache.add(base1);
        cache.add(base2);
        cache.add(base3);
        assertThat(cache.size(), is(2));
    }

    @Test
    public void whenUpdateThenTrue() {
        Cache cache = new Cache();
        Base base = new Base(1, 0);
        base.setName("Name1");
        cache.add(base);
        Base base2 = new Base(1, 0);
        base2.setName("Name2");
        cache.update(base2);
        System.out.println(cache);
        assertThat(cache.getMemory().get(1).getVersion(), is(1));
        assertThat(cache.getMemory().get(1).getName(), is("Name2"));
    }

    @Test
    public void whenDelete() {
        Cache cache = new Cache();
        Base base1 = new Base(1, 0);
        Base base2 = new Base(2, 3);
        Base base3 = new Base(3, 2);
        cache.add(base1);
        cache.add(base2);
        cache.add(base3);
        cache.delete(base2);
        assertThat(cache.size(), is(2));
    }
}