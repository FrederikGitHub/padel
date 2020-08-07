package padel.model;

import java.util.Objects;

public class Poule {
    private long id;

    public Poule(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Poule setId(long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Poule{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poule poule = (Poule) o;
        return id == poule.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
