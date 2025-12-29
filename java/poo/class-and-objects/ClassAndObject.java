public class ClassAndObject {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Caneta c1 = new Caneta();
        c1.modelo = "Bic";
        c1.cor = "Azul";
        c1.ponta = 0.5f;
        c1.tampar();
        c1.status();
    }
}