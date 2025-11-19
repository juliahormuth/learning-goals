public class ImmutableOrder {
    private final String status;

    public ImmutableOrder(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
