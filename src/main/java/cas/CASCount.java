package cas;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        int newCount;
        int current;
        do {
            current = get();
            newCount = current + 1;
        } while (!count.compareAndSet(current, newCount));
    }

    public int get() {
        return count.get();
    }
}
