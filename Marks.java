package GravyT;

public enum Marks {
    X("X"),
    O("O"),
    EMPTY(".");

    private final String name;

    Marks(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}