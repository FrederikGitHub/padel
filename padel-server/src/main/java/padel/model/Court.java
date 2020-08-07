package padel.model;


import java.util.Objects;

public class Court {
    private long id;
    private String name;

    public Court(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Court setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Court setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Court{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Court court = (Court) o;
        return id == court.id &&
                Objects.equals(name, court.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
