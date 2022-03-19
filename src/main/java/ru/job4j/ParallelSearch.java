package ru.job4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSearch<T> extends RecursiveTask<Integer> {
    private final T[] array;
    private final T elementToSearch;
    private final int from;
    private final int to;

    public ParallelSearch(T[] array, T elementToSearch, int from, int to) {
        this.array = array;
        this.elementToSearch = elementToSearch;
        this.from = from;
        this.to = to;
    }


    @Override
    protected Integer compute() {
        if (to - from + 1 < 10) {
            for (int i = from; i < to; i++) {
                if (array[i].equals(elementToSearch)) {
                    return i;
                }
            }
            return -1;
        }
        int mid = (from + to) / 2;
        ParallelSearch<T> leftSearch = new ParallelSearch<>(array, elementToSearch, from, mid);
        ParallelSearch<T> rightSearch = new ParallelSearch<>(array, elementToSearch, mid + 1, to);
        leftSearch.fork();
        rightSearch.fork();
        int left = leftSearch.join();
        int right = rightSearch.join();
        return left != -1 ? left : right;
    }


    public  int search(Object[] array, Object elementToSearch) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelSearch<>(array, elementToSearch, 0, array.length - 1));
    }

   public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1, 5, 8, 7, 47, 71, 70, 6, 9, 10, 4, 2, 13, 65};
       ParallelSearch<Integer> parallelSearch = new ParallelSearch<>(numbers, 6, 0, numbers.length);
        System.out.println(parallelSearch.search(numbers, 6));
    }
}

