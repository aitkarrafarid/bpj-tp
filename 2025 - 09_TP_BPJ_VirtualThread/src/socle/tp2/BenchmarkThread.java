package socle.tp2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class BenchmarkThread {

    public static void lancerBenchmark(Callable<ExecutorService> fournisseur, int nbTaches) throws Exception {
        System.gc(); // Nettoyage mémoire
        Thread.sleep(100);
        long memAvant = memUtilisee();
        try (ExecutorService executor = fournisseur.call()) {
            for (int i = 0; i < nbTaches; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(100); // Simule une tâche
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        long memApres = memUtilisee();
        System.out.println("Mémoire utilisée : " + (memApres - memAvant) + " Mo");
    }
    static long memUtilisee() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / (1024 * 1024);
    }
}
