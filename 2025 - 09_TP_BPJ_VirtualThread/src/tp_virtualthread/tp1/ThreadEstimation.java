package tp_virtualthread.tp1;

public class ThreadEstimation {

    public static void getInfosJVM(String threadType, long stackValue){
        Runtime runtime = Runtime.getRuntime();
        long heapUsed = runtime.totalMemory() - runtime.freeMemory();
        long heapMax = runtime.maxMemory();

        System.out.println("== "+ threadType + " / Mémoire JVM (-Xmx) ==");
        System.out.println("Tas/Heap max         : " + (heapMax / (1024 * 1024)) + " Mo");
        System.out.println("Tas/Heap totale      : " + (runtime.totalMemory() / (1024.0 * 1024.0 )) + " Mo");
        System.out.println("Tas/Heap disponible  : " + (runtime.freeMemory() / (1024.0 * 1024.0 )) + " Mo");
        System.out.println("Tas/Heap utilisé     : " + (heapUsed / (1024 * 1024)) + " Mo");
     
        System.out.println("---------------------------");
        System.out.println("Pile/Stack (-Xss)           : " + (stackValue) + " ko");

        long estimatedMaxThreads = (heapMax / (1024)) / stackValue;

        System.out.println("---------------------------");
        System.out.println("Estimation du nombre de threads disponibles : " + estimatedMaxThreads);
        System.out.println("\n##############################################################################\n");

    }
}
