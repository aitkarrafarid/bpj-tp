package tp_virtualthread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import socle.Chrono;
import socle.tp1.ThreadEstimation;
import socle.tp2.BenchmarkThread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BenchmarkThreadTest {

// Vm arguments : -ea -Xmx512m
   private Chrono _Chrono;

   @Test
   @DisplayName("SimpleThreadEstimation")
   public void test1() {
      ThreadEstimation.getInfosJVM("Thread classique", 1024);
   }

   @Test
   @DisplayName("SimpleVirtualThreadEstimation")
   public void test2() {
      ThreadEstimation.getInfosJVM("Virtual thread classique", 10);
   }

   @DisplayName("ParameterizedTest")
   @ParameterizedTest
   @ValueSource(ints = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000})
   public void test3(Integer myTaskCount) throws Exception {
      _Chrono = Chrono.newInstance("tp_virtualThread", System.out, false);
      startChrono("Thread classique - pool - starting ParameterizedTest - myTaskCount " + myTaskCount);
      int taskCount = myTaskCount;
      int poolThreads = 128;
      BenchmarkThread benchmarkThread = new BenchmarkThread();
      // Avec une lambda
      benchmarkThread.lancerBenchmark( () -> Executors.newFixedThreadPool(poolThreads), taskCount);
      stopChrono("Thread classique - pool");

      System.out.println("---");
      
      _Chrono = Chrono.newInstance("Virtual Threads :", System.out, false);
      startChrono("Virtual Threads - starting ParameterizedTest - myTaskCount " + myTaskCount);
      // Sans lambda

      Callable<ExecutorService> myExecutorCallable = new Callable<>() {
         @Override
         public ExecutorService call() {
            return Executors.newVirtualThreadPerTaskExecutor();
         }
      };
      BenchmarkThread benchmarkThread2 = new BenchmarkThread();
      benchmarkThread2.lancerBenchmark(myExecutorCallable, taskCount);
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