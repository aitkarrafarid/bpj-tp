package tp_virtualthread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import tp_virtualthread.tp1.ThreadEstimation;
import tp_virtualthread.tp2.BenchmarkThread;

import java.text.MessageFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BenchmarkThreadTest {

// Vm arguments : -ea -Xmx512m
   private final long heapValue = 512; // mo
   
   
   @Test
   @DisplayName("SimpleThreadEstimation")
   public void test1() {
      ThreadEstimation.getInfosJVM("Thread classique", (1024*1024));
   }

   @Test
   @DisplayName("SimpleVirtualThreadEstimation")
   public void test2() {
      ThreadEstimation.getInfosJVM("Virtual thread classique", 1024);
   }

 @DisplayName("ParameterizedTest")
 @ParameterizedTest
 @ValueSource(ints = {100, 500, 1000, 5000, 10000, 50000, 100000})
 public void test3(Integer myTaskCount) throws Exception {
    System.out.println(MessageFormat.format("Starting ParameterizedTest - myTaskCount {0}", myTaskCount));
    int taskCount = myTaskCount;
    int poolThreads = 512;
    System.out.println("Thread classique - pool :");
    // Avec une lambda
    BenchmarkThread.lancerBenchmark(() -> Executors.newFixedThreadPool(poolThreads), taskCount);
    System.out.println("---");
    System.out.println("Virtual Threads :");
    // Sans lambda
    Callable<ExecutorService> myExecutorCallable = new Callable<>() {
       @Override
       public ExecutorService call() {
          return Executors.newVirtualThreadPerTaskExecutor();
       }
    };
    BenchmarkThread.lancerBenchmark(myExecutorCallable, taskCount);
    // BenchmarkThread.lancerBenchmark(() -> Executors.newVirtualThreadPerTaskExecutor(), taskCount);
    System.out.println("\n##############################################################################\n");
 }
  
}