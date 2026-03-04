package models;

public record Exercise(long id, String name, String muscles) {

    @Override
    public String muscles() {
        return muscles;
    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }


}

