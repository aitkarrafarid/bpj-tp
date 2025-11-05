package tp_virtualthread;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import socle.Chrono;
import socle.tp1.ThreadEstimation;
import socle.tp2.BenchmarkThread;

import java.util.concurrent.Executors;

public class BenchmarkThreadAllTest {

    // Vm arguments : -ea -Xmx512m
    private Chrono _Chrono;

    @Test
    @DisplayName("SimpleThreadEstimation")
    public void test1() {
        // Given
        int stackValue = 1024; // en Ko
        // When / Then
        ThreadEstimation.getInfosJVM("Thread classique", stackValue);
    }

    @Test
    @DisplayName("SimpleVirtualThreadEstimation")
    public void test2() {
        // Given
        int stackValue = 10; // en Ko
        // When / Then
        ThreadEstimation.getInfosJVM("Virtual thread classique", 10);
    }

    @Disabled
    @DisplayName("ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000})
    public void test3(Integer myTaskCount) throws Exception {
        // Given
        _Chrono = Chrono.newInstance("Thread", System.out, false);
        startChrono("Thread classique - pool - starting ParameterizedTest - myTaskCount " + myTaskCount);
        int poolThreads = 128;
        BenchmarkThread benchmarkThread = new BenchmarkThread();

        // When / Then
        // Avec une lambda
        benchmarkThread.lancerBenchmark( () -> Executors.newFixedThreadPool(poolThreads), myTaskCount);
        stopChrono("Thread classique - pool");

        System.out.println("---");

        _Chrono = Chrono.newInstance("Virtual Threads :", System.out, false);
        startChrono("Virtual Threads - starting ParameterizedTest - myTaskCount " + myTaskCount);
        BenchmarkThread benchmarkThread2 = new BenchmarkThread();
        // Sans lambda
//        Callable<ExecutorService> myExecutorCallable = new Callable<>() {
//            @Override
//            public ExecutorService call() {
//                return Executors.newVirtualThreadPerTaskExecutor();
//            }
//        };

//      benchmarkThread2.lancerBenchmark(myExecutorCallable, myTaskCount);
        benchmarkThread2.lancerBenchmark( () -> Executors.newVirtualThreadPerTaskExecutor(), myTaskCount);
        stopChrono("Virtual Threads");

        System.out.println("\n##############################################################################\n");
    }

    private void startChrono (String chronoName) {
        System.out.println("");
        System.out.println("DEBUT " + chronoName);
        _Chrono.start();
    }

    private void stopChrono (String chronoName) {
        _Chrono.stop();
        System.out.println("FIN " + chronoName);
    }

}