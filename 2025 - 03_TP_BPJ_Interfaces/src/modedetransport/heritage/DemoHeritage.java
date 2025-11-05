package modedetransport.heritage;// Fichier : DemoHeritage.java

abstract class TrajetType {
    String depart, arrivee;
    int distance;
    abstract int calculerCout();
}

class TrajetTrain extends TrajetType {
    int calculerCout() { return distance * 2; }
}

class TrajetAvion extends TrajetType {
    int calculerCout() { return distance * 10; }
}

public class DemoHeritage {
    public static void main(String[] args) {
        // Création d'un trajet en train
        TrajetTrain tTrain = new TrajetTrain();
        tTrain.depart = "Paris";
        tTrain.arrivee = "Lyon";
        tTrain.distance = 465;

        // Création d'un trajet en avion
        TrajetAvion tAvion = new TrajetAvion();
        tAvion.depart = "Paris";
        tAvion.arrivee = "Nice";
        tAvion.distance = 690;

        afficher(tTrain);
        afficher(tAvion);

        // ➕ Si on veut un nouveau mode (Voiture), on doit créer une nouvelle sous-classe :
        class TrajetVoiture extends TrajetType {
            int calculerCout() { return 50 + (int)Math.round(distance * 0.5); }
        }
        TrajetVoiture tVoiture = new TrajetVoiture();
        tVoiture.depart = "Nantes";
        tVoiture.arrivee = "Bordeaux";
        tVoiture.distance = 350;
        afficher(tVoiture);
    }

    private static void afficher(TrajetType t) {
        System.out.printf("%s → %s (%dkm) en %s : %d€%n",
                t.depart, t.arrivee, t.distance, t.getClass().getSimpleName(), t.calculerCout());
    }
}
