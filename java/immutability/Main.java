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
    }
}
