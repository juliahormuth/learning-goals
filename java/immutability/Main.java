import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MutableOrder mutableOrder = new MutableOrder("Confirmado");

        System.out.println("Objeto mutável:" + mutableOrder.getStatus());

        mutableOrder.setStatus("Cancelado");

        System.out.println("Objeto mutável:" + mutableOrder.getStatus());

        ImmutableOrder immutableOrder = new ImmutableOrder("Confirmado");

        System.out.println("Objeto imutável:" + immutableOrder.getStatus());

        new Thread(() -> {
            System.out.println("Objeto mutável em uma nova Thread:" + mutableOrder.getStatus()); // Ainda cancelado, mas
                                                                                                 // pode sofrer
                                                                                                 // alteracoes
            System.out.println("Objeto imutável em nova Thread:" + immutableOrder.getStatus());
        }).start();

        // List
        List<String> immutableList = Collections.unmodifiableList(new ArrayList<String>());

        System.out.println("Immutable List: " + immutableList.toString());

        // immutableList.add("Julia"); isso dá erro

        System.out.println("Immutable List: " + immutableList.toString());

        // Propriedade imutável de Array

        List<String> products = new ArrayList<>();
        products.add("Mesa");
        products.add("Cadeira");

        ImmutableOrder immutableOrderWithList = new ImmutableOrder(products);

        System.out.println(immutableOrderWithList.getProducts().toString());

    }
}
