package models;

public record Workout(int id, String name, String notes) {

    @Override
    public String name() {
        return name;
    }

    @Override
    public int id() {
        return id;
    }
}
