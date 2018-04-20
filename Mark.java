package gravyt;

public enum Mark {
    X("X"),
    O("O"),
    EMPTY(".");

    private final String name;

    Mark(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}