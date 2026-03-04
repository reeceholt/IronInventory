package backend.services;

import backend.repositories.ExerciseRepo;
import backend.repositories.WorkoutRepo;
import models.Exercise;
import models.Workout;
import ui.windows.NewWorkoutWindow;

import java.util.List;

public class WorkoutService {
    private final WorkoutRepo repo;
    private final ExerciseRepo exerciseRepo;
    public WorkoutService(WorkoutRepo workoutRepo, ExerciseRepo exerciseRepo) {
        repo = workoutRepo;
        this.exerciseRepo = exerciseRepo;
    }

    public List<Workout> getAllWorkouts() {
        return repo.getWorkouts();
    }
    public Workout getWorkoutInfo(int id) {return repo.getWorkout(id);}

//    public void setNewWorkoutInfo(int id) { repo.getNewWorkout();}

    public List<Exercise> getAllExercises() { return exerciseRepo.getExercises(); }
    public Exercise getExerciseInfo(long id) {
        return exerciseRepo.getExercise(id);
    }
    public long addExercise(Exercise exercise) {
        return exerciseRepo.addExercise(exercise);
    }


}
