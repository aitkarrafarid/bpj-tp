package open_close_principe;

import java.util.List;

interface Forme {
    double aire();
}

class Cercle implements Forme {
    double rayon;
    Cercle(double rayon) { this.rayon = rayon; }

    public double aire() {
        return Math.PI * rayon * rayon;
    }
}

class Rectangle implements Forme {
    double largeur, hauteur;
    Rectangle(double largeur, double hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public double aire() {
        return largeur * hauteur;
    }
}

class Triangle implements Forme {
    double base, hauteur;
    Triangle(double base, double hauteur) {
        this.base = base;
        this.hauteur = hauteur;
    }

    public double aire() {
        return (base * hauteur) / 2.0;
    }
}


class CalculateurAire {
    double aireTotale(List<Forme> formes) {
        return formes.stream()
                     .mapToDouble(Forme::aire)
                     .sum();
    }
}

class main {
    public static void main(String[] args) {
        Forme cercle1 = new Cercle(5);
        Forme rectnagle1 = new Rectangle(3, 4);
        Forme triangle1 = new Triangle(3, 4);
        System.out.println("Aire de Cercle : " + cercle1.aire());
        System.out.println("Aire de Rectangle : " + rectnagle1.aire());
        System.out.println("Aire de Triangle : " + triangle1.aire());
        var formes = List.of(cercle1, rectnagle1, triangle1);
        double total = new CalculateurAire().aireTotale(formes);
        System.out.println("Aire totale : " + total);

    }
}
