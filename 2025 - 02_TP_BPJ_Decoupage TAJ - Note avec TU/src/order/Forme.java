package order;

import java.util.Objects;

class Order{

    private String nom;

    Order(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Order{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

interface OrderProcessor { void process(Order order); }

class BaseOrderProcessor implements OrderProcessor {
    @Override public void process(Order order) {
        System.out.println(">> Base: enregistrement de la commande : " + order.toString());
    }
}

class PrePostProcessingDecorator implements OrderProcessor {
    private final OrderProcessor delegate;
    public PrePostProcessingDecorator(OrderProcessor delegate) {
        this.delegate = Objects.requireNonNull(delegate);
    }
    @Override public void process(Order order) {
        beforeProcessing();
        delegate.process(order);     // <-- exécute le vrai traitement
        afterProcessing();
    }
    private void beforeProcessing() { System.out.println("Pré-traitement"); }
    private void afterProcessing()  { System.out.println("Post-traitement"); }
}

class Main {
    public static void main(String[] args) {
        // Utilisation
        OrderProcessor p = new PrePostProcessingDecorator(new BaseOrderProcessor());
        p.process(new Order("courroie"));
    }
}