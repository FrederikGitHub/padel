package padel.model;

public enum ReservationType {
    FIXED  ("FIXED"),
    POULE("POULE");

    private final String name;

    private ReservationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReservationType{" +
                "name='" + name + '\'' +
                '}';
    }
}
