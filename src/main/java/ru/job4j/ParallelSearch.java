package ru.job4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSearch<T> extends RecursiveTask<T> {
    private final T[] array;
    private final T elementToSearch;
    private final int from;
    private final int to;
    private static int index = -1;

    public ParallelSearch(T[] array, T elementToSearch, int from, int to) {
        this.array = array;
        this.elementToSearch = elementToSearch;
        this.from = from;
        this.to = to;
    }


    @Override
    protected T compute() {
        if (to - from + 1  < 10) {
            for (int i = 0; i < 10; i++) {
                if (array[i] == elementToSearch) {
                     index = i;
                     return elementToSearch;
                }
            }
            return null;
        }
        int mid = (from + to) / 2;
        ParallelSearch<T> leftSearch = new ParallelSearch<>(array, elementToSearch, from, mid);
        ParallelSearch<T> rightSearch = new ParallelSearch<>(array, elementToSearch, mid + 1, to);
        leftSearch.fork();
        rightSearch.fork();
        T left = leftSearch.join();
        T right = rightSearch.join();
        return left != null ? left : right;
    }


    public static int search(Object[] array, Object elementToSearch) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new ParallelSearch<>(array, elementToSearch, 0, array.length - 1));
        return index;
    }

   public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 5, 8, 7, 47, 71, 70, 6, 9, 10, 4, 2, 13, 65};
        System.out.println(search(numbers, 10));
    }
}

