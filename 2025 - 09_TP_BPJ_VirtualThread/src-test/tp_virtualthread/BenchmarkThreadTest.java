package tp_virtualthread;

import org.junit.*;

import socle.Chrono;
import socle.tp1.ThreadEstimation;

public class BenchmarkThreadTest {

    // Vm arguments : -ea -Xmx512m
    private Chrono _Chrono;

    @Test
    //@DisplayName("SimpleThreadEstimation")
    public void SimpleThreadEstimation() {
        // Given
        int stackValue = 1024; // en Ko
        // When
        long estimatedMaxThreads = ThreadEstimation.getInfosJVM("Thread classique", stackValue);
        // Then
        Assert.assertEquals(estimatedMaxThreads, 512);
    }

    @Test
    //@DisplayName("SimpleVirtualThreadEstimation")
    public void SimpleVirtualThreadEstimation() {
        // Given
        int stackValue = 10; // en Ko
        // When
        long estimatedMaxThreads = ThreadEstimation.getInfosJVM("Virtual thread", 10);
        // Then
        Assert.assertEquals(estimatedMaxThreads, 52428);
    }


}