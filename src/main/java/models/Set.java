package models;

public class Set{
    public final long workoutExerciseId;
    public long id;
    public WorkoutExercise we;
    public int weight;
    public int reps;

    public Set(long id, WorkoutExercise we, int weight, int reps){
        this.id = id;
        this.we = we;
        this.weight = weight;
        this.reps = reps;
        workoutExerciseId = we.id();
    }


}
