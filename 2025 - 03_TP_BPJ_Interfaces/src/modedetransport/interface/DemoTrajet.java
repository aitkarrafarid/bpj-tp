package modedetransport;// Fichier : DemoTrajet.java
// Démo "casser l'héritage" : Trajet + IModeDeTransport (composition)

interface IModeDeTransport {
    int calculerCout(int distance);
    String nom();
}

class ModeTrain implements IModeDeTransport {
    public int calculerCout(int distance) { return distance * 2; }
    public String nom() { return "Train"; }
}

class ModeAvion implements IModeDeTransport {
    public int calculerCout(int distance) { return distance * 10; }
    public String nom() { return "Avion"; }
}

class ModeCovoiturage implements IModeDeTransport {
    public int calculerCout(int distance) { return 50 + (int)Math.round(distance * 1.2); }
    public String nom() { return "CovoiturageEco"; }
}

class ModeFake implements IModeDeTransport {
    public int calculerCout(int distance) { return 42; }
    public String nom() { return "Fake"; }
}

class Trajet {
    private final String depart;
    private final String arrivee;
    private final int distance;
    private IModeDeTransport mode;   // dépendance injectée

    public Trajet(String depart, String arrivee, int distance, IModeDeTransport mode) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.distance = distance;
        this.mode = mode;
    }

    public int cout() {
        return mode.calculerCout(distance);
    }

    public void changerMode(IModeDeTransport nouveauMode) {
        this.mode = nouveauMode;
    }

    @Override public String toString() {
        return String.format("%s → %s (%dkm) en %s : %d€",
                depart, arrivee, distance, mode.nom(), cout());
    }
}

public class DemoTrajet {
    public static void main(String[] args) {
        // Injection via constructeur
        Trajet t1 = new Trajet("Paris", "Lyon", 465, new ModeTrain());
        System.out.println(t1); // Train

        // On change dynamiquement le mode (sans toucher à Trajet)
        t1.changerMode(new ModeAvion());
        System.out.println(t1); // Avion

        // Ajout d'un nouveau mode sans modifier Trajet : juste une nouvelle implémentation
//        IModeDeTransport modeEco = new IModeDeTransport() { // ex. classe anonyme
//            public int calculerCout(int distance) { return 50 + (int)Math.round(distance * 1.2); }
//            public String nom() { return "CovoiturageEco"; }
//        };

        Trajet t2 = new Trajet("Nantes", "Bordeaux", 350, new ModeCovoiturage());
        System.out.println(t2);

        // "Test" rapide sans framework (java -ea pour activer les assert)
        assert new ModeTrain().calculerCout(100) == 200 : "Train doit coûter 200 pour 100km";
        assert new ModeAvion().calculerCout(100) == 1000 : "Avion doit coûter 1000 pour 100km";

        // Mock simple pour tests : on force un coût connu
//        IModeDeTransport fake = new IModeDeTransport() {
//            public int calculerCout(int distance) { return 42; }
//            public String nom() { return "Fake"; }
//        };

        Trajet tTest = new Trajet("A", "B", 9999, new ModeFake());
        assert tTest.cout() == 42 : "Le coût doit venir du mode (mocké), pas de Trajet";
    }
}
