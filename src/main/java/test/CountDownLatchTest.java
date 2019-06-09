package test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String... args) {
        CountDownLatch c = new CountDownLatch(5);
        c.countDown();
    }
}
