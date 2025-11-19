public class ImmutableOrder {
    private final String status;
    private final List<String> products;

    public ImmutableOrder(String status) {
        this.status = status;
    }

    public ImmutableOrder(List<String> products) {
        this.products = products;
    }

    public String getStatus() {
        return this.status;
    }

    public List<String> getProducts() {
        return this.products;
    }
}
