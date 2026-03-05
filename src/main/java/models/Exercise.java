package models;

public class Exercise {
    private long id;
    private String name;
    private String muscles;


    public Exercise(long id, String name, String muscles){
        this.id=id;
        this.name = name;
        this.muscles = muscles;
    }

    public Exercise(Exercise e){
        this.id=e.id();
        this.name = e.name();
        this.muscles = e.muscles();
    }


    public String muscles() {
        return muscles;
    }


    public long id() {
        return id;
    }


    public String name() {
        return name;
    }


}

