package backend.services;

import backend.repositories.ExerciseRepo;
import backend.repositories.WorkoutRepo;
import models.Exercise;
import models.Workout;

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

    public List<Exercise> getAllExercises() {
        return exerciseRepo.getExercises();
    }
    public Exercise getExerciseInfo(int id) {
        return exerciseRepo.getExercise(id);
    }


}
