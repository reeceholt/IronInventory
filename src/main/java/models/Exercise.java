package models;

public record Exercise(int id, String name, String muscles) {

    @Override
    public String muscles() {
        return muscles;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }


}

