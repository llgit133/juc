package org.example.n6.atom;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j(topic = "c.ABA_demo")
public class ABA_demo {

    public static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        log.debug("main start...");
        String preVal = ref.get();
        other();
        TimeUnit.SECONDS.sleep(1);
        log.debug("change A->C {}", ref.compareAndSet(preVal, "C"));
    }

    private static void other() throws InterruptedException {
        new Thread(() -> {
            log.debug("change A->B {}", ref.compareAndSet(ref.get(), "B"));
        }, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            log.debug("change B->A {}", ref.compareAndSet(ref.get(), "A"));
        }, "t2").start();
    }

}
