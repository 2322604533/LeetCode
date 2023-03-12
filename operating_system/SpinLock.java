package Zeus.operating_system;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {

    private final AtomicReference<Thread> owner;

    private final AtomicInteger count;

    public SpinLock(AtomicReference<Thread> owner, AtomicInteger count) {
        this.owner = new AtomicReference<>();
        this.count = new AtomicInteger(0);
    }

    public void lock() {
        Thread thread = Thread.currentThread();

        if (thread == owner.get()) {
            count.incrementAndGet();
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        if (thread == owner.get()) {
            if (count.get() > 0) {
                count.decrementAndGet();
            } else {
                owner.set(null);
            }
        }
    }
}
